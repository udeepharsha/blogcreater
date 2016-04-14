<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<td>user name</td>
				<td>operations</td>
			</tr>
		</thead>


		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>
					<a href='<spring:url value="/users/${user.id}.html"></spring:url>'>
							${user.name}
						</a>
					</td>
					<td>
						<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger triggerRemove">
							remove
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Modal -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
	      </div>
	      <div class="modal-body">
	        Really remove?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	        <a href="" class="btn btn-danger removeBtn">Remove</a>
	      </div>
	    </div>
	  </div>
	</div>

</body>
</html>