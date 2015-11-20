package edu.irabank.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.TransactionDetailsDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Rakesh Subramanian
 *
 */

@Repository
public class TransactionDetailsDAOImpl implements TransactionDetailsDAO 

{
@Autowired 
private SessionFactory sessionFactory;
@Autowired
HttpSession sessionID;

@Override
public TransactionDetailsDTO getTransactionByTransID(int transId)//use request id to reference with Request Detials table
{
	try{
		
	System.out.println("Entered Try Loop for TransactionDAO");
			
		
	
	Query query = getSession().createQuery("SELECT t FROM TransactionDetailsDTO t WHERE t.transId = :transId");
	System.out.println("userID here: " + transId);
	
	query.setParameter("transId", transId);
	TransactionDetailsDTO TransDTO = (TransactionDetailsDTO) query.uniqueResult();
	System.out.println("From Account Number: "+TransDTO.getFromAcct());
	System.out.println("From Account Number: "+TransDTO.getToAcct());

	return TransDTO;
	
	}
	catch(Exception e){
		System.out.println("Exception: "+ e);
		return null;
	
	}
}
	private Session getSession() {
		Session sessionobj = getSessionFactory().getCurrentSession();
		if (sessionobj == null) {
			sessionobj = getSessionFactory().openSession();
		}
		return sessionobj;
	}
	private SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	@Override
	public Boolean TransactionDetailsSave(TransactionDetailsDTO transDTO) {
	System.out.println("Entered Save Hibernate");
	try{
		sessionFactory.getCurrentSession().save(transDTO);
		return true;
	}
	catch (Exception e){
	 System.out.println("The error is "+ e);
	 //e.printStackTrace();
	 return false;
	}
}
	
	
}





