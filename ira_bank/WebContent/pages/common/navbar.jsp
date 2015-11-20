<!DOCTYPE html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- For Back button and Refresh -->
<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", 0);
%>
<html> <!-- The problem was having different folders, so place all css files in CSS folder. -->
 <!-- Bootstrap css -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/keyboard.css">
<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

<!-- Jquery JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/keyboard.js" charset="UTF-8"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>
<script src="<%=request.getContextPath()%>/js/verify.notify.js"></script>
<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- For Back button and Refresh -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>I.R.A Bank</title>
</head>
<body>

<nav class="navbar navbar-default " role="navigation">
<div class="container-fluid">
      <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
               			 </button>
                <a class="navbar-brand" href="#">I.R.A Bank</a>
      </div>
		
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse  navbar-collapse navbar-ex1-collapse">
            
            <ul class="nav navbar-nav"><!-- main button group -->

               <!--1.  Accounts -->
               <!-- Admin -->
               <sec:authorize access="hasRole('ROLE_ADMIN')">
    				      <li class="dropdown">
    				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Accounts <span class="caret"></span></a>
                       	  <!--  Admin -->   
                       		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                            
                        	 <li><a href="<%=request.getContextPath()%>/admin/listAllUsers">All Users list</a></li>
                             <li><a href="<%=request.getContextPath()%>/admin/viewPII">View PII</a></li>
                       		 <li><a href="<%=request.getContextPath()%>/admin/listUsers">Edit Users</a></li>	
                       		 
                      	</ul>
                      </li>	
               </sec:authorize>    
      				<!-- User Account Details -->
      				 <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_MERCHANT')">
      				 <li class="dropdown">
      				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Accounts<span class="caret"></span></a>
                         	  <!--  Admin -->   
                         		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
           					  <li><a href="<%=request.getContextPath()%>/user/showAccountInfo">My Account Details</a></li>
                        		 </ul>
                      </li>	
                     </sec:authorize>    
      				<!-- EMPLOYEE -->
               <sec:authorize access="hasRole('ROLE_EMPLOYEE')">
          				 <li class="dropdown">
          				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Accounts <span class="caret"></span></a>
                             	  <!--  Admin -->   
                             		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                                  
                      
                                   <li><a href="<%=request.getContextPath()%>/admin/listAccounts">Transactional Access</a></li>
                             		 <li><a href="<%=request.getContextPath()%>/admin/listAccounts">Technical Account Access</a></li>
                             		 		
                            	
                            	</ul>
                            </li>	
               </sec:authorize>    
               
               
              <!--  2. Functionalities. -->
              
        
               <!-- User -->
               <sec:authorize access="hasRole('ROLE_USER')">
          				 <li class="dropdown">
          				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Transfers <span class="caret"></span></a>
                             	  <!--  Admin -->   
                             		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                                   <li><a href="<%=request.getContextPath()%>/ExternalUsers/credit_debit">Credit/Debit Transactions</a></li>
                                    <!-- transfer funds -->
                                  <li><a href="<%=request.getContextPath()%>/ExternalUsers/Transfer_funds">Transfer Funds</a></li>
                                  <!-- Bill pay -->
                              
				  					<li><a href="<%=request.getContextPath()%>/ExternalUsers/BillpayUser">User Billpay</a></li>
				  					<li><a href="<%=request.getContextPath()%>/ExternalUsers/Billpayuserstatus">Billpay Status</a></li>
                                  <li><a href="<%=request.getContextPath()%>/ExternalUsers/EditProfile">My Profile</a></li>
                            	   </ul>
                      </li>	
               </sec:authorize>    
               
               	<!-- Merchant Transactions -->
                    
                 
                 <sec:authorize access="hasRole('ROLE_MERCHANT')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Transfers<span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                         <li><a href="<%=request.getContextPath()%>/ExternalUsers/credit_debit">Credit/Debit Transactions</a></li>
                          <!-- transfer funds -->
                        <li><a href="<%=request.getContextPath()%>/ExternalUsers/Transfer_funds">Transfer Funds</a></li>
                        <!-- Bill pay -->
                       <li><a href="<%=request.getContextPath()%>/ExternalUsers/Billpaymerchant">Merchant Billpay</a></li>
                       <li><a href="<%=request.getContextPath()%>/ExternalUsers/BillpaymerchantApprove">Approve Billpay</a></li>
                       <li><a href="<%=request.getContextPath()%>/ExternalUsers/Billpaymerchantstatus">Billpay Status</a></li>
                       <li><a href="<%=request.getContextPath()%>/ExternalUsers/EditProfile">My Profile</a></li>
                  	</ul>
                  </li>	
               </sec:authorize>    
               
				<!-- EMPLOYEE TRANSACTION-->
               <sec:authorize access="hasRole('ROLE_EMPLOYEE')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Transfers<span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                      
                   		 <li><a href="<%=request.getContextPath()%>/InternalUsers/BillpayRequests">Approve BillPay</a></li>		
                  	
                  	</ul>
                  </li>	
               </sec:authorize>   
               
               
               <!-- ADMIN TRANSACTION-->
               <sec:authorize access="hasRole('ROLE_ADMIN')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Transfers<span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                       <li><a href="<%=request.getContextPath()%>/admin/listTransactions">Transactional Account Access</a></li>
      
                  	
                  	</ul>
                  </li>	
               </sec:authorize>   
               
              
              <!--  3. Issues -->
              
            <!--  Merchant and user --> 
             <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_MERCHANT')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Requests / Issues <span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                         <li><a href="<%=request.getContextPath()%>/ExternalUsers/Issues">New Issue</a></li>
                            <li><a href="<%=request.getContextPath()%>/ExternalUsers/MyIssues">My Issues</a></li>
                  	</ul>
                  </li>	
             </sec:authorize>  
             
             <!-- Admin -->
              <sec:authorize access="hasRole('ROLE_ADMIN')">
				        <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Requests / Issues <span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
 								<li><a href="<%=request.getContextPath()%>/admin/ListIssues">View Pending Issues</a></li>
                  	</ul>
                  </li>	
             </sec:authorize>  
               
             <!--  4. Transactions. -->
              
        
               <!-- User -->
                <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_MERCHANT')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Internal Transactions <span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                         <li><a href="<%=request.getContextPath()%>/user/ExternalUsers/Request">Request Transactions</a></li>
                        <li><a href="<%=request.getContextPath()%>/user/ExternalUsers/listTransactions">My Transactions</a></li>
                  	</ul>
                  </li>	
               </sec:authorize>  
               
               <!-- Employee -->
               <sec:authorize access="hasAnyRole('ROLE_EMPLOYEE','ROLE_ADMIN')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Internal Transactions <span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
                       
                        <li><a href="<%=request.getContextPath()%>/admin/listTransactions">View All Transactions</a></li>
                  	</ul>
                  </li>	
               </sec:authorize>  
             
             
             <!-- 5. System Log -->  
             <sec:authorize access="hasRole('ROLE_ADMIN')">
				 <li class="dropdown">
				    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Log <span class="caret"></span></a>
                   	  <!--  Admin -->   
                   		 <ul class="dropdown-menu  dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1">
 							<li><a href="<%=request.getContextPath()%>/admin/show_log">View System Log</a></li>
 							<li><a href="<%=request.getContextPath()%>/admin/ListIssues">View Critical Transactions Log</a></li>
                  		 </ul>
                  </li>	
             </sec:authorize>  
                 
        	 </ul>
        	 
        	 
        	 <!--  second ul tag --> 
        	 <ul class="nav navbar-nav navbar-right">
       			 <li><a href="<c:url value="/j_spring_security_logout" />"><span class="label label-danger">Logout</span></a></li>	 
        	 
        	 </ul>

       </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    
</body>
 <!-- JavaScript -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</html>
