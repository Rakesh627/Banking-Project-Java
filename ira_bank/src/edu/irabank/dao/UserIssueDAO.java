package edu.irabank.dao;

import java.util.List;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.IssueFormBean;

public interface UserIssueDAO {
	
	public Boolean addNewIssue(RequestDetailsDTO requestdetailsdto, UserDTO userDTO); // Pass user object as an argument
	
	public List<RequestDetailsDTO> listIssues();
	public List <RequestDetailsDTO> listMyIssues(Integer userId);

}
