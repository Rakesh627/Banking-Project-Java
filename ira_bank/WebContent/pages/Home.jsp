<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I.R.A Bank</title>

    
</head>
<body>

<div class="row">
<div class="well-lg col-md-6">


<div class="panel panel-primary">
            <div class="panel panel-heading">
            I.R.A BANK
            </div>
              
              <form name="loginForm" id="loginForm" action="login" method='POST' class="well form-inline" >

             <br>

             <c:if test="${ userRegistrationStatus != null}">
                 <div class="btn-primary">
                       <div id="status" class="label-primary">${userRegistrationStatus}</div>
                 </div>
              </c:if>
             <br>

             
            <%
                /*Check if Login did not happen*/
                if(request.getAttribute("loginError") != null)
                {%>
                <p ><span class="label label-warning" style="float:right;font-weight:bold;">${loginError}</span></p>    
              <%}%>


              <input type="text" class="form-control" id="j_username" name='j_username' placeholder="Username" maxlength="30">
                  <br>
                 <input type="password" class="form-control" placeholder="Password"  id="j_password" name='j_password' maxlength="15">
                 
                <!-- placeholder -->
                <div> <br><br></div>

                <div class="form-inline">
                <input name="login" type="submit" value="Login" class = "btn btn-primary"/>
                <input name="cancel" type="reset" value="Cancel"  class = "btn btn-danger"/>

                <a href="<%=request.getContextPath()%>/register" style="float:right;font-weight: bold;"><span class="label label-warning">New User Registration<span></a>
                <a href="<%=request.getContextPath()%>/Forgot" style="float:left;font-weight: bold;"><span class="label label-warning">Forgot Password<span></a>
                </div>

             </form>
    
</div>

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
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>