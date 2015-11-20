package edu.irabank.dao;

import java.util.List;


import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;



public interface TransactionDetailsDAO {
	
	
	

	TransactionDetailsDTO getTransactionByTransID(int reqUserId);

	Boolean TransactionDetailsSave(TransactionDetailsDTO transDTO);







}
