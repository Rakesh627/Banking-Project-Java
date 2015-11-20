package edu.irabank.dao;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;

public interface InternalTransactionDAO {

	AccountDetailsDTO getAccountsDTObyUserID(int userId);

	Boolean RequestDetailsSave(RequestDetailsDTO request);


	AccountDetailsDTO getAccountbyAccountNumber(String accountNumber);

	Boolean AccountDetailsSave(AccountDetailsDTO accountsDTO);

	AccountDetailsDTO getAccountByTransId();

	AccountDetailsDTO getAccountByTransId(int userId);

	RequestDetailsDTO getRequestDTO();



	TransactionDetailsDTO getTransDTO(int userid);

	Boolean TransactionDetailsSave(TransactionDetailsDTO transDTO);
	
	//for service access
	

}
