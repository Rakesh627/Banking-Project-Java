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
import edu.irabank.dao.AccountDetailsDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Abha Upadhyay
 *
 */


@Repository
public class AccountDetailsDAOImpl implements AccountDetailsDAO 	
{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	HttpSession sessionID;
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean getAccountNum(String accountNO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accountNO);
		query.setParameter("accountNumber", accountNO);
		System.out.println("query : " + query);
		
		try{
			String accountno = ((AccountDetailsDTO) query.uniqueResult()).getAccountNumber();
			System.out.println("query : " + query);
			System.out.println("Retrieved Accountnumber = " + accountno);
			return true;
			}			
			catch(Exception e){
			System.out.println("41 : the exception is " + e);
			e.printStackTrace();
			return false;
				
			}
		
	}
	
	@Override
	public Double getBalance(String accntno)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("AccountNo here: " + accntno);
		query.setParameter("accountNumber", accntno);
		System.out.println("query : " + query);
		Double Balance = ((AccountDetailsDTO) query.uniqueResult()).getBalance();
		return Balance;
	}
	
	@Override
	//Used in Credit and Debit to Update Balance
	public boolean updateBalance(String accountno, Double balance)	
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
		System.out.println("Balance here: " + balance);
		query.setParameter("accountNumber", accountno);
		System.out.println("query : " + query);
		((AccountDetailsDTO) query.uniqueResult()).setBalance(balance);
		return true;
	}

	@Override
	public String getAccountNumbyUserID(Integer Userid)
	{
		try{
		System.out.println("Entered Try Loop for DAO" + Userid);
				
		//get UserDTO to pass it to AccountDetails
		UserDTO userDTO = new UserDTO();
		userDTO = userDAO.getUserDTOByUserId(Userid);
			
		Query query = getSession().createQuery("SELECT a FROM AccountDetailsDTO a WHERE a.uId = :uId");
		System.out.println("userID here: " + Userid);
		
		query.setParameter("uId", userDTO);
		AccountDetailsDTO DTO = (AccountDetailsDTO) query.uniqueResult();
		String Accountnum = DTO.getAccountNumber();
		System.out.println("Account Number: "+ Accountnum);
	
		return Accountnum;
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
   
	
}




