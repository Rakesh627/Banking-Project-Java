<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I.R.A Bank</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css" />
</head>
<body class="home-page-background-image">

<div id="header" class="margin-top-05 text-center">
				<p class="text-xxx-large color-white">I.R.A BANK</p>
			</div>	
			



<div class="row">
	<div class="col-md-offset-3 col-md-6">
		<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading text-x-large" style="color:grey;text-align:center;">LOGIN</div>
  <div class="panel-body">
			       

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
            

             
			<%
				/*Check if Login did not happen*/
				if(request.getAttribute("loginError") != null)
				{%>
				<p ><span class="label label-warning" style="float:right;font-weight:bold;">${loginError}</span></p>	
			  <%}%>
			  
			  
 <form class="form-horizontal" name="loginForm" action="<c:url value='/j_spring_security_check' />" method='POST'>
			
		  <input type="hidden" class="form-control" id="j_username" name='j_username' value="${userName}" maxlength="30" >
			
	      		  
	      <div class="form-group ">
              <label class="control-label col-md-2" for="j_password">Password</label>
                 <div class="col-md-7 input-group">
				  <input type="password" class="form-control" placeholder="Password"  id="j_password" name='j_password' maxlength="15">
	       		 
				   </div>
		  </div>
		  
	       <div class="row">
	       		 <div class="col-md-offset-2 col-md-6">
				<h4>Your SiteKey is: <strong class="label label-primary" style="font-size:14px">${sitekey}</strong></h4>
				</div>
		  </div>
		  <div class="row">
					<div class=" col-md-6">
						<input name="login" type="submit" value="Login" class = "btn btn-success"/>
						<input name="cancel" type="reset" value="Cancel"  class = "btn btn-danger"/>
					</div>
		

</form>

<div class="col-md-offset-2 col-md-4">
	<form  name="forgotForm" action="/ira_bank/Forgot_email" method='POST'>
		 <input type="hidden" class="form-control" id="j_username" name='j_username' value="${userName}" maxlength="30" >
		<input type="submit" name="submit" id="submit" value="ForgotPassword" class="centered  btn btn-primary ">

	</form>
</div>
 </div>
	<br>

</div>
</div>
</div>
</div>



 <!-- Bootstrap css -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

<!-- Jquery JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>


</body>
</html>