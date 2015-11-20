package edu.irabank.service;

import java.util.List;

import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.InternalTransactionFormBean;

public interface InternalTransactionService {

	


	

	List<RequestDetailsDTO> listTransactions();

	boolean setTransactionDetails(
			InternalTransactionFormBean internalTransactionFormBean,
			int userId, boolean isAuthorized, String transId, String[] split,
			String reqId);





	boolean createTransactions(
			InternalTransactionFormBean internalTransactionFormBean,
			int userId, TransactionDetailsDTO transDTO, boolean isAuthorized);

	RequestDetailsDTO getRequestByReqID(Integer reqId);

	void deleteTransaction(Integer reqId);



	//boolean setRequestDetails(InternalTransactionFormBean sampTransFormBean, int userId);
}
