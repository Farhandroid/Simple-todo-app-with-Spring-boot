<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Ohio!!</title>
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${todoList}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${todo.targetDate}" /></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-info"
							href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a type="button" class="btn btn-success" href="/add-todo">Add a
			Todo</a>
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	</div>

</body>
</html>