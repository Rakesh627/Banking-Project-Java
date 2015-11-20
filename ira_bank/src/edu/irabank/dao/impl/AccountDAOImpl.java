package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.AccountDAO;
import edu.irabank.dao.UserDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;


/**
 * @author Ishaan Sharma
 *
 */

@Repository
public class AccountDAOImpl implements AccountDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDAO userDAO;
	
	
		// Save the Account to the DB and return success or failure to service.
	@Override
	public Boolean addNewAccount(AccountDetailsDTO accountdetailsDTO) {
		
		try{
		
			sessionFactory.getCurrentSession().save(accountdetailsDTO);
		
			return true;
		}
		catch (ConstraintViolationException e){
		 System.out.println("The error is "+ e);
		 e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewAccont
	
	@Override
	public AccountDetailsDTO getAccountDetailsDTOByUserID(Integer userId) {
		// TODO Auto-generated method stub
		//System.out.println("are u coming heree??");
		return null;
	}
	
	@Override
	public List<AccountDetailsDTO> listAccounts() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(AccountDetailsDTO.class).list();
	}
	
	@Override
	public AccountDetailsDTO showAccountInfo(Integer UserId){
		
		UserDTO userDTO = new UserDTO();
		userDTO = userDAO.getUserDTOByUserId(UserId);
		
		Query query = getSession().createQuery("SELECT a FROM AccountDetailsDTO a WHERE a.uId = :uId");
		
		query.setParameter("uId", userDTO);
		AccountDetailsDTO accDTO = (AccountDetailsDTO) query.uniqueResult();
		
		return  accDTO;		
	}
		
	
	@Override
	public void deleteAccount(Integer userID)
	{
		AccountDetailsDTO delAccount = getAccountDetailsDTOByUserID(userID); 
		try{
			getSession().delete(delAccount); 
		}
		
		catch(Exception e){
			System.out.println("the exception is" + e);
		}
	
	}

		
	//Used in BillpayMerchant controller
	@Override
			public UserDTO getuserId(String accountNumber)
			{
				UserDTO userDTO = new UserDTO();
				try{
					
				Session session = sessionFactory.getCurrentSession();
				Query query = session.getNamedQuery("AccountDetailsDTO.findByAccountNumber"); //using NamedQuery
				//System.out.println("userName here: " + userName);
				query.setParameter("accountNumber", accountNumber);
				System.out.println("query : " + query);
				userDTO = ((AccountDetailsDTO) query.uniqueResult()).getUId();
				System.out.println("***********userid is************"+userDTO.getUserId());
			//	return userDTO;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					 //returns null
				}
				return userDTO;
				
			}
	
	// To create/open a new session.
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



