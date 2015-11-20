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
import edu.irabank.form.EditProfileFormBean; 
import edu.irabank.service.EditProfileService;


	@Controller
	@SessionAttributes
//	@RequestMapping("newuser")
	public class EditProfileController 
	{
		
		@Autowired
		private EditProfileService editProfileService;  // Autowire the User Service
		
		
		// GET Method of Register - shows the page.
		
		@RequestMapping(value="/ExternalUsers/EditProfile", method = RequestMethod.GET)
		public String editProfile(ModelMap model) {
			// redirect to the editProfile.jsp
			return "/ExternalUsers/EditProfile";
			
		}
		
		
		
		// POST Method of Register - comes back after the submit of User Details Form.
		@RequestMapping(value="/ExternalUsers/EditProfile", method = RequestMethod.POST)
		
		
		public ModelAndView createNewRequest(@ModelAttribute("editProfileFormBean") @Valid EditProfileFormBean editProfileFormBean,  BindingResult result, ModelMap model, SessionStatus status, HttpSession sessionID) {
			ArrayList<String> errorCode = new ArrayList<String>();
			if (result.hasErrors()){
				System.out.println("comes in form errors of issues");
				//model.addAttribute("issueStatus", "Please fill the necessary fields and try again");
				model.addAttribute("editProfileFormBean",editProfileFormBean);
				return new ModelAndView( "/ExternalUsers/EditProfile",model);
			}
			Boolean serverValidationError = false;
			if(editProfileFormBean.getemailId()==""|| !editProfileFormBean.getemailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			{
				errorCode.add("Please check the email. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			if(editProfileFormBean.getuserName()==""| !editProfileFormBean.getuserName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the email. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			// use the Form Elements values from Issue form
			//Calling add new issue method of issueFormBean
			if(editProfileFormBean.getfirstName()==""|| !editProfileFormBean.getfirstName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the First Name. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			if(editProfileFormBean.getlastName()==""|| !editProfileFormBean.getlastName().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Last Name. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			if(editProfileFormBean.getaddress()==""|| !editProfileFormBean.getaddress().matches("^[a-zA-Z0-9 ,.]+$"))
			{
				errorCode.add("Please check the Address. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			if(editProfileFormBean.getcontactNum()==""|| !editProfileFormBean.getcontactNum().matches("^[0-9 -]+$"))
			{
				errorCode.add("Please check the Contact No. It is not in expected format.");
				model.addAttribute("editStatus",errorCode);
				serverValidationError = true;
			}
			if(serverValidationError){
				
				return new ModelAndView("/ExternalUsers/EditProfile", model); // return back to register
			}
			//getting the userID from session
			if(serverValidationError!=true)
			{
			Integer userId = (Integer) sessionID.getAttribute("userId");
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(userId);
			
			
			Boolean updateStatus = editProfileService.editProfile(editProfileFormBean,sessionID);
			System.out.println("updateStatus is :" + updateStatus);
				if(updateStatus){
				 model.addAttribute("updateStatus", "Profile updated successfully");
//					model.addAttribute("userName", userRegistrationFormBean.getUserName());
//					System.out.println("63 : comes till here");
//					//return new ModelAndView(new RedirectView("Welcome"));
				return new ModelAndView("/ExternalUsers/EditProfile", model); // Login page
				}
			    else{
				model.addAttribute("updateStatus", "There seems to be some connection issues. Please try again");
				return new ModelAndView("/ExternalUsers/EditProfile", model); // return back to issues page				
				}

	 
		
			
	
	}
			return new ModelAndView("/ExternalUsers/EditProfile", model);
	}
	}
	

