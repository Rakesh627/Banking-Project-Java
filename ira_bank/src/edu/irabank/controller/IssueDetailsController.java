package edu.irabank.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.IssueDetailsFormBean;
import edu.irabank.form.IssueFormBean;
import edu.irabank.service.RequestService;
import edu.irabank.service.UserService;

    
	@Controller
	public class IssueDetailsController
	{
		
		@Autowired
		private RequestService requestService;  // change it to the user details related service. 
		private UserService userService;
		
		// GET Method of Listing Users - shows the page.
				@RequestMapping(value="/admin/ListIssues", method = RequestMethod.GET)				
				public String listAllIssues(ModelMap model) {
					// redirect to the ListIssues.jsp
					System.out.println("List All Issues : Controller");
					model.put("RequestDetailsDTO", new RequestDetailsDTO());
					model.put("UserDTO", new UserDTO());
				//	 List <RequestDetailsDTO> issuesList = requestService.listIssues();
					model.put("issuesList", requestService.listIssues());
					//model.put("usersList", userService.listUsers());
					//System.out.println("listUsers in controller" + issuesList );
					return "/admin/ListIssues";
				}
				@RequestMapping(value="/ExternalUsers/MyIssues", method = RequestMethod.GET)				
				public String listMyIssues(ModelMap model, SessionStatus status, HttpSession sessionID) {
					// redirect to the ListIssues.jsp
					Integer userId = (Integer)sessionID.getAttribute("userId");
					System.out.println("List My Issues : Controller");
					model.put("RequestDetailsDTO", new RequestDetailsDTO());
					
				//	 List <RequestDetailsDTO> issuesList = requestService.listIssues();
					model.put("myissuesList", requestService.listMyIssues(userId));
					
					return "/ExternalUsers/MyIssues";
				}
				
}
	 
	 
	
