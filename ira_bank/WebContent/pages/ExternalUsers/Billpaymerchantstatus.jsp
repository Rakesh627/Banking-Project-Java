<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css" />  
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css.map " />  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bill Pay Status</title>
</head>
<body>
<%
String context_path=request.getContextPath();
String navbar_path=context_path+"/pages/navbar.jsp";
%>
<%@include file="../common/navbar.jsp" %>

  <div class="container-fluid">
<div class="row ">
<div class="col-md-offset-1 col-md-10">
  <div class="panel panel-primary">
  
  <div class="panel-heading">Merchant Bill Pay Status</div>
  <div class="panel-body">
  </div>
  
        <c:if test="${accountStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${accountStatus}</div>
                </div>
  		</c:if>
     
  <!-- Table -->
  
  <table class="table table-condensed">
  	<thead>
			 <tr>
			 <td>Request Id</td>
			 <td>User Account Number</td>
			 <td>Amount</td>
			 <td>Status</td>
			 <td>Description</td>
			 </tr>
    </thead>
			 
			 <tbody>
			 <c:forEach items="${BillpayInfo}" var="Billpaylist" varStatus="loopCounter">
			 <c:if test="${Billpaylist.merchantId.userId == UserID}">
			   <c:forEach items="${NotificationdetailInfo}" var="Notificationlist" varStatus="loopCounter">		   
			   <c:if test="${Billpaylist.billId == Notificationlist.notificationBillid.billId}">		   
			   <tr>	   
			   <td><c:out value="${Notificationlist.notificationBillid.billId}" /></td>         
			   <td><c:out value="${Billpaylist.acctNumber}" /></td>
			   <td><c:out value="${Billpaylist.amount}" /></td>
			   <td><c:out value="${Notificationlist.notificationStatus}" /></td>	                      
			   <td><c:out value="${Notificationlist.notificationDescription}" /></td>
			   </tr>
			   </c:if>
			   </c:forEach>
			 </c:if>
			</c:forEach> 
			</tbody>
	</table>
</div>
</div>
</div>
</div>


</body>
</html>