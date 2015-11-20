package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.RequestDetailsDTO;

public interface RequestDetailsDAO {

	List<RequestDetailsDTO> listTransactions();


	RequestDetailsDTO getRequestByReqID(int reqId);


	void deleteRequest(Integer userId);

}
