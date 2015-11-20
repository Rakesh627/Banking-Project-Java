package edu.irabank.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
public class IraBankExceptionController {
	
	// Logger for checking the error
	public static final Logger logger = Logger.getLogger(IraBankExceptionController.class);
	
	// Add as many as classes
	@ExceptionHandler(value = 
			{
			Exception.class, 
			NullPointerException.class,
		    NoSuchRequestHandlingMethodException.class, 
		    RuntimeException.class,
		    ResourceAccessException.class,
		    AccessDeniedException.class,
		    PropertyNotFoundException.class,
		    ConstraintViolationException.class,
		    NestedServletException.class}
			)
	
	// Don't pass model object here. Seriously was creating issues here.
    public ModelAndView globalErrorHandler(HttpServletRequest request, Exception e) {
            System.out.println("comes in exception controller");
            ModelAndView mdlViewObj = new ModelAndView("/common/Exception");
            logger.error(e.getStackTrace());
            return mdlViewObj;
            //return new ModelAndView("common/Exception"); // Error java.lang.IllegalStateException: No suitable resolver for argument [0] [type=org.springframework.ui.ModelMap]
	}
}
