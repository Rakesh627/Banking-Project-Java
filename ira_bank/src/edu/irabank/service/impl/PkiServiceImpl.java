package edu.irabank.service.impl;


import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;


import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.crypto.Cipher;
import javax.servlet.http.HttpSession;


import sun.misc.BASE64Encoder;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import edu.irabank.dao.UserDAO;

import edu.irabank.service.PkiService;

/**
 * @author Ishaan Sharma
 *
 */

@Service
public class PkiServiceImpl implements PkiService {
	
@Autowired
private UserDAO userDAO;

@Autowired
private JavaMailSender mailSender;
	
	//Generate public/private keyPair
	
	@Override
	@Transactional
	public String KeyPairGenerator(String registeredEmail){
		
		KeyPairGenerator generateKeys = null;
		
		try{
			
			generateKeys = KeyPairGenerator.getInstance("RSA");
			generateKeys.initialize(2048);
			
			KeyPair keyPair = generateKeys.generateKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			BASE64Encoder encoder = new BASE64Encoder();

			X509EncodedKeySpec  publicKeyInfo = keyFactory.getKeySpec(keyPair.getPublic(),
					X509EncodedKeySpec.class);
			
			//create publicKey
			String pbKey = encoder.encode(publicKeyInfo.getEncoded());

			PKCS8EncodedKeySpec  privateKeyInfo = keyFactory.getKeySpec(
					keyPair.getPrivate(), PKCS8EncodedKeySpec .class);
			
			
			//create private key
			String prKey = encoder.encode(privateKeyInfo.getEncoded());
			System.out.println(("******Your private key for IRA BANK is******** "+"\n"+prKey));
			
			
					
			
			//Send an email to the user
			SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(registeredEmail);
	        email.setSubject("Your private Key");
	        email.setText("******Your private key for IRA BANK is******** "+"\n"+prKey+"\n"+""+"Please store at a secure location");
	        
	        mailSender.send(email); 
			
			//Return the public key to the new User registration object
			return pbKey;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null; // Unreachable code !!
	}
	
	@Override
	@Transactional
	public String sendEncryptedPaymentInfo(Integer userId, String alias_privateKey) 
	{
	
		
		//get corresponding userName of userID
		String userName = userDAO.getuserName(userId);
		
		try
		{
			
		com.sun.org.apache.xml.internal.security.Init.init(); // Initialize xml internal security init method
		
		byte[] _byte = Base64.decode(alias_privateKey);
	
		
		PKCS8EncodedKeySpec privateKeyInfo = new PKCS8EncodedKeySpec(_byte);
	
		KeyFactory factory = KeyFactory.getInstance("RSA");
		
		PrivateKey privateKey = factory.generatePrivate(privateKeyInfo);
	//	System.out.println(("**************privateKEY VALUE************"+privateKey));
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey); // Encrypting the userName with private key
		
		byte[] test =  cipher.doFinal(Base64.decode(userName));
		
		BASE64Encoder b64 = new BASE64Encoder();
		String encryptedPayment= b64.encode(test);
		
		//boolean test2 = DecryptPaymentInfo(userId, en); //test both services.
		
		return encryptedPayment;
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@Transactional
	public boolean DecryptPaymentInfo(Integer userId, String paymentReceipt)
	{
		//get corresponding public Key of userID
		String alias_publicKey = userDAO.getPublicKey(userId);
		
		byte[] decryptedPayment = null;
			try {
				decryptedPayment= Base64.decode(paymentReceipt);
			} catch (Base64DecodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String userName = userDAO.getuserName(userId); //get corresponding userName from the DTO
		
		try
		{
	
		byte[] _byte = Base64.decode(alias_publicKey);
		X509EncodedKeySpec publicKeyInfo = new X509EncodedKeySpec(_byte);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = factory.generatePublic(publicKeyInfo);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, publicKey); // Decrypting paymentReceipt with public Key
		
		byte[] decryptedUserName = cipher.doFinal(decryptedPayment);
		
		String decryptedUsername= Base64.encode(decryptedUserName);
		
		
		if(decryptedUsername.equals(userName)) //Check authenticity of the user
		{
			return true; //Approve the payment
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return false;
	}
}
