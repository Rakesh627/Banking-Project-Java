package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.UserDAO;
import edu.irabank.dao.UserRoleDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.RolesDTO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RolesDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.form.UserRegistrationFormBean;
import edu.irabank.service.AccountService;
import edu.irabank.service.PkiService;
import edu.irabank.service.UserService;



import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	

	@Autowired
	private AccountService acctService;
	
	@Autowired
	public PkiService pkiService;
	

	
	@Transactional
	public boolean validateUser(String inputUserName, String inputPassword)
	{
		
		BCryptPasswordEncoder bdecrypt = new  BCryptPasswordEncoder();
		String encryptedPassword = bdecrypt.encode(inputPassword);
		//System.out.println("inputUserName" + inputUserName + "passwd " + inputPassword);
		String userPassword = userDAO.getPassword(inputUserName);
		Boolean b_match = bdecrypt.matches(inputPassword, userPassword);
		/*System.out.println("b_match" + b_match);*/
		if(!userPassword.isEmpty())
		{
			if(userPassword.equals(encryptedPassword) || b_match)
			{
				return true;
			}
			else{
				System.out.println("password did not match");
			}
		}
		return false;
	}

	@Transactional
	// For Login functionality 
	public UserDTO getUserDTOByUsername(String userName)
	{
		return userDAO.getUserDTOByUsername(userName);
	}

	@Override
	@Transactional
	// Register a new User
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean) {
		
		
		UserDTO newUser = new UserDTO();
		newUser.setFirstName(userRegistrationFormBean.getFirstName());
		newUser.setLastName(userRegistrationFormBean.getLastName());
		newUser.setContactNum(userRegistrationFormBean.getContactNum());
		newUser.setAddress(userRegistrationFormBean.getAddress());
		newUser.setUserName(userRegistrationFormBean.getUserName());
		BCryptPasswordEncoder bcrypt = new  BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(userRegistrationFormBean.getPassword());
		newUser.setPassword(encryptedPassword);
		newUser.setDob(userRegistrationFormBean.getDob());
		newUser.setEmailId(userRegistrationFormBean.getEmailId());
	
		newUser.setSecAns1(userRegistrationFormBean.getSecAns1());
		newUser.setSecAns2(userRegistrationFormBean.getSecAns2());
		newUser.setSecQue1(userRegistrationFormBean.getSecQue1());
		newUser.setSecQue2(userRegistrationFormBean.getSecQue2());
		newUser.setSsn(userRegistrationFormBean.getSsn());
		newUser.setSitekey(userRegistrationFormBean.getSitekey());
		newUser.setIs_ok_pii(userRegistrationFormBean.getIs_ok_pii());
		// TODO : this is not the way to go ahead with Roles.
		// Check if the User is Regular user , then assign him the ROLE_USER
		// Check if the User is a Merchant , assign him the ROLE_MERCHANT
		// This needs spring security?  check it. 
		
		
		
		RolesDTO rolesDTO = new RolesDTO();
		rolesDTO = userRoleDAO.getUserRoleDTOById(userRegistrationFormBean.getRole());
		newUser.setRoleId(rolesDTO);

		//*************************PKI DO NOT TOUCH*********************************
		//Private key to be sent to this email
		String registeredEmail = userRegistrationFormBean.getEmailId();
		String publicKey = pkiService.KeyPairGenerator(registeredEmail);
		
		// Adding Public key to DB
		newUser.setPublicKey(publicKey);
		//*************************PKI DO NOT TOUCH*********************************
		
		
		
		// TODO check here if the user is already present	
		// Add this newly created UserDTO Object into the DB. 
		Boolean isUserRegisted = userDAO.addNewUser(newUser);
		
		
		System.out.println("userid is:="+newUser.getUserId());
		
		if(!isUserRegisted) {
			System.out.println("Some issues in User Registration, Please try again later!");
			return false;
		}
		
		else{
			// TODO 1. Think about generating an autogen account number here 
			// through acctnumber service or 2. send a notification to admin
			// to accept and assign an acct number for this user.
 			System.out.println("User registered successfully");
 			String role = newUser.getRoleId().toString();
 			System.out.println("Role id :" + role.toString());
			rolesDTO = newUser.getRoleId();	
			System.out.println("retrieveduserDTO.getRoleName() :" + rolesDTO.getRoleName());
 			if ((rolesDTO.getRoleName().equals("ROLE_USER")) || (rolesDTO.getRoleName().equals("ROLE_MERCHANT"))){
 			//Now Adding an account for only user and merchant
 			System.out.println("comes for user and merchant account creation");	
 			acctService.addNewAccount(newUser);
 			}
 			return true;
		}
		
	}

	@Override
	@Transactional
	public Boolean updateUserDetails(UserDetailsFormBean userDetailsFormBean) {
	
		UserDTO newUser = new UserDTO();
		newUser.setFirstName(userDetailsFormBean.getFirstName());
		newUser.setLastName(userDetailsFormBean.getLastName());
		newUser.setContactNum(userDetailsFormBean.getContactNum());
		newUser.setAddress(userDetailsFormBean.getAddress());
		newUser.setUserName(userDetailsFormBean.getUserName());
		newUser.setEmailId(userDetailsFormBean.getEmailId());
		newUser.setSecAns1(userDetailsFormBean.getSecAns1());
		newUser.setSecAns2(userDetailsFormBean.getSecAns2());
		newUser.setSecQue1(userDetailsFormBean.getSecQue1());
		newUser.setSecQue2(userDetailsFormBean.getSecQue2());
		
		//newUser.setRoleId(userDetailsFormBean.getRoleId());	
		
		/*RolesDTO rolesDTO = new RolesDTO();
		rolesDTO = userRoleDAO.getUserRoleDTOById(userDetailsFormBean.getRoleId());
		newUser.setRoleId(rolesDTO);
		*/
		
		
		//TODO - currently these are hidden,so using like these.
		// Currently converting string into datetime object.
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/dd/yyyy");
        try
        {
        	 String str = userDetailsFormBean.getDob();
            System.out.println("Selected date is " + str);
            Date date = simpleDateFormat.parse(str);
             System.out.println("Parsed date is " + date);
            newUser.setDob(date);
            System.out.println("date parsed: "+simpleDateFormat.format(date));
        }
        catch (ParseException e)
        {
            System.out.println("Exception "+e);
        }*/
		
		//newUser.setDob(userDetailsFormBean.getDob());
		//newUser.setPassword(userDetailsFormBean.getPassword());
		// newUser.setUserId(userDetailsFormBean.getUserId());
		
		
		
		// Get the existing values from DB and set it.
		UserDTO tempUserDTO = getUserDTOByUserId(userDetailsFormBean.getUserId());
		newUser.setDob(tempUserDTO.getDob());
		newUser.setPassword(tempUserDTO.getPassword());
		newUser.setUserId(tempUserDTO.getUserId());
		RolesDTO rolesDTO = new RolesDTO();
		rolesDTO = userRoleDAO.getUserRoleDTOById(userDetailsFormBean.getRoleId());
		newUser.setRoleId(rolesDTO);
	     
		System.out.println("Comes till here : 156 of UserServiceUpdateDetails" + newUser.getDob());
		Boolean isUserUpdated = userDAO.updateUserDetails(newUser);
		if(!isUserUpdated) {
			System.out.println("Some issues in updating user details, Please try again later!");
			return false;
		}
		
		else{
			
 			System.out.println("User updated successfully");
 			return true;
		}
		


		
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> listUsers() {
		// TODO Auto-generated method stub
		List userList = userDAO.listUsers();
		System.out.println("userList in Service" + userList);
		return userList;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO getUserinfo(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		userDAO.deleteUser(userId);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public UserDTO getUserDTOByUserId(Integer reqId) {
		// TODO Auto-generated method stub
		return userDAO.getUserDTOByUserId(reqId);
	}

	
	@Override
	@Transactional
	public UserDTO getUserDTOByEmailId(String emailId) {
		
		System.out.println("comes in Service" + emailId);
		return userDAO.getUserDTOByEmailId(emailId);
	}

	@Override
	@Transactional
	public boolean storeotp(UserDTO userdto) {
		 boolean status=userDAO.storeOtp(userdto);
		 return true;
		
	}

	@Override
	@Transactional
	public boolean updatepassword(UserDTO retrievedDTO) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bcrypt = new  BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(retrievedDTO.getPassword());
		retrievedDTO.setPassword(encryptedPassword);
		 boolean status=userDAO.updatepassword(retrievedDTO);
		 return true;
	}


		

}
