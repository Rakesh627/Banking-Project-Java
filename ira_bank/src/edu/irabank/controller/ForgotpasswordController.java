package edu.irabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

import javax.validation.Valid;

import edu.irabank.dao.UserDAO;
import edu.irabank.dto.UserDTO;
import edu.irabank.form.ForgotPasswordFormBean;
import edu.irabank.service.UserService;

@Controller
public class ForgotpasswordController {
	
	 @Autowired
	 private JavaMailSender mailSender; 
	 
	 @Autowired
	 private UserService userService; 
	 ArrayList<String> errorCode = new ArrayList<String>();
	 
	@RequestMapping(value="Forgot_email", method = RequestMethod.POST)
	public ModelAndView forgotpasswordform(@RequestParam("j_username") String j_username, ModelMap model) {
		// redirect to the registerUser.jsp
		UserDTO retrievedDTO=userService.getUserDTOByUsername(j_username);
		 model.addAttribute("EmailId", retrievedDTO.getEmailId());
		 model.addAttribute("SecQue1", retrievedDTO.getSecQue1());
		 model.addAttribute("SecQue2", retrievedDTO.getSecQue2());
		 return new ModelAndView("/ForgotPassword",model);
	}
	
	
	   
	    @RequestMapping(value="Forgot", method = RequestMethod.POST)
	    public  ModelAndView doSendEmail(@ModelAttribute("forgotPasswordFormBean")  @Valid ForgotPasswordFormBean forgotPasswordFormBean ,BindingResult result, ModelMap model) 
	    {
	    	//System.out.println("comes in forgot controller ::" + forgotPasswordFormBean.getEmailId());
	    	// Case 1: JSR303 validation. Checks for Hibernate related form issues.
	    	String  recipientAddress =forgotPasswordFormBean.getEmailId();
	    	UserDTO retrievedDTO = userService.getUserDTOByEmailId(recipientAddress);
		
	    	if (result.hasErrors()){
				//System.out.println("comes in form errors of register");
				
				model.addAttribute("Status", "Please fill the necessary fields correctly and try again");
				model.addAttribute("EmailId", retrievedDTO.getEmailId());
				 model.addAttribute("SecQue1", retrievedDTO.getSecQue1());
				 model.addAttribute("SecQue2", retrievedDTO.getSecQue2());
				model.addAttribute("ForgotRegistrationFormBean",forgotPasswordFormBean);
				return new ModelAndView( "/ForgotPassword",model);
			}
	    				
	    				Boolean serverValidationError = false;
	    				
	    				if(forgotPasswordFormBean.getDob()==null )
	    				{
	    					errorCode.add("Date is not in expected format");
	    					model.addAttribute("Status",errorCode);
	    					serverValidationError = true;
	    				}
	    				if(forgotPasswordFormBean.getSecAns1()==null || !forgotPasswordFormBean.getSecAns1().matches("^[a-zA-Z0-9 ,.]+$"))
	    				{
	    					errorCode.add("Sec Ans 1 is not in expected format");
	    					model.addAttribute("Status",errorCode);
	    					serverValidationError = true;
	    				}

	    				if(forgotPasswordFormBean.getSecAns2()==null || !forgotPasswordFormBean.getSecAns1().matches("^[a-zA-Z0-9 ,.]+$"))
	    				{
	    					errorCode.add("Sec Ans 2 is not in expected format");
	    					model.addAttribute("9Status",errorCode);
	    					serverValidationError = true;
	    				}
	    				if(forgotPasswordFormBean.getEmailId()==null || !forgotPasswordFormBean.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
	    				{
	    					errorCode.add("Email is not in expected format");
	    					model.addAttribute("userRegistrationStatus",errorCode);
	    					serverValidationError = true;
	    				}
	    				if(forgotPasswordFormBean.getSecQue1()==null || !forgotPasswordFormBean.getSecQue1().matches("^[a-zA-Z0-9 ,.]+$"))
	    				{
	    					errorCode.add("Sec Que 1 is not in expected format");
	    					model.addAttribute("userRegistrationStatus",errorCode);
	    					serverValidationError = true;
	    				}
	    				if(forgotPasswordFormBean.getSecQue2()==null || !forgotPasswordFormBean.getSecQue2().matches("^[a-zA-Z0-9 ,.]+$"))
	    				{
	    					errorCode.add("Sec Que 2 is not in expected format");
	    					model.addAttribute("userRegistrationStatus",errorCode);
	    					serverValidationError = true;
	    				}
	    				
	    				if(serverValidationError){
	    					return new ModelAndView("/ForgotPassword", model); 
	    				}
	    				if(!serverValidationError)
	    				{
	    		
	    		try
	    		{
				    	// takes input from e-mail form
				    
				    
				String secAns1=forgotPasswordFormBean.getSecAns1().trim();
				String secAns2=forgotPasswordFormBean.getSecAns2().trim();
				    if(secAns1.equals(retrievedDTO.getSecAns1())&&secAns2.equals(retrievedDTO.getSecAns2())&&forgotPasswordFormBean.getDob().equals(retrievedDTO.getDob()))
				    {
				    
				  
				    UUID idOne = UUID.randomUUID();
				    String OTP= String.valueOf(idOne);
				    
				    //System.out.println("retrievedDTO ::" +retrievedDTO.getEmailId() + retrievedDTO.getFirstName());
				    retrievedDTO.setOtp(OTP);
				    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					   //get current date time with Date()
					   Date date = new Date();

				    Boolean storeotp = userService.storeotp(retrievedDTO);
				    
				        // creates a simple e-mail object
				        SimpleMailMessage email = new SimpleMailMessage();
				        email.setTo(recipientAddress);
				        email.setSubject("One Time Password");
				        email.setText("The otp for the account is "+OTP);
				         
				        // sends the e-mail
				        mailSender.send(email);
				        model.addAttribute("Time",date.getTime());
				        model.put("EmailId",recipientAddress);
				    return new ModelAndView("/OTP",model);
				    }
				    else
				    {
				    	model.addAttribute("EmailId", retrievedDTO.getEmailId());
						 model.addAttribute("SecQue1", retrievedDTO.getSecQue1());
						 model.addAttribute("SecQue2", retrievedDTO.getSecQue2());
				    	 model.addAttribute("Status", "Please check your credentials");
			    		 return new ModelAndView("/ForgotPassword",model);
				    }
				   
	    }
				  
	        // forwards to the view named "Result"
			catch(Exception e){
				System.out.println("Exception: "+ e);
				return new ModelAndView("/error");
	
			
			}    
	    		
	    }
	    	else
	    	{
	    		model.addAttribute("Status", "Please check your credentials");
	    		 return new ModelAndView("/ForgotPassword",model);
	    	}
			
	}
	    
	    
	    @RequestMapping(value="OTP", method = RequestMethod.POST)
	    public  ModelAndView verifyotp(@RequestParam("otp") String otp ,@RequestParam("email") String email,@RequestParam("createtime") long createtime, ModelMap model) 
	    {
	    	 UserDTO retrievedDTO = userService.getUserDTOByEmailId(email);
	    	 Date date = new Date();
	    	 long currenttime=date.getTime();
	    	 long diff=currenttime-createtime;
	    	 long diffMinutes = diff / (60 * 1000) % 60;
	    	long diffsec= diff / 1000 % 60;
	    	
	    	//System.out.println("the difference is"+diffMinutes);
	    	System.out.println("the difference is"+diffsec);
	    	 if(diffsec>300)
	    	 {
	    		 model.addAttribute("Status", "OTP Expired");
	    		 return new ModelAndView("/OTP",model);
	    	 }

	    	
	    	 if (otp ==null || !otp.matches("^[a-zA-Z0-9- ,.]+$")){
					// Set the error.
					model.addAttribute("Status", "Please enter proper OTP value.");
					 model.addAttribute("EmailId", email);
		    		 return new ModelAndView("/OTP",model);
				} 
	    	 
	    	 if(otp.equals(retrievedDTO.getOtp()))
	    	 {
	    		 model.put("EmailId",email);
	    		 return new ModelAndView("/resetpassword",model);
	    	 }
	    	 else
	    	 {
	    		
	    		 model.addAttribute("Status", "Please Try Again");
	    		 model.addAttribute("EmailId", email);
	    		 return new ModelAndView("/OTP",model);
	    	 }
	    	 
	    }
	    
	    @RequestMapping(value="resetpassword", method = RequestMethod.POST)
	    public  ModelAndView confirmpassword(@RequestParam("password") String password ,@RequestParam("email") String email,@RequestParam("confirmpassword") String confirmpassword, ModelMap model) 
	    {
	    	System.out.println("the password is "+password);
	    	System.out.println("the confirmpassword is "+confirmpassword);
	    	
	    	
	    	 if (password ==null || !password.matches("^[a-zA-Z0-9 ,.]+$")){
					// Set the error.
					model.addAttribute("Status", "Please enter proper password");
					 model.addAttribute("EmailId", email);
		    		 return new ModelAndView("/resetpassword",model);
				} 
	    	 if (confirmpassword ==null || !confirmpassword.matches("^[a-zA-Z0-9 ,.]+$")){
					// Set the error.
					model.addAttribute("Status", "Please enter proper password");
					 model.addAttribute("EmailId", email);
		    		 return new ModelAndView("/resetpassword",model);
				} 
	    	 if(!confirmpassword.equals(password))
	    	 {
	    		 model.addAttribute("Status", "Password should match");
	    		 model.addAttribute("EmailId", email);
	    		 return new ModelAndView("/resetpassword",model);
	    	 }
	    	 if(confirmpassword.equals(password))
	    	 {
	    	try
    		{
	    		UserDTO retrievedDTO = userService.getUserDTOByEmailId(email);
	    	 //System.out.println("the value is "+retrievedDTO.getOtp());
	    	 //System.out.println("the value is "+otp);
	    	
	    	 retrievedDTO.setPassword(password);
	    	 Boolean updatepassword = userService.updatepassword(retrievedDTO);
	    	 model.addAttribute("Status","Password updated. Please login with new password");
	    	
				return new ModelAndView("/index",model);
    		}
	    	
	    	catch(Exception e){
	    					System.out.println("Exception: "+ e);
	    					return new ModelAndView("/resetpassword");
	    }
	    }
			return null;    	 
	  }
	    
}


