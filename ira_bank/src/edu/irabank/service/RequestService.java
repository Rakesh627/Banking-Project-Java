package edu.irabank.service;

import java.util.List;

import edu.irabank.controller.UserDetailsController;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
//why two form bean?
//commenting
/*import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.form.UserRegistrationFormBean;*/
import edu.irabank.form.IssueFormBean;

public interface RequestService {

	
	
	// Add new issue
	public boolean addNewIssue(IssueFormBean issueFormBean, UserDTO userDTO);
	public List <RequestDetailsDTO> listIssues();
	public List <RequestDetailsDTO> listMyIssues(Integer userId);
}
