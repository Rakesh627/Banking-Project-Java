<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

</head>

<!-- Jquery JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/js/verify.notify.js"></script>
<body>

 
<!-- Registration -->
<!--first split-->
<div class="panel panel-primary">
  <div class="panel-heading">REGISTER FORM</div>
        <div class="panel-body">

			 <form:form class="form-horizontal" method="POST" id="userRegistrationFormBean" 
                commandName="userRegistrationFormBean" action="/ira_bank/register">
			 
			<!-- Registration Failed Test -->
			 <c:if test="${ userRegistrationStatus != null}">
	             <div class="label-group">
	                   <div id="status" class="label label-info">${userRegistrationStatus}</div>
	             </div>
              </c:if>
             <br>

<div class="container-fluid">
  <div class="row">
     <div class="col-md-5">	 
				 
			<!--  username -->
            <div class="form-group">
                <label class="control-label" for="Username">Username</label>
                    <div class="col-md-12 input-group">
                            <input type="text" id="userName" name="userName" placeholder="Username" class="form-control"    value="${userRegistrationFormBean.userName}" data-validate="required,alphanumeric">
                           <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    		 <form:errors path="userName" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div>
				   	
		    <!-- Password-->      
            <div class="form-group">
              <label class="control-label" for="Password">Password</label>
                    <div class="col-md-12 input-group">
                        <input type="password" class="form-control " id="password" name="password"  placeholder="password"  value="${userRegistrationFormBean.password}" data-validate="required,alphanumeric"  >
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <form:errors path="password" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div>     
        
                    <!-- First Name -->            
           <div class="form-group">
              <label class=" control-label" for="FirstName">First Name</label>
                    <div class="col-md-12 input-group">
                        <input type="text" class="form-control" id="firstName" name="firstName"  placeholder="First Name"  value="${userRegistrationFormBean.firstName}"  data-validate="required,alphanumeric">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    	 <form:errors path="firstName" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div>
		      	   
		      
		       <!-- Last Name -->
              <div class="form-group">
              <label class=" control-label" for="FirstName">Last Name</label>
                    <div class="col-md-12 input-group">
                        <input type="text" class="form-control" id="lastName" name="lastName"  placeholder="Last Name" data-validate="required,regex([a-zA-Z])" value="${userRegistrationFormBean.lastName}" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    	 <form:errors path="lastName" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div>


         <!-- Email -->
            <div class="form-group">
              <label class=" control-label" for="InputEmail">Email</label>
                    <div class="col-md-12 input-group">
                        <input type="email" class="form-control" id="emailId" name="emailId"   placeholder="Enter Email"  value="${userRegistrationFormBean.emailId}" data-validate="required,email" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                         <form:errors path="emailId" class="label label-primary" cssclass="error"></form:errors>
                        </div>
            </div>

     
        <!-- Address -->
            <div class="form-group">
              <label class=" control-label" for="address">Address</label>
                    <div class="col-md-12 input-group">
                        <textarea class="form-control " id="address"  rows="2"  name="address"  placeholder="Address" data-validate="required,alphanumeric" value="${userRegistrationFormBean.address}" > </textarea>
                         <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                         <form:errors path="address" class="label label-primary" cssclass="error"></form:errors>
                        </div>
            </div>

       <div class="form-group">
              <labelclass=" control-label" for="contactNum">Phone Number</label>
                    <div class="input-group col-md-12">
                        <input type="phone" class="form-control" id="contactNum" name="contactNum"   placeholder="Phone Number"  value="${userRegistrationFormBean.contactNum}" data-validate="required,phone" >
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                         <form:errors path="contactNum" class="label label-primary" cssclass="error"></form:errors>
                        </div>
            </div>
       
        <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Les_PwSAAAAAALJRSaUDbCDMqpvE6Ao68CdcsxS", "6Les_PwSAAAAALcU49ivDgWjJD6ZnIFWvul1dapD", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
       
       </div>
       

       
      <!--   Start the second split -->   
  
 <!--  SSN -->
 
 
   <div class="col-md-offset-1 col-md-6" >
   
   		<!-- SSN -->
        <div class="form-group">
              <label class=" control-label" for="ssn">Social Security Number</label>
                    <div class="input-group col-md-12">
                        <input type="ssn" class="form-control" id="ssn" name="ssn"   placeholder="Social Security Number" value="${userRegistrationFormBean.ssn}"  data-validate="required,number" >
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                         <form:errors path="ssn" class="label label-primary" cssclass="error"></form:errors>
                        </div>
            </div>
            
             <!-- Site Key -->
              <div class="form-group">
              <label class=" control-label" for="FirstName">Site Key</label>
                    <div class="col-md-12 input-group">
                        <input type="text" class="form-control" id="sitekey" name="sitekey"  placeholder="Enter your site key"  value="${userRegistrationFormBean.sitekey}"  data-validate="required,alphanumeric">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    	 <form:errors path="sitekey" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div>
            
            <div class="form-group">
              <label for="dob">DOB</label>

                  <div class="input-group date col-md-12 ">
                      <input type="text"  id="dob" name="dob" class="datepicker form-control" placeholder= "Select your date of birth"  value="${userRegistrationFormBean.dob}"  data-validate="required" >
 <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>                    
 				<!-- bootstrap Date picker -->
                      <script type="text/javascript">
                         $('.datepicker').datepicker(
                            { 
                             autoclose: true,
                             orientation: "right",
                             minDate: "-50Y", 
                             maxDate: "0D" ,
                             changeMonth : true,
                             changeYear : true,
                             dateformat: 'mm/dd/yyyy',
                             defaultDate: $("#dob").val()});
                      </script>
                  </div>
            </div>

 <!-- User Role -->
        <div class="form-group">
            <label class="control-label"  for="Role">Type of User</label>
                <div class="controls col-md-12">
                    <select name="role">  
                            <option value=6715>Regular User</option>     
                            <option value=8767> Merchant </option>
                            <option value=7879> Bank Employee</option>     
                            <option value=63908673> Admin </option>
                     </select>
                  <form:errors path="role" class="label label-primary" cssclass="error"></form:errors>    
                </div>
        </div>

       <!-- Sec Que 1 -->
            <div class="form-group ">
              <label class="control-label" for="secQue1" >Security Question 1</label>
                    <div class="input-group col-md-12">
                        <textarea class="form-control" id="secQue1" rows="2"  name="secQue1" data-validate="required,alphanumeric"  placeholder="Security Que 1" value="${userRegistrationFormBean.secQue1}" > </textarea>
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                       <form:errors class="label label-primary" path="secQue1" cssclass="error"></form:errors>
					</div>
					
		      
            <!-- Sec Ans 1 -->			
          <div class="form-group ">
              <label class="control-label" for="secAns1" > Security Answer 1</label>
                    <div class="input-group col-md-12 ">
                        <textarea class="form-control" id="secAns1" rows="2"  name="secAns1"   placeholder="security Ans 1"  data-validate="required,alphanumeric" value="${userRegistrationFormBean.secAns2}" ></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <form:errors path="secAns1" class="label label-primary" cssclass="error"></form:errors>
                    </div>
            </div> 

         <!-- Sec Que 2 -->
            <div class="form-group ">
              <label  class="control-label" for="secQue2">Security Question 2</label>
                    <div class="input-group  col-md-12">
                        <textarea class="form-control" id="secQue2" rows="2"  name="secQue2"   placeholder="Security Que 2" data-validate="required,alphanumeric"  value="${userRegistrationFormBean.secQue2}" > </textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                      <form:errors class="label label-primary" path="secQue2" cssclass="error"></form:errors>
                        </div>
            </div>
         <!-- Sec Ans 2 -->
            <div class="form-group ">
              <label class="control-label" for="secAns2" >Security Answer 2</label>
                    <div class="input-group col-md-12 ">
                        <textarea class="form-control" id="secAns2" rows="2"  name="secAns2"   placeholder="security Ans 2"  data-validate="required,alphanumeric" value="${userRegistrationFormBean.secAns2}" ></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <form:errors path="secAns2" class="label label-primary" cssclass="error"></form:errors>
                        </div>
            
            </div> 
            
             <!-- Can they see your PII?? -->
            <div class="form-group ">
              <label  class="control-label" for="secAns1"> Can Admin See My PII</label>
                    <div class="input-group col-md-12">
                    <input type="checkbox" id="is_ok_pii" name="is_ok_pii" value="1"> Yes
                        <form:errors class="label label-primary" path="is_ok_pii" cssclass="error"></form:errors>
                        </div>
            </div> 
		      	   
		      	   <div class="row">		
					<div class="col-md-12 col-md-8">
							<input name="login" type="submit" value="submit" class = "submit"/>
					</div>
				
					</div>
				</form:form>	
</div>
</div>

 <!-- The problem was having different folders, so place all css files in CSS folder. -->
 <!-- Bootstrap css -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

</body>
</html>