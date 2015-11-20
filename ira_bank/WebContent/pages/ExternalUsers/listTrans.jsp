<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>I R A Home Page</title>

    <!-- Add custom CSS here -->

    <style>
        body {
            margin-top: 60px;
        }
    </style>
    <script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

    <script src="<%=request.getContextPath()%>/js/requestDetails.js"  type="text/javascript" ></script>

</head>

<body>
<%@include file="../common/navbar.jsp" %>
    <div class="container">

        <c:if test="${ userName != null}">
             <div class="btn-primary">
                   <div id="status" class="label-primary">
                   <h2> Welcome ${userName}</h2></div>
             </div>
        </c:if>
     

           <div id=style="width: 95%; margin: 0 auto;">

           <!-- Include the hidden form ( the modal pops up has details of these.) -->
          
                    <h1>List Of Transactions</h1>
                

                     <br>
                     <label class="inputtext3"> ${userRegistrationStatus}</label>
                     <c:if test="${useThis == true}" >
                                 <li><a href="<%=request.getContextPath()%>/admin/ApprovedTransactions">Approved Transactions</a></li>
                     
                     <table class="table table-condensed">
                        <thead>
                           <tr class="success">
                              <th width="4%">S.No</th>
                              <th width="12%"> Request Id</th>
                              <th width="4%">User Id</th>
                              
                             
                              <th width="10%">From Account</th>
                               <th width="10%">To Account</th>
                                <th width="8%"> Amount</th>
                             
                              <th width="12%">Transaction Date</th>
                              <th width="12%">Transaction Type</th>
                              <th width="12%">Approved</th>
                              <th width="12%">Transaction Priority</th>
                              <th width="12%">Transaction ID</th>
                             
                           </tr>
                        </thead>
                       
                        <tbody>
                           <c:forEach items="${RequestDetailsList}" var="requestDetails" varStatus="loopCounter">
                           <c:if test="${ requestDetails.getIsApproved() == false}">
                           <tr>
                           
                           <form method = "POST" >
                               <td><c:out value="${loopCounter.count}" /></td>
                               <input  name="reqId"  type="hidden" class="form-control"  placeholder="RequestID" maxlength="15" value="<c:out value="${requestDetails.getReqId()}" />" readonly="readonly"/>
                               <td><c:out value="${requestDetails.getReqId()}"/></td>
                               <input name="userId"   type="hidden" class="form-control"  placeholder="userId" maxlength="10" value="<c:out value="${requestDetails.getReqUserId().getUserId()}" />" readonly="readonly"/> 
                               <td><c:out value="${requestDetails.getReqUserId().getUserId()}" /></td>
                               
                               <c:set var="stringDesc" value="${fn:split(requestDetails.getReqDesc(), ',')}" />
                               <input name="reqDesc" style="height: 150%;" type="hidden" class="form-control"  placeholder="reqDesc" maxlength="40" value="<c:out value="${stringDesc[0]}"  />"  readonly="readonly"/>
                              <td><c:out value="${stringDesc[0]}"  /> </td>
                            <input name="reqDesc" style="height: 150%;" type="hidden" class="form-control"  placeholder="reqDesc" maxlength="40" value="<c:out value="${stringDesc[1]}"  />"  readonly="readonly"/>
                            
                            <td><c:out value="${stringDesc[1]}"/></td>
                            <input name="reqDesc" style="height: 150%;" type="hidden" class="form-control"  placeholder="reqDesc" maxlength="40" value="<c:out value="${stringDesc[2]}"  />"  readonly="readonly"/>
                            <td><c:out value="${stringDesc[2]}"/> </td>
                               
                               <td><c:out value="${requestDetails.getReqDate()}" /></td>
                               <td><c:out value="${requestDetails.getReqType()}" /></td>
                               <td><c:out value="${requestDetails.getIsApproved()}" /></td>
                               
                               <td><c:out value="${requestDetails.getReqPriority()}" /></td>
                               <input  name="transId"  type="hidden" class="form-control"  placeholder="TransactionId" maxlength="15" value="<c:out value="${requestDetails.getReqTransId().getTransId()}" />" readonly="readonly"/></td>
                               
                               <td><c:out value="${requestDetails.getReqTransId().getTransId()}" /> <td>
                           
		                        <button   name ="save" type="submit" class="btn btn-default"  formaction="/ira_bank/admin/edit">Edit</button>
		                        
                       		 <c:if test="${button== true}" >
                             <button   name ="${requestDetails.getReqUserId().getUserId()}"type="submit" class="btn btn-default" formaction="/ira_bank/admin/Transaction/Approval">Approve</button>
     						 </c:if>
				     
                       		 </form>
                            </tr>
                            </c:if>
                            </c:forEach>
                            
                        </tbody>
                        	
                     </table>
                     </c:if>
         </div>
         <!-- List of All Approved Transactions -->
         <br>
                     <c:if test="${approved == true}" >
                     <table class="table table-condensed">
                        <thead>
                           <tr class="success">
                              <th width="4%">S.No</th>
                              <th width="6%">Request Id</th>
                              <th width="6%">User Id</th>
                              <th width="22%">Transaction Description<br/> FROM | TO | AMOUNT</th>
                              <th width="12%">Transaction Date</th>
                              <th width="12%">Transaction Type</th>
                              <th width="12%">Approved</th>
                             
                              <th width="12%">Transaction ID</th>
                             
                           </tr>
                        </thead>
                       
                        <tbody>
                           <c:forEach items="${RequestDetailsList}" var="requestDetails" varStatus="loopCounter">
                           <c:if test="${ requestDetails.getIsApproved() == true}">
                           <tr>
                            <form method = "POST" id="form1">
                               <td><c:out value="${loopCounter.count}" /></td>
                               <input form="form1" name="reqId"  type="hidden" class="form-control"  placeholder="RequestID" maxlength="15" value="<c:out value="${requestDetails.getReqId()}" />" readonly="readonly"/>
                               <td>${requestDetails.getReqId()}</td>
                               <input name="userId" form= "form1" type="hidden" class="form-control"  placeholder="userId" maxlength="10" value="<c:out value="${requestDetails.getReqUserId().getUserId()}" />" readonly="readonly"/> 
                             <td>${requestDetails.getReqUserId().getUserId()}</td>
                             <input name="reqDesc" form="form1"  type="hidden" class="form-control"  placeholder="reqDesc" maxlength="10" value="<c:out value="${requestDetails.getReqDesc()}" />"  readonly="readonly"/>
                              
                               <td>${requestDetails.getReqDesc()}</td>
                               <td><c:out value="${requestDetails.getReqDate()}" /></td>
                               <td><c:out value="${requestDetails.getReqType()}" /></td>
                               <td><c:out value="${requestDetails.getIsApproved()}" /></td>
                               <input form="form1" name="transId"  type="hidden" class="form-control"  placeholder="TransactionId" maxlength="15" value="<c:out value="${requestDetails.getReqTransId().getTransId()}" />" readonly="readonly"/></td>
                              <td> ${requestDetails.getReqTransId().getTransId()} <td>
                     		 </form>
                            </tr>
                            </c:if>
                            </c:forEach>
                            
                        </tbody>
                     </table>
                     </c:if>
         </div>
