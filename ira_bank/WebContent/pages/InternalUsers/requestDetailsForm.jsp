
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<body>
<%@include file="../common/navbar.jsp" %>

<c:url var="actionUrl" value="save" />

<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


</head>
<body>
<div><label for="inputText3">${userRegistrationStatus}</label></div>
<form:form id="requestDetailsForm" commandName="requestDetailsFormBean" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend>Edit User Details</legend>
		<br/>${requestDetailsFormBean.setReqDesc(requestDetailsFormBean.getReqDesc())}
		
					<div><label class="inputText3"> ${requestDetailsFormBean.getReqDesc()}</label></div>
		
<form>
		<div class="form-control">
			<label for="Description">From|TO|Amount</label>
			 <%-- value="${requestDetailsFormBean.getReqDesc()}" --%>
			
			 
		<form:input path="reqDesc" required="required" type="text" placeholder="reqDesc" />
			    <form:errors path="reqDesc" class="label label-primary" cssclass="error"></form:errors>
			
		</div> 

		<div class="form-control">
			
			<%-- value="${requestDetailsFormBean.getReqDate()}" --%>
			<form:input type="hidden" path="reqDate" required="required"  placeholder="reqDate" value="${requestDetailsFormBean.reqDate}" />
		</div>
		<input  type="hidden"  name="reqUsedId" value = <%=request.getAttribute("TextValue")%> />
		<input  type="hidden"  name="reqId" value = <%=request.getAttribute("requestID")%> />
		
		
		<form:input path="reqId" type="hidden" value="${requestDetailsFormBean.reqDesc}" />
		<input type="submit" formaction="/ira_bank/admin/save" name="save">

</form>
	</fieldset>
</form:form>



</body>
