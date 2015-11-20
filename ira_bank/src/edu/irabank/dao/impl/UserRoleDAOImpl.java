package edu.irabank.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import antlr.collections.Stack;
import edu.irabank.dao.UserDAO;
import edu.irabank.dao.UserRoleDAO;
import edu.irabank.dto.RolesDTO;
import edu.irabank.dto.UserDTO;

/**
 * @author Ramki Subramanian
 *
 */

@Repository
public class UserRoleDAOImpl implements UserRoleDAO 	
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
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

	
	@Override
	public RolesDTO getUserRoleDTOById(Integer RoleId) {
		// TODO Auto-generated method stub
		System.out.println("28 : getRole Id " + RoleId);
		Session session = sessionFactory.getCurrentSession();
		String queryString = "SELECT r FROM RolesDTO r WHERE r.roleId = :roleId";
		Query query = session.createQuery(queryString);
		query.setParameter("roleId", RoleId);
		
		RolesDTO rolesDTO = (RolesDTO) query.uniqueResult();
		try{
		System.out.println("query : " + query);
		System.out.println("Retrieved Role Name = " + rolesDTO.getRoleName());
		}
		
		
		catch(Exception e){
		System.out.println("62: the exception is " + e);
		e.printStackTrace();
		}
		return rolesDTO;
	
}
}


