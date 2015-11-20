package edu.irabank.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import edu.irabank.dao.RequestDetailsDAO;
import edu.irabank.dto.RequestDetailsDTO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.RequestDetailsFormBean;
import edu.irabank.form.RequestDetailsPopulateBean;
import edu.irabank.form.UserDetailsFormBean;
import edu.irabank.service.InternalTransactionService;
import edu.irabank.service.impl.InternalTransactionServiceImpl;

@Controller
public class ViewTransactionsController {
	@Autowired
	InternalTransactionService internalService;
	@Autowired
	RequestDetailsDAO requestDAO;
	
	// List of un-approved transactions
	
	@RequestMapping(value="/admin/listTransactions", method = RequestMethod.GET)
	public String listAllTransactions(ModelMap model,HttpServletRequest request) {
		// redirect to the listTrans.jsp
		
		 
		 
		boolean val= true;
		model.addAttribute("button",true);
		model.addAttribute("requestDetailsFormBean", new RequestDetailsFormBean());
		model.addAttribute("useThis", val);
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}
	
	@RequestMapping(value="/admin/ApprovedTransactions", method = RequestMethod.GET)
	public String listAllApprovedTransactions(ModelMap model) {
		// redirect to the listTrans.jsp
		boolean approve= true;
		model.addAttribute("approved", approve);
		model.addAttribute("button",false);
		System.out.println("List All Transactions");
		//model.put("RequestDTO", new RequestDetailsDTO());
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}
	@RequestMapping(value ="user/ExternalUsers/listTransactions", method = RequestMethod.GET)
	public String listALLUserTransactions(ModelMap model,HttpSession SessionId)
	{
		System.out.println("List User transaction, sessionId is "+ SessionId.getAttribute("userId"));
		boolean val= false;
		boolean setView = true;
		model.addAttribute("setView", "Transact");
		model.addAttribute("useThis", val);
		model.addAttribute("userIdCompare", SessionId.getAttribute("userId"));
		model.put("RequestDetailsList", internalService.listTransactions());
		return "/ExternalUsers/listTrans";
	}
	
	 @RequestMapping(value="admin/edit" ,method = RequestMethod.POST)
     public ModelAndView getUser(@ModelAttribute("requestDetailsFormBean") RequestDetailsFormBean requestDetailsFormBean,@RequestParam("reqId") Integer reqId,Map<String, Object> map, ModelMap model,HttpServletRequest request) {

            //UserDTO userDTO = new UserDTO();
            System.out.println("userId : 50" + reqId);
            RequestDetailsDTO requestDTO = internalService.getRequestByReqID(reqId);
            System.out.println("Processed Request DAO in edit");
            request.setAttribute("TextValue",requestDTO.getReqUserId().getUserId());
            request.setAttribute("requestID", reqId);
			  model.addAttribute("userDetailsFormBean",requestDTO);
			  
			 
				
				 
            System.out.println("Crossed bean formation in edit");
            //map.put("user", user);	
  		  return new ModelAndView("/InternalUsers/requestDetailsForm", model);
          
     }

}
