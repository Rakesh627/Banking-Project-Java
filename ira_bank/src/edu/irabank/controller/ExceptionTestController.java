package edu.irabank.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController {
	@RequestMapping("/test1")
	public String testException1() throws IOException{
		boolean exceptionFlag = true;
		if (exceptionFlag){
			throw new IOException();
		}
		return "common/Exception";
	}
	@RequestMapping("/test2")
	public String testException2() throws SQLException{
		boolean exceptionFlag = true;
		if (exceptionFlag){
			throw new SQLException();
		}
		 return "common/Exception";
	}
}