<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchant BillPay</title>
</head>
<body>
<%
String context_path=request.getContextPath();
String navbar_path=context_path+"/pages/navbar.jsp";
%>
<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Bill Pay Merchant</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
  
      <c:if test="${ accountStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${accountStatus}</div>
                </div>
  	</c:if>
  
    <form:form class="form-horizontal" role="form" action="/ira_bank/ExternalUsers/Billpaymerchant" method="post" id="billpaymerchantFormBean" 
                commandName="billpaymerchantFormBean">
    
  <div class="form-group">
    <label for="accountnumber" class="col-sm-2 control-label">Account Number</label>
    <div class="col-sm-7 col-md-7">
      <input name="account" type="Text" class="form-control" id="inputaccount" placeholder="Account Number" value="" required>
    </div>
    <form:errors path="account" class="label label-primary" cssclass="error"></form:errors>
  </div>

  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="" required>
    </div>
    <form:errors path="amount" class="label label-primary" cssclass="error"></form:errors>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Send</button>
    </div>
  </div>
</form:form>
    
  </div>
</body>
</html>