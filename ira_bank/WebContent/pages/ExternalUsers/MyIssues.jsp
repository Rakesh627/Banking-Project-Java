<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>I R A Home Page</title>
<!-- The problem was having different folders, so place all css files in CSS folder. -->
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
<script src="<%=request.getContextPath()%>/js/verify.notify.js"></script>
<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
   
    <!-- Add custom CSS here -->

    <style>
        body {
            margin-top: 60px;
        }
    </style>
 

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
     

           <div style="width: 95%; margin: 0 auto;">
       
                
                    <h1>List Of My Issues</h1>
                

                     <br>
                     <table class="table table-condensed">
                        <thead>
                           <tr>
                           	  <th width="12%">Sr. No</th>
                           	 
                             
                             <th width="12%">User Name</th>
                              <th width="12%">Issue Type</th>
                              
                              <th width="12%">Description</th>
                              <th width="12%">Status</th>
                              <th width="12%">Priority</th>
                              <th width="12%">DateTime</th>
                              
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${myissuesList}" var="issues" varStatus="loopCounter">
                           <tr>
                           		<c:if test="${issues.reqType!='Transact'}">
                           		
                               <td><c:out value="${loopCounter.count}" /></td>
                               
                                <td><c:out value="${issues.reqUserId.userName}" /></td>
                                <td><c:out value="${issues.reqType}" /></td>
                                <td><c:out value="${issues.reqDesc}" /></td>
                                <c:if test="${issues.reqStatus=='0'}">
                                <td><c:out value="Pending" /></td>
                                </c:if>
                                <td><c:out value="${issues.reqPriority}" /></td>
                                <td><c:out value="${issues.reqDate}" /></td>
                               
                        </c:if>
								
                            </tr>
                                 <!--  -->           
                           
                            </c:forEach>
                        </tbody>
                     </table>
         </div>



     </div>
       


    </body>

    </html>
