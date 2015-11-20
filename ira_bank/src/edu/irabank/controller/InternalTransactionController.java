package edu.irabank.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dao.RequestDetailsDAO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.InternalTransactionFormBean;
import edu.irabank.form.RequestDetailsFormBean;
import edu.irabank.service.InternalTransactionService;
import edu.irabank.service.TransactionService;
import edu.irabank.service.UserService;
import edu.irabank.service.impl.InternalTransactionServiceImpl;
/**
 * @author Rakesh Subramanian
 *
 */
@Controller
@SessionAttributes
public class InternalTransactionController 
{
	@Autowired
	private TransactionService transactionService; 
	@Autowired
	private InternalTransactionService internalTransactionService;
	@Autowired 
	RequestDetailsDAO requestDAO;

	// Ext Users request / create a new transaction.	
	@RequestMapping(value="/user/ExternalUsers/Request", method = RequestMethod.GET)
	public ModelAndView sampTransRoute( HttpSession sessionID,HttpServletRequest request,ModelMap model)
	
	{
		
		String userName = (String)sessionID.getAttribute("userName");
		System.out.println("userName is:" + userName);
		int userId = (int)sessionID.getAttribute("userId");
		String Accountnum = transactionService.getAccountNumberbyUserID(userId);
		model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
		request.setAttribute("TextValue",Accountnum);
		System.out.println("userId is:" + userId);
		return new ModelAndView("/ExternalUsers/RequestTransaction");
		
	}
	
	@RequestMapping(value="/user/ExternalUsers/CreateTransaction", method = RequestMethod.GET)
	public ModelAndView createTrans(HttpSession sessionID, ModelMap model, HttpServletRequest request)
	{
		String userName = (String)sessionID.getAttribute("userName");
		System.out.println("userName is:" + userName);
		int userId = (int)sessionID.getAttribute("userId");
		String Accountnum = transactionService.getAccountNumberbyUserID(userId);
		model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
		request.setAttribute("TextValue",Accountnum);
		System.out.println("userId is:" + userId);
		return new ModelAndView ("/ExternalUsers/RequestTransaction");
		
	}
	
	// POST method of create Transaction -> 
	@RequestMapping(value="/user/ExternalUsers/CreateTransaction", method = RequestMethod.POST)
	public ModelAndView createTrans(HttpServletRequest request,@ModelAttribute("trans") @Valid InternalTransactionFormBean trans,BindingResult result, HttpSession sessionID,ModelMap model)
	{
		String Accountnum = transactionService.getAccountNumberbyUserID((Integer)sessionID.getAttribute("userId"));
		System.out.println("Account number in controller is:"+Accountnum);
		
		String tranID = "";
		int userID = (int)sessionID.getAttribute("userId");
		
		
		System.out.println("userName is:" + userID);
		boolean isAuthorized0 = false;
		String[] empty = new String[1];
		empty[0] = "";
		String reqId = "";
		
		
		ArrayList<String> errorCode = new ArrayList<String>();
		if (result.hasErrors()){
			model.addAttribute("userRegistrationStatus", "Please fill the necessary fields and try again");
			model.addAttribute("InternalTransactionFormBean",trans);
			int userId = (int)sessionID.getAttribute("userId");
			String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
			model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
			request.setAttribute("TextValue",Accountnum1);
			return new ModelAndView( "/ExternalUsers/RequestTransaction",model);
		}
		
		
		Boolean serverValidationError = false;
		if(trans.getFrom_account()==null || !trans.getFrom_account().matches("^[0-9 -]+$"))
				{
			errorCode.add("Please check the  Account Number. It is not in expected format.");
			model.addAttribute("userRegistrationStatus",errorCode);
			serverValidationError = true;
			
				}
		
		if(trans.getTo_account()==null || !trans.getTo_account().matches("^[0-9 -]+$"))
		{
	errorCode.add("Please check the to Account Number. It is not in expected format.");
	model.addAttribute("userRegistrationStatus",errorCode);
	serverValidationError = true;
	
		}

		
		if(trans.getAmount()==null || !trans.getAmount().toString().matches("[0-9]{1,13}(\\.[0-9]*)?"))
		{
	errorCode.add("Please check the Amount. It is not in expected format.");
	model.addAttribute("userRegistrationStatus",errorCode);
	serverValidationError = true;
	
		}

		
		if(serverValidationError){
			int userId = (int)sessionID.getAttribute("userId");
			String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
			model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
			request.setAttribute("TextValue",Accountnum1);
			return new ModelAndView("/ExternalUsers/RequestTransaction", model); // 
		}
		
		boolean toAccount = transactionService.getAccountNumber(trans.getTo_account());
		if(!toAccount)
		{
			model.addAttribute("userRegistrationStatus", "Enter vaalid 'To' account Number");
			int userId = (int)sessionID.getAttribute("userId");
			String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
			model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
			request.setAttribute("TextValue",Accountnum1);
			return new ModelAndView("/ExternalUsers/RequestTransaction",model);
		}
		else if(trans.getFrom_account() == trans.getTo_account())
		{
			
			model.addAttribute("userRegistrationStatus", "Enter proper account number");
			int userId = (int)sessionID.getAttribute("userId");
			String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
			model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
			request.setAttribute("TextValue",Accountnum1);
			return new ModelAndView("/ExternalUsers/RequestTransaction",model);
		}
		if(!serverValidationError)
		{
		
		boolean isCreateSuccess = internalTransactionService.setTransactionDetails(trans, userID,isAuthorized0,tranID,empty,reqId);
		try{//System.out.println("Entered Try Loop for CreateTrans:"+isCreateSuccess);
		if(isCreateSuccess == true)
		{
			//internalTransactionService.setRequestDetails(trans, userId);
			int userId = (int)sessionID.getAttribute("userId");
			String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
			model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
			request.setAttribute("TextValue",Accountnum1);
			model.addAttribute("userRegistration", "Transaction Done successfully");
			model.addAttribute("userName", sessionID.getAttribute("userName"));

		}
		
		}
		catch(Exception e){
			System.out.println("Exception: "+e);
	
		}
		}
		int userId = (int)sessionID.getAttribute("userId");
		String Accountnum1 = transactionService.getAccountNumberbyUserID(userId);
		model.addAttribute("StatusHere", "This Page is For Requesting Internal Users to Do transactions For you.");
		request.setAttribute("TextValue",Accountnum1);
		return new ModelAndView("/ExternalUsers/RequestTransaction",model);
	}

