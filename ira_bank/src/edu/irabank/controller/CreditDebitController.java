package edu.irabank.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dto.TransactionDetailsDTO;
import edu.irabank.form.AccountFormBean;
import edu.irabank.service.TransactionService;


	@Controller
	@SessionAttributes
	@RequestMapping("ExternalUsers")
	public class CreditDebitController 
	{
		
		@Autowired
		private TransactionService transactionService; 

		
		// GET Method of Credit/Debit Form
		
		@RequestMapping(value="/credit_debit", method = RequestMethod.GET)
		public String createNewCreditDebit(HttpSession sessionID, HttpServletRequest request) {
			
			// Account Number is auto populated.
			String userName = (String)sessionID.getAttribute("userName");
			System.out.println("userName is:" + userName);
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println("userID is:" + userId);
			String Accountnum = transactionService.getAccountNumberbyUserID(userId);
			request.setAttribute("TextValue",Accountnum);
			
			// redirect to the CreditDebit.jsp
			System.out.println("comes at credit_debit get method");
			return "/ExternalUsers/credit_debit";
		}
		
		// Post Method after submitting Account details in CreditDebit Form
		@RequestMapping(value="/credit_debit", method=RequestMethod.POST)
	    public ModelAndView accountCreditDebit(@ModelAttribute("accountFormBean")@Valid AccountFormBean accountFormBean,  BindingResult result, ModelMap model, SessionStatus status, HttpSession sessionID, HttpServletRequest request)
	    {
			
			String userName = (String)sessionID.getAttribute("userName");
			System.out.println("userName is:" + userName);
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println("userID is:" + userId);
			String Accountnum = transactionService.getAccountNumberbyUserID(userId);
			request.setAttribute("TextValue",Accountnum);
			// Arraylist option for displaying errors.
			
						ArrayList<String> errorCode = new ArrayList<String>();
						
						// Case 1: JSR303 validation. Checks for Hibernate related form issues.
						
						if (result.hasErrors()){
							System.out.println("comes in form errors of Credit Debit");
							model.addAttribute("accountStatus", "Please fill the necessary fields and try again");
							model.addAttribute("accountFormBean",accountFormBean);
							request.setAttribute("TextValue",Accountnum);
							return new ModelAndView( "/ExternalUsers/credit_debit",model);
						}
						
						// Case 2 : Server-side validation : Start the validation before pressing the submit button.
				
						Boolean serverValidationError = false;
						
						// Check for all the UserRegistrationFormBean values.
						if(accountFormBean.getAccountNumber()==null || !accountFormBean.getAccountNumber().matches("^[0-9 -]+$"))
						{
							errorCode.add("Please check the Account Number. It is not in expected format.");
							model.addAttribute("accountStatus",errorCode);
							request.setAttribute("TextValue",Accountnum);
							serverValidationError = true;
						}
						
						if(Double.valueOf(accountFormBean.getAmount())==null || !Double.valueOf(accountFormBean.getAmount()).toString().matches("[0-9]{1,13}(\\.[0-9]*)?"))
						{
							errorCode.add("Please check the Amount. It is not in expected format.");
							model.addAttribute("accountStatus",errorCode);
							request.setAttribute("TextValue",Accountnum);
							serverValidationError = true;
						}
						
						// Go back to credit debit page with these validation errors.
						if(serverValidationError){
							request.setAttribute("TextValue",Accountnum);
							return new ModelAndView("/ExternalUsers/credit_debit", model); // return back to register
						}
						

						
						if(!serverValidationError)
						{
							
							System.out.println("comes at credit_debit post method");
							System.out.println("balance from formbean account" + accountFormBean.getAccountNumber());
							System.out.println("balance from formbean" + accountFormBean.getAmount());
							double balAnce = Double.parseDouble(accountFormBean.getAmount());
			
							String type = accountFormBean.getCreditDebit();
							boolean isAccountExist = transactionService.getAccountNumber(Accountnum);
			
							if(balAnce <= 0)
							{
								System.out.println("Enter a valid Amount ");
								model.addAttribute("accountStatus", "Please enter a valid Amount");
								model.addAttribute("accountFormBean",accountFormBean);
								request.setAttribute("TextValue",Accountnum);
								return new ModelAndView("/ExternalUsers/credit_debit", model);
				
							}
			
							if(isAccountExist)
							{
								System.out.println("isAccountExist" + isAccountExist);
								System.out.println("type" + type);
				
				
								if(type.equals("Credit"))
								{
									//Call CreditBalance to add the amount to the given account number
									boolean isCreditSuccess = transactionService.CreditBalance(Accountnum, balAnce);
									System.out.println("isCreditSuccess" + isCreditSuccess);
									if(isCreditSuccess == true)
									{
										System.out.println("Account Credited Successfully! ");
										model.addAttribute("accountStatus", "Account Credited Successfully!");
										model.addAttribute("accountFormBean",accountFormBean);
										request.setAttribute("TextValue",Accountnum);
										return new ModelAndView("/ExternalUsers/credit_debit", model);
					
									}
								}
								else if(type.equals("Debit"))
								{
									//	Call DebitBalance to add the amount to the given account number
									boolean isDebitSuccess = transactionService.DebitBalance(Accountnum, balAnce);
									System.out.println("isDebitSuccess" + isDebitSuccess);
									if(isDebitSuccess == true)
									{
										System.out.println("Account Debited Successfully!");
										model.addAttribute("accountStatus", "Account Debited Successfully!");
										model.addAttribute("accountFormBean",accountFormBean);
										request.setAttribute("TextValue",Accountnum);
										return new ModelAndView("/ExternalUsers/credit_debit", model);
									}
									else
									{
										System.out.println("Please Enter a valid amount!");
										model.addAttribute("accountStatus", "Please Enter a valid amount!");
										model.addAttribute("accountFormBean",accountFormBean);
										request.setAttribute("TextValue",Accountnum);
										return new ModelAndView("/ExternalUsers/credit_debit", model);
						
									}
								}
							}
						}
							model.addAttribute("accountStatus", "Please enter valid details");
							model.addAttribute("accountFormBean",accountFormBean);
							request.setAttribute("TextValue",Accountnum);
							return new ModelAndView("/ExternalUsers/credit_debit", model);
		}

	}
	 
	