<div>
<c:if test="${useThis == false}">
<table class="table table-condensed">
<thead>
                           <tr class="success">
                              <th width="4%">S.No</th>
                           
                              <th width="12%">Transaction Description<br/> FROM | TO | AMOUNT</th>
                              <th width="12%">Transaction Date</th>
                              <th width="12%">Transaction Type</th>
                            
                             
                           </tr>
                        </thead>
<c:forEach items="${RequestDetailsList}" var="requestDetails" varStatus="loopCounter">


<c:if test="${userIdCompare == requestDetails.getReqUserId().getUserId()}">
<c:if test="${setView == requestDetails.getReqType()}">
                        
                       
                        <tbody>
                           
                           
                           <tr>
                            <form method = "POST" id="form1">
                               <td><c:out value="${loopCounter.count}" /></td>
                               <input name="reqDesc" form="form1"  type="hidden" class="form-control"  placeholder="reqDesc" maxlength="10" value="<c:out value="${requestDetails.getReqDesc()}" />"  readonly="readonly"/>
             
                              <td>${requestDetails.getReqDesc()}</td>
                               <td><c:out value="${requestDetails.getReqDate()}" /></td>
                               <td><c:out value="${requestDetails.getReqType()}" /></td>
                         
                                            
                       		 </form>
                            </tr>

                           
                            
                        </tbody>
                        </c:if>
                          </c:if>
                      </c:forEach>
                     </table>
                     </c:if>
                   

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

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker.js"  type="text/javascript" ></script>


    </body>

    </html>
