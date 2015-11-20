package edu.irabank.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import edu.irabank.dto.AccountDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.UserRegistrationFormBean;
import edu.irabank.service.AccountService;
import edu.irabank.service.UserService;


	@Controller
	public class AccountDetailsController 
	{
		
		@Autowired
		private AccountService accountService;  

		
		// GET Method of Listing Accounts - shows the page.
		// Shows all the accounts - for admin only
				@RequestMapping(value="/admin/listAccounts", method = RequestMethod.GET)
				public String listAllAccounts(ModelMap model) {
					

					model.put("AccountDetailsDTO", new AccountDetailsDTO());
					model.put("accountsList", accountService.listAccounts());
					System.out.println("in controller GET : ");
					
					return "/admin/listAccounts";
				}
		
				// Individual User.	
				@RequestMapping(value="/user/showAccountInfo", method = RequestMethod.GET)
				public String Accounts(ModelMap model, SessionStatus status, HttpSession sessionID) {
					Integer userId = (Integer)sessionID.getAttribute("userId");
					
					model.put("AccountDetailsDTO", new AccountDetailsDTO());
					model.put("showAccountInfo",accountService.showAccountInfo(userId));
					
					
					return "/ExternalUsers/showAccountInfo";
				}

			
		
		}
	