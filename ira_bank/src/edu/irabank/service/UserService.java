package edu.irabank.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import edu.irabank.controller.UserDetailsController;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserService {

	// Login check
	public boolean validateUser(String userName, String password);
	public UserDTO getUserDTOByUsername(String userName);
	
	// Register User / Add User
	public boolean addNewUser(UserRegistrationFormBean userRegistrationFormBean);

	//Update/Edit User details
	public Boolean updateUserDetails(UserDetailsFormBean userDetailsFormBean);
	public UserDTO getUserDTOByUserId(Integer userId);

	//Get User(s) information
	public List<UserDTO> listUsers();
	public UserDTO getUserinfo(Integer userId); // single user DTO

    //Delete User
	public void deleteUser(Integer userId);
	public UserDTO getUserDTOByEmailId(String emailId);

	public boolean storeotp(UserDTO retrievedDTO);
	public boolean updatepassword(UserDTO retrievedDTO);
	
	

	
	
	
    
	
/*
//TODO getUserByID - returns UserDTO object
getUserByRole - returns UserDTO Object
getAllUsersbyRole  - returns a list of UserDTO objects
updateLoginAttempts - Use getLoginAttemptCount and setLoginAttemptCount
resetLoginAttempts  -  same
accessLogFile();

*/
	
}
