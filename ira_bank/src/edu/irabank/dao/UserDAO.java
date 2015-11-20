package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;

public interface UserDAO {

	public String getPassword(String userID);
	/*public String getPassword(Integer userID); //Used in PkiServiceImpl
*/	public String getPublicKey(Integer userId); //Used in PkiServiceImpl
	public String getuserName(Integer userID); //Used in PkiServiceImpl
	public UserDTO getUserDTOByUsername(String userName);
	public UserDTO getUserDTOByUserId(Integer userId);
	public Boolean addNewUser(UserDTO userDTO); // Pass user object as an argument
	public List<UserDTO> listUsers();
	public void deleteUser(Integer userId);
	public Boolean updateUserDetails(UserDTO userDTO);
	public boolean resetFailAttempts(String userName);
	public void updateFailAttempts(String userName);
	public Integer getLoginAttempts(String name);
	public void updateUserDetailsSaveorUpdate(UserDTO userDTO);

	
	public Integer retrieveUserID(String userName);
	public UserDTO getUserDTOByEmailId(String EmailId);

	public Boolean storeOtp(UserDTO userDTO);
	public Boolean updatepassword(UserDTO userDTO);
	
	

}
