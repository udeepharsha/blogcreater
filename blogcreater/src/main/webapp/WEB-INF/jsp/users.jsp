<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-bordered table-hover table-striped">
<thead>
<tr><td>user name</td></tr>
</thead>


<tbody>

<c:forEach items="${users}" var="user">
<tr>
<td>
<a href='<spring:url value="/users/${user.id}.html"></spring:url>'>
${user.name}
</a>


</td>



</tr>



</c:forEach>


</tbody>
</table>

</body>
</html>