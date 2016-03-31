<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp" %>


<h1> ${user.name} </h1>

<c:forEach items="${user.blogs}" var="blog">

<h1>${blog.name}</h1>
<p>${blog.url}</p>

<table class="table table-bordered table-hover table-striped">
<thead>
<tr>
<td>Title</td>
<td>Link</td>
</tr>

</thead>

<tbody>

<c:forEach items="${blog.items}" var="item">

<tr>
<td>${item.title}</td>
<td>${item.link}</td>
</tr>


</c:forEach>


</tbody>
</table>


</c:forEach>

