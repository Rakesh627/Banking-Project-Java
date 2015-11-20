package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;


public interface AccountDetailsDAO {

	public Double getBalance(String accntno);
	public boolean getAccountNum(String accountNO);
	public String getAccountNumbyUserID(Integer Userid);
	boolean updateBalance(String accountno, Double balance);

}
