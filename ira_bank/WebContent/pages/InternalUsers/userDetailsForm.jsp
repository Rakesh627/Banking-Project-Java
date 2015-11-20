<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<c:url var="actionUrl" value="/admin/save" />

<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>


<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</head>
<body>
<form:form id="userDetailsForm" commandName="userDetailsFormBean" method="post"
	action="${actionUrl}" class="modal-dialog">

	<fieldset>
		<legend>Edit User Details</legend>

		<div class="form-control">
			<label for="UserName">UserName</label>
			<form:input path="userName"  required="required" placeholder="Username" />
			
		</div> 

		<div class="form-control">
			<label for="First Name">Email Id</label>
			<form:input path="emailId" required="required"  placeholder="Email Id" />
		</div>


		<div class="form-control">
			<label for="First Name">First Name</label>
			<form:input path="firstName"  required="required" placeholder="firstName"  />
		</div>
		<div class="form-control">
			<label for="Last Name">Last Name</label>
			<form:input path="lastName" required="required" placeholder="Last Name"  />
		</div>

		<div class="form-control">
			<label for="Address">Address</label>
			<form:input path="address" required="required" placeholder="address"  />
		</div>

		<div class="form-control">
			<label for="contactNum">Phone Number</label>
			<form:input path="contactNum" required="required" placeholder="contactNum" />
		</div>


	    <div class="form-control">
			<label for="secQue1">Sec Que 1</label>
			<form:input path="secQue1" required="required"  placeholder="secQue1"  />
		</div>

		<div class="form-control">
			<label for="secAns1">Sec Ans 1</label>
			<form:input path="secAns1" required="required" placeholder="secAns1"/>
		</div>

		<div class="form-control">
			<label for="secQue2">Sec Que 1</label>
			<form:input path="secQue2" required="required" placeholder="secQue2" />
		</div>
		<div class="form-control">
			<label for="secAns2">Sec Ans 2</label>
			<form:input path="secAns2" required="required" placeholder="secAns2" />
		</div>

		<form:input path="userId" type="hidden" />


	</fieldset>
</form:form>



</body>
