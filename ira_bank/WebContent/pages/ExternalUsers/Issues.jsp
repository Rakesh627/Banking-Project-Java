<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Submit An Issue</div>
</div>

<form:form class="form-horizontal" role="form" method="POST" id="issueFormBean" 
                commandName="issueFormBean" action="Issues">
                 <c:if test="${ issueCreationStatus != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${issueCreationStatus}</div>
                           </div>
                      </c:if>
                      <c:if test="${ issueStatus != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${issueStatus}</div>
                           </div>
                      </c:if>
  <div class="form-group">
    <label for="inputissues" class="col-sm-2 control-label">Issues</label>
    <div class="col-sm-7">
      <select class="form-control" id="inputissues" name="issue">
  <option value="Edit Profile">Edit Profile</option>
  <option value="Account Locked">Account Locked</option>
  <option value="Other">Other</option>
</select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputDesc" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-7">
      <textarea class="form-control" rows="3" id="inputDesc" name="description" value="${issueFormBean.description}"></textarea>
      <form:errors path="description" cssclass="error"></form:errors>
    </div>
  </div>
  <div class="form-group">
    <label for="inputpriority" class="col-sm-2 control-label">Priority</label>
    <div class="col-sm-7">
      <select class="form-control" id="inputpriority" name="priority">
  <option value="Critical">Critical</option>
  <option value="Normal">Normal</option>
  <option value="Medium">Medium</option>
 
</select>
    </div>
  </div>
    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form:form>

  
</body>
</html>