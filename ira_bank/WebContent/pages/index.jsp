<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-css.map" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css.map" />
<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>I.R.A Bank</title>
<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"  type="text/javascript"></script>
</head>
<body class="home-page-background-image">
 <div id="header" class="margin-top-05 text-center">
				<p class="text-xxx-large color-white">I.R.A BANK</p>
			</div>	
			
<div class="row">
	<div class="well-lg col-md-offset-3 col-md-6">
		<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading text-x-large" style="color:grey;text-align:center;">LOGIN</div>
  <div class="panel-body">
			
			  <br>
				 <c:if test="${ userstatus != null}">
		             <div class="btn-primary">
		                   <div id="status" class="label-primary">${userstatus}</div>
		             </div>
	              </c:if>
	         
	          
	          
			 <!-- Login Failed Test -->
			  <c:if test="${not empty LoginStatus}">
				<div class="label-group">
					<div id="status" class="label-info">Login failed. Please try again. 
					</div>
					<br /> 
				</div>
			</c:if>
			
			<!-- Login Failed Test -->
			  <c:if test="${not empty LogoutStatus}">
				<div class="label-group">
					<div id="status" class="label-success">Logged out successfully.
					</div>
					<br /> 
				</div>
			</c:if>

			<!-- Registration Failed Test -->
			 <c:if test="${ userRegistrationStatus != null}">
	             <div class="label-group">
	                   <div id="status" class="label label-info">${userRegistrationStatus}</div>
	             </div>
              </c:if>
            
             <!-- Password updated -->
			 <c:if test="${ Status != null}">
	             <div class="btn btn-default">
	                   <div id="status" class="label-info">${Status}</div>
	             </div>
              </c:if>
             <br>
   
               <form name="usernameForm" id="usernameForm" action="/ira_bank/userNameCheck" method='POST' class=" form-horizontal"  >
				
				 <div class="col-md-offset-1 form-group ">
              <label class="control-label col-md-2" for="userName">Username</label>
                    <div class=" col-md-7 input-group">
				
				   <input type="text" class="form-control" id="userName" name='userName' placeholder="Username" maxlength="30" >
				  
				   </div></div>
				    
				    <label class="control-label" for="userName">Not a Member? Click</label>
				    
					<a href="<%=request.getContextPath()%>/register" >Here</a> 
				  
				 
				
				<div class="col-md-offset-4 col-md-6 ">
		      	   <button name="login" type="submit" class = "btn btn-success" >Submit</button>
					
					</div>
					
					</form>
					
					</div>
      </div>
      </div></div>

			
<!-- bootstap js -->
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>






</body>
</html>