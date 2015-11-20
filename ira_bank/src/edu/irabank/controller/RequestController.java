package edu.irabank.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;



// Import the related DTO and services
// TODO: add DTO and services 







//DTO to be done??
import edu.irabank.dto.UserDTO;
import edu.irabank.form.IssueFormBean; 
import edu.irabank.service.RequestService;


	@Controller
	@SessionAttributes
//	@RequestMapping("newuser")
	public class RequestController 
	{
		
		@Autowired
		private RequestService requestService;  // Autowire the User Service
		
		
		// GET Method of Register - shows the page.
		
		@RequestMapping(value="/ExternalUsers/Issues", method = RequestMethod.GET)
		public String createNewUser(ModelMap model) {
			// redirect to the Issues.jsp
			return "/ExternalUsers/Issues";
			//return "pages/ExternalUsers/Issues";
		}
		
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="/ExternalUsers/Issues", method = RequestMethod.POST)
		
		
		public ModelAndView createNewRequest(@ModelAttribute("issueFormBean") @Valid IssueFormBean issueFormBean,  BindingResult result, ModelMap model, SessionStatus status, HttpSession sessionID) {
			ArrayList<String> errorCode = new ArrayList<String>();
			if (result.hasErrors()){
				System.out.println("comes in form errors of issues");
				//model.addAttribute("issueStatus", "Please fill the necessary fields and try again");
				model.addAttribute("issueFormBean",issueFormBean);
				return new ModelAndView( "/ExternalUsers/Issues",model);
			}
			Boolean serverValidationError = false;
			if(issueFormBean.getDescription()==""|| !issueFormBean.getDescription().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the description. It is not in expected format.");
				model.addAttribute("issueStatus",errorCode);
				serverValidationError = true;
			}
			// use the Form Elements values from Issue form
			//Calling add new issue method of issueFormBean
			
			//getting the userID from session
			Integer userId = (Integer) sessionID.getAttribute("userId");
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(userId);
			if(serverValidationError){
				
				return new ModelAndView("/ExternalUsers/Issues", model); // return back to register
			}
			if(!serverValidationError)
			{
			Boolean issueCreationStatus = requestService.addNewIssue(issueFormBean, userDTO);
			System.out.println("issueCreationStatus is :" + issueCreationStatus);
				if(issueCreationStatus){
				 model.addAttribute("issueCreationStatus", "Issue submitted successfully");
//					model.addAttribute("userName", userRegistrationFormBean.getUserName());
//					System.out.println("63 : comes till here");
//					//return new ModelAndView(new RedirectView("Welcome"));
				return new ModelAndView("/ExternalUsers/Issues", model); // Login page
				}
			    else{
				model.addAttribute("issueCreationStatus", "There seems to be some connection issues. Please try again");
				return new ModelAndView("/ExternalUsers/Issues", model); // return back to issues page				
				}

	 
		}
			return new ModelAndView("/ExternalUsers/Issues", model);
	}
	}
	
