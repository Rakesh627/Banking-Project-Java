<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css" />  
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css.map " /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank </title>
</head>
<body>
<div class="container-fluid">
<div class="row ">
<ul class="nav">
        <li class="active col-md-6 well well-sm"><a  href="<%=request.getContextPath()%>/pages/InternalUsers/Requests.jsp">Requests</a></li>
        <li class="col-md-6 well well-sm "><a  href="<%=request.getContextPath()%>/pages/InternalUsers/Employee_Accounts.jsp">Accounts</a></li>
  </ul>
  </div></div>
  <div class="container-fluid">
<div class="row ">
<div class="col-md-offset-1 col-md-10">
  <div class="panel panel-primary">
  
  <div class="panel-heading">Accounts List</div>
  <div class="panel-body">
   
  <!-- Table -->
  <table class="table">
 <tr>
 <td>Account number </td>
 <td> View</td>
 <td>Edit</td>
 <td>Transactions</td>
 <td>Troubleshoot</td>
 </tr>
  </table>
</div>
</div>
</div></div></div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</html>