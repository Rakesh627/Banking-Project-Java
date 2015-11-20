<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

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

<body>
<center>
        <h2>Thank you, your email has been sent.</h2>
    </center>
    <div class="panel panel-primary">
  <div class="panel-heading">One Time Password</div>
</div>


  <div class="panel-body">
    <form role="form-horizontal" action="/ira_bank/OTP"  
                method="POST">
                   <c:if test="${ Status != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${Status}</div>
                           </div>
                      </c:if>
                <input type="hidden" name="email"  id="exampleInputemail" value="${EmailId}"  >
  <div class="form-group ">
    <label for="exampleInputOTP">Enter OTP</label>
    <div class="input-group col-md-7">
    <input type="Text" name="otp"  id="exampleInputOTP" placeholder="Enter OTP" class=" form-control">
    <input type="hidden" name="createtime"  id="createtime" value="${Time}" class="form-control">
    </div>
  </div>
  <div class="form-group col-md-7">
     <button type="submit" class="btn btn-default">Submit</button>
     </div>
</form>
</div>
</body>
</html>