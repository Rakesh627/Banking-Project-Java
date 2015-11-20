package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.irabank.dao.RequestDetailsDAO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Rakesh Subramanian
 *
 */

@Repository
public class RequestDetailsDAOImpl implements RequestDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Override
	public RequestDetailsDTO getRequestByReqID(int reqId)//use request id to reference with Request Detials table
	{RequestDetailsDTO reqDTO = new RequestDetailsDTO();
		try{
			
			
		System.out.println("Entered Try Loop for Get Request By reqId");
				
			
		Query query = getSession().getNamedQuery("RequestDetailsDTO.findByReqId");
		System.out.println("TransId here: " + reqId);
		
		query.setParameter("reqId", reqId);
		 reqDTO = (RequestDetailsDTO) query.uniqueResult();
		
		}
		catch(Exception e){System.out.println("Exception"+e);}
		

		return reqDTO;
		
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequestDetailsDTO> listTransactions() {
		// TODO Auto-generated method stub
		System.out.println("listing users");
		return getSession().createCriteria(RequestDetailsDTO.class).list();
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
	public void deleteRequest(Integer reqId) {
		
//		/UserDTO delUser = new UserDTO();
		RequestDetailsDTO delUser = getRequestByReqID(reqId); 
		try{
			getSession().delete(delUser); 
		}
		
		catch(Exception e){
			System.out.println("the exception is" + e);
		}
	}
		
	
	
}
