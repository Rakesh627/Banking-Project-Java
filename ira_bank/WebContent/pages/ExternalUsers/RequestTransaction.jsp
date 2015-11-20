<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/keyboard.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/keyboard.js" charset="UTF-8"></script>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Request Transaction</title>

</head>
<body>

<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Request Transactions</div>
</div>


<div style="font-variant: small-caps; font-weight: lighter;"><label for="inputText3"> ${userRegistration}</label>
<div style="font-family: inherit;color: red;"><label for="inputText3">${userName}</label></div>
<br/>
<div style="background-color: beige; font-size: large;"><lable for="inputText3" >${userRegistrationStatus}</lable>
 </div>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
      <c:if test="${transferStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${transferStatus}</div>
                </div>
  </c:if>
  
    <form:form class="form-horizontal" role="form" action="/ira_bank/user/ExternalUsers/CreateTransaction" method="POST" id="InternalTransactionFormBean" 
    commandName="InternalTransactionFormBean"> 
  
  <div class="form-group">
 
    <label for="inputText3" class="col-sm-2 control-label">From</label>
    <div class="col-sm-7">
      <input name="from_account"  type="Text" class="form-control" id="inputText3" placeholder="From Account Number" data-validate="required" value = <%=request.getAttribute("TextValue")%>  readonly="true" required>
    </div>
       <form:errors class="label label-primary" path="from_account" cssclass="error"></form:errors>
    
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">To</label>
    <div class="col-sm-7 col-md-7">
      <input name="to_account" class="form-control type="text"  id="inputPassword3" placeholder="To Account Number" data-validate="required" value="${InternalTransactionFormBean.to_account}">
    </div>
       <form:errors class="label label-primary" path="to_account" cssclass="error"></form:errors>
    
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" class="form-control type="text" id="inputamount" placeholder="Amount" data-validate="required" value="${InternalTransactionFormBean.amount}">
   
    </div>
    <form:errors class="label label-primary" path="amount" cssclass="error"></form:errors>
  </div>
   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
	 <!-- Button for Request Transaction -->
	  <button type="submit" class="btn btn-default">Request Transaction</button>
      
    </div>
  </div>
</form:form>


    
  </div>
</div>

</body>
</html>