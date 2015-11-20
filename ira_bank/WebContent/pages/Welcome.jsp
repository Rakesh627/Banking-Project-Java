<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>

<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onload="">
<%@include file="./common/navbar.jsp" %>


    <div class="container">

        <div class="row">
            <div class="col-lg-12">


                 <c:if test="${ userRegistrationStatus != null}">
             <div class="btn-primary">
                   <div id="status" class="label-primary">${userRegistrationStatus}</div>
             </div>
        </c:if>
                 

                 <c:if test="${ userName != null}">
             <div class="btn-primary">
                   <div id="status" class="label-primary"><h2> Welcome ${userName}<h2></div>
             </div>
        </c:if>
                 

               
                <br>
               	<br> 
            
            </div>
        </div>

    </div>
    <!-- /.container -->

   


</body>
</head>

</html>