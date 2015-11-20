<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank</title>
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

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="panel panel-primary">
  <div class="panel-heading">FORGOT PASSWORD</div>



  <div class="panel-body">
     <form:form class="form-horizontal" method="POST" action="/ira_bank/Forgot" id="forgotPasswordFormBean" commandName="forgotPasswordFormBean" >
                
                <c:if test="${ Status != null}">
              	         
              	<div class="container">
       					 <div class="row">
          					  <div class="col-lg-12">
            					<div class="well well-sm container">
						            	<h2>Errors:</h2>
						                   <div id="status">
						                   <p> ${Status} </p>
						                   </div>
				     </div>
  		 </div>
   	</div>
   </div>
                  
                </c:if>
   <div class=" col-md-offset-1 form-group">
              <label class=" control-label" for="InputEmail">Email</label>
                    <div class=" col-md-7 input-group">
                        <input type="email" class="form-control" id="emailId" name="emailId"   placeholder="Enter Email"  value="${EmailId}" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                        <form:errors path="emailId" class="label label-primary" cssclass="error"></form:errors>
                        </span>
                       
                        </div>
            </div>

 
  <div class=" form-group">
              <label for="dob">DOB</label>

                  <div class="input-group date col-md-7 ">
                      <input type="text"  id="dob" name="dob" class="datepicker form-control"  placeholder= "Select your date of birth"  >
 <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
  
 </span>                    
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
            <div class="form-group ">
              <label class="control-label" for="secQue1" >Security Question 1</label>
                    <div class="input-group col-md-7">
                        <input type="text" class="form-control" id="SecQue1" name="SecQue1"    value="${SecQue1}" readonly >
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                        <form:errors path="secQue1" class="label label-primary" cssclass="error"></form:errors>
                       </span>
                      
                        </div>
					</div>
         <!-- Sec Ans 1 -->
            <div class="form-group ">
              <label  class="control-label" for="secAns1">Security Answer 1</label>
                    <div class="input-group col-md-7">
                        <input type="text" class="form-control" id="secAns1" name="secAns1" placeholder="Security Ans 1" >
                   <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                       <form:errors path="secAns1" class="label label-primary" cssclass="error"></form:errors>
                       </span>
                        </div>
            </div> 

         <!-- Sec Que 2 -->
            <div class="form-group ">
              <label  class="control-label" for="secQue2">Security Question 2</label>
                    <div class="input-group  col-md-7">
                        <input type="text" class="form-control" id="SecQue2" name="SecQue2"    value="${SecQue2}" readonly >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                         <form:errors path="secQue2" class="label label-primary" cssclass="error"></form:errors>
                         </span>
                        </div>
            </div>
         <!-- Sec Ans 2 -->
            <div class="form-group ">
              <label class="control-label" for="secAns2" >Security Answer 2</label>
                    <div class="input-group col-md-7 ">
                       <input type="text" class="form-control" id="secAns2" name="secAns2" placeholder="Security Ans 2" >
                          <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                         <form:errors path="secAns2" class="label label-primary" cssclass="error"></form:errors>
                         </span>
                        </div>
            
            </div> 
 
    <div class="form-group">
                <input type="submit" name="submit" id="submit" value="Send" class="centered  btn btn-danger  ">
      </div> 
      
         
</form:form>
</div>
</div>

</body>
</html>