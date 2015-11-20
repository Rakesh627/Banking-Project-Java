package edu.irabank.service.impl; 

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.irabank.dao.UserDAO;
import edu.irabank.dao.UserRoleDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.RolesDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.form.UserRegistrationFormBean;
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
public class UserDetailsServiceImpl implements UserDetailsService
{
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	// Spring security methods to load the user by his name.
	// Based on : http://www.javaroots.com/2013/03/how-to-use-custom-dao-classe-in-spring.html
		@Override
		@Transactional
		public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException, DataAccessException 
		{
		   User user = null;
			System.out.println("Comes in loadUserByUsername" + userName);
			if ( userName != null && !userName.isEmpty()){ 
				UserDTO retrieveduserDTO = userDAO.getUserDTOByUsername(userName);
				
				if (retrieveduserDTO == null)
				{
					throw new UsernameNotFoundException("User not found. Please try again");
				}
				
				System.out.println("retrieved the userDTO");
				user = getUserDTOforSpringSecurity(retrieveduserDTO);
			}
			
			return user;
		
		}
	
		// Spring Security Method to build user from retrieved userDTO.

		@Transactional
		public User getUserDTOforSpringSecurity(UserDTO userDTO) 
		{
			System.out.println("Comes in getUserDTOforSpringSecurity" + "userDTO:" +  userDTO);
			String username = userDTO.getUserName();
			String password = userDTO.getPassword();
			System.out.println("till here" + username +password);
			
			//TODO change the defaults in the table and change in the register.
			//boolean enabled = userDTO.getActiveStatus();
			//boolean accountNonExpired = userDTO.getAcctLockedStatus();
			//boolean credentialsNonExpired = userDTO.getActiveStatus();
			//boolean accountNonLocked = true;
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			
			// Check the Login attempts.
			if(userDTO.getLoginAttempts()!= null && userDTO.getLoginAttempts() >= 5)
			{
				accountNonLocked = false;
			}
			
			System.out.println("Details: 261 : Authorities " + accountNonLocked + credentialsNonExpired + enabled + username + password);
			
			// Create authorities and return a user object.
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			if(userDTO.getRoleId()!= null)
			{
				RolesDTO rolesDTO = new RolesDTO();	
				rolesDTO = userDTO.getRoleId();	
				System.out.println("retrieveduserDTO.getRoleName() :" + rolesDTO.getRoleName());
				authorities.add(new SimpleGrantedAuthority(rolesDTO.getRoleName()));
			}
			
			
			System.out.println("authorities::" + authorities);
				
			User user = new User(username, password, enabled,accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			System.out.println("User Object:" + user);
			return user;
		}
		

}