	// Admin Transaction approval
	@RequestMapping(value = "admin/Transaction/Approval" ,method = RequestMethod.POST)
	public ModelAndView setIsAuthorized(@ModelAttribute("trans") InternalTransactionFormBean trans,@RequestParam("transId") String transId,@RequestParam("reqId") String reqId, @RequestParam("userId") int userId,@RequestParam("reqDesc")String reqDesc,HttpSession sessionID,HttpServletRequest request,ModelMap model)
	{//to_account and acmount need to be got!
		//after approve.. account details need to be changed and request and transact need to have isauthorized set.
		System.out.println("Entering Is_authorized");
		String Accountnum = transactionService.getAccountNumberbyUserID((Integer)sessionID.getAttribute("userId"));
		System.out.println("Account number in controller is:"+Accountnum);
		String userName = (String)sessionID.getAttribute("userName");
		/*String phrase = "the music made   it   hard      to        concentrate";
		String delims = "[ ]+";
		String[] tokens = phrase.split(delims);*/
		
		String delimeter = "[,]";
		String[] split = new String[2];
		 split = reqDesc.split(delimeter);
		System.out.println("From Splitting TO_ACCT: "+ split[1]);
		System.out.println("From Splitting Amount: "+ split[2]);

		System.out.println("userName is:" + userName);
		System.out.println("userName is:" + userId);
		
		boolean isAuthorized1 = true;
		boolean isCreateSuccess = internalTransactionService.setTransactionDetails(trans,userId,isAuthorized1,transId,split,reqId);
		try{
		if(isCreateSuccess == true)
		{
			//internalTransactionService.setRequestDetails(trans, userId);
			model.addAttribute("userRegistrationStatus", "Approved Successfully");
			model.addAttribute("userName", userName);

		}
		}
		catch(Exception e){System.out.println("Exception at APPROVAL"+e);}

		return new ModelAndView("/ExternalUsers/listTrans",model);
		
	}
	
