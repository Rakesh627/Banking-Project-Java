package edu.irabank.service.impl; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jmx.snmp.Timestamp;

import edu.irabank.dao.UserIssueDAO;
import edu.irabank.dao.impl.UserDAOImpl;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.IssueFormBean;
import edu.irabank.service.RequestService;
@Service
public class UserIssueImpl implements RequestService
{
	
	@Autowired
	private UserIssueDAO userissueDAO;
	
	
	@Override
	@Transactional
	// Add a new issue
	public boolean addNewIssue(IssueFormBean IssueFormBean, UserDTO userDTO) {
		
		RequestDetailsDTO newIssue = new RequestDetailsDTO();
		newIssue.setReqDesc(IssueFormBean.getDescription());
		newIssue.setReqType(IssueFormBean.getIssue());
		newIssue.setReqPriority(IssueFormBean.getPriority());
		newIssue.setReqStatus(0);
		Date date= new Date();
		newIssue.setReqDate(date);
		
		
		newIssue.setReqUserId(userDTO);
		
	    Boolean issueSubmitted=userissueDAO.addNewIssue(newIssue, userDTO);
		if(!issueSubmitted) {
			System.out.println("Some issues in Submitting issue, Please try again later!");
			return false;
		}
		
		else{
			// TODO 1. Think about generating an autogen account number here 
			// through acctnumber service or 2. send a notification to admin
			// to accept and assign an acct number for this user.
 			System.out.println("Issue Submitted successfully");
 			return true;
		}
		
		

 }

	@Override
	@Transactional(readOnly = true)
	public List<RequestDetailsDTO> listIssues() {
		// TODO Auto-generated method stub
		List issueList = userissueDAO.listIssues();
		System.out.println("IssuesList in Service" + issueList);
		return issueList;
	}
	@Override
	@Transactional(readOnly = true)
	public List<RequestDetailsDTO> listMyIssues(Integer UserId){
		List myissuelist= userissueDAO.listMyIssues(UserId);
		return myissuelist;
		
	}
	
	
}
