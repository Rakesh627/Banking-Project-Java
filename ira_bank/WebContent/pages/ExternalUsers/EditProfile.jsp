<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Edit Profile</div>
</div>
<div class="container-fluid">
<div class="row">

<form:form  role="form" method="POST" id="editProfileFormBean" 
                commandName="editProfileFormBean" action="EditProfile">
                <c:if test="${ editStatus != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${editStatus}</div>
                           </div>
                      </c:if>   
                 <c:if test="${ updateStatus != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${updateStatus}</div>
                           </div>
                      </c:if>
                   
                      <!-- Email -->
                      
  <div class="form-group">
              <label class="control-label" for="InputEmail">Email</label>
                    <div class="col-md-7 input-group">
                        <input type="email" class="form-control" id="emailId" name="emailId"  data-validate="required,email" value="${editProfileFormBean.emailId}" >
                        <form:errors path="emailId" cssclass="error"></form:errors>
                        </div>
            </div>
            <!--  username -->
            <div class="form-group">
                <label class="control-label" for="Username">Username</label>
                    <div class="col-md-7 input-group">
                            <input type="text" id="userName" name="userName"  class="form-control" value="${editProfileFormBean.userName}">  
                           <form:errors path="userName" cssclass="error"></form:errors>
                    		 
                    </div>
            </div>
            
                    <!-- First Name -->            
           <div class="form-group">
              <label class=" control-label" for="FirstName">First Name</label>
                    <div class="col-md-7 input-group">
                        <input type="text" class="form-control" id="firstName" name="firstName"value="${editProfileFormBean.firstName}">
                        <form:errors path="firstName" cssclass="error"></form:errors>
                    	 
                    </div>
            </div>
             <!-- Last Name -->
              <div class="form-group">
              <label class=" control-label" for="LastName">Last Name</label>
                    <div class="col-md-7 input-group">
                        <input type="text" class="form-control" id="lastName" name="lastName"value="${editProfileFormBean.lastName}">
                        <form:errors path="lastName" cssclass="error"></form:errors>
                    	 
                    </div>
            </div>
            <!-- Address -->
            <div class="form-group">
              <label class=" control-label" for="address">Address</label>
                    <div class="col-md-7 input-group">
                        <textarea class="form-control " id="address"  rows="2"  name="address" value="${editProfileFormBean.address}"> </textarea>
                        <form:errors path="address" cssclass="error"></form:errors>
                         
                        </div>
                        </div>
                         <div class="form-group">
              <labelclass=" control-label" for="contactNum">Phone Number</label>
                   <div class="col-md-7 input-group">
                        <input type="phone" class="form-control" id="contactNum" name="contactNum" value="${editProfileFormBean.contactNum}">
                       <form:errors path="contactNum" cssclass="error"></form:errors>
                        
                        </div>
            </div>
      
    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
       
  
</form:form>
</div>
</div>
  
</body>
</html>