	//@PathVariable("fromAccount") String fromAccount,@PathVariable("toAccount") String toAccount,@PathVariable("amount") Double amount,
	@RequestMapping(value="/admin/save")
	public ModelAndView saveTrans(HttpServletRequest request,@ModelAttribute("trans") InternalTransactionFormBean trans,@RequestParam("reqId") Integer reqId,@RequestParam("reqUsedId") Integer reqUsedId,@RequestParam("reqDesc") String reqDesc, HttpSession sessionID,ModelMap model)
	{           
RequestDetailsFormBean requestDetailsFormBean = new RequestDetailsFormBean();
		ArrayList<String> errorCode = new ArrayList<String>();
		
		RequestDetailsDTO requestDTO=internalTransactionService.getRequestByReqID(reqId);
		request.setAttribute("TextValue",requestDTO.getReqDesc());
		sessionID.setAttribute("reqId", reqId);
		Boolean serverValidationError = false;
		if(reqDesc==null || !reqDesc.matches("^[0-9]{9}[,]{1}[0-9]{9}[,][0-9.]+$"))
				{
			 requestDTO=internalTransactionService.getRequestByReqID(reqId);
			errorCode.add("Please check the  values. It is not in expected format.");
			model.addAttribute("userRegistrationStatus",errorCode);
			serverValidationError = true;
			model.addAttribute("requestDetailsFormBean",requestDetailsFormBean);
			
            request.setAttribute("requestID", reqId);
            request.setAttribute("TextValue",requestDTO.getReqUserId().getUserId());

			return new ModelAndView("/InternalUsers/requestDetailsForm");
				}
		String delimeter = "[,]";
		String[] split = new String[2];
		 split = reqDesc.split(delimeter);
		boolean fromAccount = transactionService.getAccountNumber(split[0]);
		boolean toAccount = transactionService.getAccountNumber(split[1]);

		if(!fromAccount)
		{
			 requestDTO=internalTransactionService.getRequestByReqID(reqId);

			model.addAttribute("userRegistrationStatus","Enter Proper FROM Account Number!");
			model.addAttribute("requestDetailsFormBean",requestDetailsFormBean);
			
            request.setAttribute("requestID", reqId);
            request.setAttribute("TextValue",requestDTO.getReqUserId().getUserId());

			return new ModelAndView("/InternalUsers/requestDetailsForm");
		}

		if(!toAccount)
		{
			 requestDTO=internalTransactionService.getRequestByReqID(reqId);

				model.addAttribute("userRegistrationStatus","Enter Proper TO Account Number!");
				model.addAttribute("requestDetailsFormBean",requestDetailsFormBean);
				
	            request.setAttribute("requestID", reqId);
	            request.setAttribute("TextValue",requestDTO.getReqUserId().getUserId());

				return new ModelAndView("/InternalUsers/requestDetailsForm");		}
		if(Integer.parseInt(split[0])==Integer.parseInt(split[1]))
		{
			model.addAttribute("userRegistrationStatus","You either tried to change the FROM account number or Entered same account number twice. Please check your values!");
			model.addAttribute("requestDetailsFormBean",requestDetailsFormBean);
			
            request.setAttribute("requestID", reqId);
            request.setAttribute("TextValue",requestDTO.getReqUserId().getUserId());
            return new ModelAndView("/InternalUsers/requestDetailsForm");	
		}
		
		if(!serverValidationError)
		{
		//delete first
		System.out.println("Comes in Delete" + reqId);
		internalTransactionService.deleteTransaction(reqId);
		model.addAttribute("userdeleteStatus", "User Deleted successfully");
		//model.put("userDetailsFormBean", new UserDetailsFormBean());
		System.out.println("63 : comes in Delete conroller");
		
		
		
		
		
		
		//
		
		
		String Accountnum = transactionService.getAccountNumberbyUserID((Integer)sessionID.getAttribute("userId"));
		System.out.println("Account number in controller is:"+Accountnum);
		
		String tranID = "";
		
		
		 split = reqDesc.split(delimeter);
		 trans.setFrom_account(split[0]);
		 System.out.println("to:"+split[0]);

		 trans.setTo_account(split[1]);
		 System.out.println("to:"+split[1]);
		 trans.setAmount(Double.parseDouble(split[2]));
		System.out.println("userName is:" + reqUsedId);
		boolean isAuthorized0 = false;
		
	
		boolean isCreateSuccess = internalTransactionService.setTransactionDetails(trans, reqUsedId,isAuthorized0,tranID,split,reqId.toString());
		try{System.out.println("Entered Try Loop for CreateTrans:"+isCreateSuccess);
		
		
		
		}
		catch(Exception e){
			System.out.println("Exception: "+e);
	
		}
		
		//list transactions
		boolean val= true;
		model.addAttribute("button",true);
		model.addAttribute("requestDetailsFormBean", new RequestDetailsFormBean());
		model.addAttribute("useThis", val);
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		model.put("RequestDetailsList", internalTransactionService.listTransactions());
		
		}
		return new ModelAndView("/ExternalUsers/listTrans",model);
	}
	}
