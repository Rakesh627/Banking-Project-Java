package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.UserIssueDAO;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.dao.UserDAO;

/**
 * @author Ramki Subramanian
 *
 */

@Repository
public class UserIssueDAOImpl implements UserIssueDAO 	
{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDAO userDAO;

	/**
	 * @param userName
	 * @return Integer
	 */
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
	public Boolean addNewIssue(RequestDetailsDTO requestdetailsdto, UserDTO userDTO) {
		System.out.println("try in DAOImpl");
		// TODO check if the user is already present in service Layer
		try{
			sessionFactory.getCurrentSession().save(requestdetailsdto);
			return true;
		}
		catch (ConstraintViolationException e){
		 System.out.println("The error is "+ e);
		 //e.printStackTrace();
		 return false;	 
		}
		
	} // End of addNewIssue
	@SuppressWarnings("unchecked")
	@Override
	public List<RequestDetailsDTO> listIssues() {
		// TODO Auto-generated method stub
		System.out.println("listing issues");
		return getSession().createCriteria(RequestDetailsDTO.class).list();
	}
	
	@Override
     public List<RequestDetailsDTO> listMyIssues(Integer UserId){
		
		UserDTO userDTO = new UserDTO();
		
		userDTO = userDAO.getUserDTOByUserId(UserId);
		
		Query query = getSession().createQuery("SELECT a FROM RequestDetailsDTO a WHERE a.reqUserId = :reqUserId");
		
		query.setParameter("reqUserId", userDTO);
		List <RequestDetailsDTO> reqDTO = (List<RequestDetailsDTO>) query.list();
		
		return  reqDTO;		
	}
}



