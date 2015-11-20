package edu.irabank.dao;

/**
 * @author Ishaan Sharma
 *
 */

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;

public interface AccountDAO {

	
	public Boolean addNewAccount(AccountDetailsDTO accountdetailsDTO); // Pass user object as an argument
	
	public void deleteAccount(Integer userID); //Delete accountDetails of the selected account
	
	public List<AccountDetailsDTO> listAccounts(); //List All accounts from the Account_Details table
	
	public AccountDetailsDTO showAccountInfo(Integer userId); //Display account info of the current user
	
	public AccountDetailsDTO getAccountDetailsDTOByUserID(Integer userId);
	
	public UserDTO getuserId(String accountNumber);



}
