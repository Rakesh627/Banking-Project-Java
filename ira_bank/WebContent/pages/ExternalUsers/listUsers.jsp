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
              <!-- Include the hidden form ( the modal pops up has details of these.) -->
           <div id="UserDetailsDialog" style="display: none;">
          
            <jsp:include page="/pages/InternalUsers/userDetailsForm.jsp"></jsp:include>
           </div>
                
                    <h1>List Of Accounts</h1>
                

                     <br>
                     <table class="table table-condensed">
                        <thead>
                           <tr>
                           	  <th width="4%">S.No</th>
                              <th width="12%">Username</th>
                              <th width="12%">Email</th>
                              <th width="12%">FirstName</th>
                              <th width="12%">lastName</th>
                              <th width="12%">Address</th>
                              <th width="12%">Phone</th>
                           </tr>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${usersList}" var="user1" varStatus="loopCounter">
                           <tr>
                               <td><c:out value="${loopCounter.count}" /></td>
                               <td><c:out value="${user1.userName}" /></td>
                               <td><c:out value="${user1.emailId}" /></td>
                               <td><c:out value="${user1.firstName}" /></td>
                               <td><c:out value="${user1.lastName}" /></td>
                               <td><c:out value="${user1.address}" /></td>
                             
                               <td><c:out value="${user1.contactNum}" /></td>
                              
                            <td>
                     <nobr>
                        <button onclick="editUser(${user1.userId});"
                                class="btn btn-primary">
                               Edit
                        </button>


                        <a href="/admin/delete/${user1.userId}" class="btn btn-primary"
                        onclick="return confirm('Are you sure you want to delete this User?');">
                          Delete
                        </a>
                   
                            </tr>
                            </c:forEach>
                        </tbody>
                     </table>
         </div>



     </div>
       


    </body>

    </html>
