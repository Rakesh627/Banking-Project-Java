<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>
<div class="row ">
<div class="col-md-offset-1 col-md-10">
  <div class="panel panel-primary">
  
  <div class="panel-heading">Accounts Information</div>
  <div class="panel-body">
   
  <!-- Table -->
  <table class="table table-condensed">
                        <thead>
                           <tr>
                           	  <th width="12%">Sr. No</th>
                              <th width="12%">Account Number</th>
                              <th width="12%">Balance</th>
                              
                           </tr>
                        </thead>
                   
                   
                   <tbody> 
                       <tr>
                      
                          <c:if test="${showAccountInfo != null}">
                               <td><c:out value="1." /></td>
                               <td><c:out value="${showAccountInfo.accountNumber}" /></td>
                               <td><c:out value="${showAccountInfo.balance}" /></td>
         					</c:if>		
                          </tr>
                    </tbody>
    </table>

</div>
</div>
</div></div>
</body>
</html>