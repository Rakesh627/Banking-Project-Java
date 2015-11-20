package edu.irabank.controller;

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

import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.service.UserService;
    
	@Controller
	public class AdminActionsController 
	{
		
		@Autowired
		private UserService  userService;
		
		// GET Method of Showing the Log
				@RequestMapping(value="/admin/show_log", method = RequestMethod.GET)
				public ModelAndView showLog(ModelMap model) {
					// redirect to the log.jsp
					System.out.println("Comes in Log");
					return new ModelAndView("/ExternalUsers/log", model);
				}
			
		}
	 
	 
	
