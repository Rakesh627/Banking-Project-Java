<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>

			  		<form role="form" method="post" action="dashboard.php">
			  		
			  		  <div class="row">
			  		    <label class="col-md-offset-1 col-md-2 margin-top-01  " for="user-id">User Id</label>
					    <div class="col-md-4 ">
					    <input type="text" class="form-control " name="user-id" id="user-id" placeholder="user-id" value="" disabled></div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn btn-default" id="edit-user-id">Edit</a>
			  		  </div><br/>
			  		  <div class="row">
			  		    <label class=" col-md-offset-1 col-md-2 margin-top-01 " for="first-name">D.O.B</label>
					    <div class="col-md-4 ">
					    <input type="date" class="form-control " name="D.O.B" id="D.O.B" placeholder="Date of Birth" value="" disabled></div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn btn-default" id="edit-D.O.B">Edit</a>
			  		  </div><br/>
			  		   <div class="row">
					    <label class=" col-md-offset-1 col-md-2 margin-top-01 " for="first-name">First Name</label>
					    <div class="col-md-4 ">
					    <input type="text" class="form-control " name="first-name" id="first-name" placeholder="Enter First Name" value="" disabled></div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn btn-default" id="edit-first-name">Edit</a>
			  		  </div><br/>
					  <div class="row">
					    <label class=" col-md-offset-1 col-md-2 margin-top-01 control-label" for="last-name">Last Name</label>
					    <div class="col-md-4">
					    <input type="text" class="form-control col-md-4" name="last-name" id="last-name" placeholder="Enter Last Name" value="" disabled> 
					    </div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn" id="edit-last-name">Edit</a>
					  </div><br/>
					  <div class="row">
					    <label class=" col-md-offset-1 col-md-2 margin-top-01" for="email">E Mail</label>
					     <div class="col-md-4">
					    <input type="email" class="form-control col-md-4" name="email" id="email" placeholder="Enter Email" value="" disabled>
					    </div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn" id="edit-email">Edit</a>
					  </div>
					  <div class="row">
					    <label class=" col-md-offset-1 col-md-2 margin-top-01 control-label" for="last-name">Last Name</label>
					    <div class="col-md-4">
					    <input type="text" class="form-control col-md-4" name="last-name" id="last-name" placeholder="Enter Last Name" value="" disabled> 
					    </div>
					    <a class="col-md-offset-1 col-md-1 margin-top-01" type="btn" id="edit-last-name">Edit</a>
					  </div><br/>
					  <div class="row">
					    <label class="col-md-2 margin-top-01" for="confirm-password">Confirm Password</label>
					    <input type="password" class="form-control col-md-4" id="confirm-password" placeholder="Confirm Password" disabled required> 
					  </div>
					  <br><br>
					  <div class="col-md-6 text-center">
					  	<button type="submit" name="save" id="save" class="btn btn-default">Save</button>
					  </div></div>
					</form>

				

</body>
</html>