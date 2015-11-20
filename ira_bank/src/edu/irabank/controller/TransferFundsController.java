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

import edu.irabank.dto.UserDTO;
import edu.irabank.form.TransferFormBean;
import edu.irabank.service.AccountService;
import edu.irabank.service.PkiService;
import edu.irabank.service.TransactionService;


	@Controller
	@SessionAttributes
	@RequestMapping("ExternalUsers")
	public class TransferFundsController 
	{
		
		@Autowired
		private TransactionService transactionService; 
		
		@Autowired
		private AccountService accountService;
		
		@Autowired
		private PkiService pkiService;
		

		
		// GET Method of Transfer Funds
		@RequestMapping(value="/Transfer_funds", method = RequestMethod.GET)
		public String createNewTransfer(HttpSession sessionID, HttpServletRequest request) {
			String userName = (String)sessionID.getAttribute("userName");
			System.out.println("userName is:" + userName);
			Integer userId = (Integer)sessionID.getAttribute("userId");
			System.out.println("userID is:" + userId);
			String Accountnum = transactionService.getAccountNumberbyUserID(userId);
			request.setAttribute("TextValue",Accountnum);
			
			// redirect to the Transfer_funds.jsp
			System.out.println("comes at Transfer get method");
			return "/ExternalUsers/Transfer_funds";
		}
		
		// Post Method after submitting Account details in Transfer Form
		@RequestMapping(value="/Transfer_funds", method=RequestMethod.POST)
	    public ModelAndView accountTransfer(@ModelAttribute("transferFormBean") @Valid TransferFormBean transferFormBean,  BindingResult result, ModelMap model, SessionStatus status, HttpSession sessionID, HttpServletRequest request)
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
				System.out.println("comes in form errors of Transfer Funds");
				model.addAttribute("transferStatus", "Please fill the necessary fields and try again");
				model.addAttribute("transferFormBean",transferFormBean);
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView( "/ExternalUsers/Transfer_funds",model);
			}
			
			// Case 2 : Server-side validation : Start the validation before pressing the submit button.
	
			Boolean serverValidationError = false;
			
			// Check for all the UserRegistrationFormBean values.
			if(transferFormBean.getToaccount()==null || !transferFormBean.getToaccount().matches("^[0-9 -]+$"))
			{
				errorCode.add("Please check the Account Number. It is not in expected format.");
				model.addAttribute("transferStatus",errorCode);
				request.setAttribute("TextValue",Accountnum);
				serverValidationError = true;
			}
			
			if(Double.valueOf(transferFormBean.getAmount())==null || !Double.valueOf(transferFormBean.getAmount()).toString().matches("[0-9]{1,13}(\\.[0-9]*)?"))
			{
				errorCode.add("Please check the Amount. It is not in expected format.");
				model.addAttribute("transferStatus",errorCode);
				request.setAttribute("TextValue",Accountnum);
				serverValidationError = true;
			}
			
			// Go back to credit debit page with these validation errors.
			if(serverValidationError){
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView("/ExternalUsers/Transfer_funds", model); // return back to register
			}
			
			//String hashedKey = "";
			System.out.println("comes at Transfer post method");
			String FromAccount = transferFormBean.getFromaccount();
			String ToAccount = transferFormBean.getToaccount();
			Double amount = Double.parseDouble(transferFormBean.getAmount());
			boolean isPKINeeded = false;
			String hashedKey = transferFormBean.getPki();
		
			if(!serverValidationError){
			
				boolean isFromAccountExist = transactionService.getAccountNumber(FromAccount);
				boolean isToAccountExist = transactionService.getAccountNumber(ToAccount);
			
				if(!isFromAccountExist || !isToAccountExist) 
				{
					System.out.println("Enter a valid account number ");
					model.addAttribute("transferStatus", "Please enter a valid account number");
					model.addAttribute("transferFormBean",transferFormBean);
					request.setAttribute("TextValue",Accountnum);
					return new ModelAndView("/ExternalUsers/Transfer_funds", model);
				}
				else if(FromAccount.equals(ToAccount))
				{
					System.out.println("Enter a valid account number ");
					model.addAttribute("transferStatus", "Please enter a valid account number");
					model.addAttribute("transferFormBean",transferFormBean);
					request.setAttribute("TextValue",Accountnum);
					return new ModelAndView("/ExternalUsers/Transfer_funds", model);
				}
				else if(amount <= 0)
				{
					System.out.println("Enter a valid Amount ");
					model.addAttribute("transferStatus", "Please enter a valid Amount");
					model.addAttribute("transferFormBean",transferFormBean);
					request.setAttribute("TextValue",Accountnum);
					return new ModelAndView("/ExternalUsers/Transfer_funds", model);
				
				}
				
				// PKI
				else if(amount > 5000)
				{	
					if (transferFormBean.getPki() !=null){
					System.out.println("Comes in PKI valid");
					isPKINeeded = true;
					}
					else{
						System.out.println("Comes in PKI loop");
						model.addAttribute("transferStatus", "Please enter the PKI info for critical Transactions");
						model.addAttribute("transferFormBean",transferFormBean);
						request.setAttribute("TextValue",Accountnum);
						return new ModelAndView("/ExternalUsers/Transfer_funds", model);
					
						
					}
				
				}
			
				if(isFromAccountExist && isToAccountExist)
				{
					System.out.println("isToAccountExist" + isToAccountExist);
					System.out.println("isFromAccountExist" + isFromAccountExist);
							
					
					//************PKI DO NOT TOUCH**************************
					
					UserDTO userDTO = new UserDTO();
					// get corresponding uid of a/c no from acc_Details
					 userDTO = accountService.getuserId(FromAccount);
					 
					 
					 //todo call this only after validating pki > 5000
					boolean pkiSuccess = false;
					if (isPKINeeded){
						String encryptedUserame = pkiService.sendEncryptedPaymentInfo(userDTO.getUserId(), hashedKey);
						 pkiSuccess = pkiService.DecryptPaymentInfo(userDTO.getUserId(), encryptedUserame);
						
							if(isPKINeeded && !pkiSuccess)
							{
							
								model.addAttribute("pkistatus","Incorrect private Key. Please make a new transfer");
								model.addAttribute("transferFormBean",transferFormBean);
								request.setAttribute("TextValue",Accountnum);
								return new ModelAndView("/ExternalUsers/Transfer_funds", model);
									
							}
					}
					
				
					
					//************PKI DO NOT TOUCH**************************
					
					
					//Call TransferBalance to add the amount to the given account number
					// Do transfer only for other cases.
					if ((transferFormBean.getPki() == "" && amount <=5000) || (amount > 5000 && pkiSuccess)){
						boolean isTransferSuccess = transactionService.TransferBalance(ToAccount, FromAccount, amount);
						System.out.println("isTransferSuccess" + isTransferSuccess);
						if(isTransferSuccess)
						{
							System.out.println("Transfer Successful!");
							model.addAttribute("transferStatus", "Transfer Successful!");
							model.addAttribute("transferFormBean",transferFormBean);
							request.setAttribute("TextValue",Accountnum);
							return new ModelAndView("/ExternalUsers/Transfer_funds", model);
						
						}
					}
					
					// Check if amt is <5000 but still PKI was entered.
					else if (transferFormBean.getPki() != "" && amount <=5000){
						model.addAttribute("pkistatus","For safety purposes, please dont enter PKI for  transactions less than 5000 USD");
						model.addAttribute("transferFormBean",transferFormBean);
						request.setAttribute("TextValue",Accountnum);
						return new ModelAndView("/ExternalUsers/Transfer_funds", model);
					}
					
					/*else if(amount > 5000 && pkiSuccess && isPKINeeded )
					{
						
					}*/
					

			} // froma nd to acct exist loop ends
			} // server validation 
			
				model.addAttribute("transferStatus", "Seems to be some issues. Please try again");
				model.addAttribute("transferFormBean",transferFormBean);
				request.setAttribute("TextValue",Accountnum);
				return new ModelAndView("/ExternalUsers/Transfer_funds", model);
				
			
		}

	}
	 
	
