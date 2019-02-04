<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>


<html>
<head>
<title>Ohio!!</title>
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<springform:form method="POST" modelAttribute="todo">
			<springform:hidden path="id" />
			<fieldset class="form-group">
				<springform:label path="desc">Description</springform:label>
				<springform:input path="desc" type="text" class="form-control"
					name="description" required="required" />
				<springform:errors path="desc" cssClass="text-warning"></springform:errors>
			</fieldset>

			<fieldset class="form-group">
				<springform:label path="targetDate">Target Date</springform:label>
				<springform:input path="targetDate" type="text" class="form-control"
					name="description" required="required" />
				<springform:errors path="targetDate" cssClass="text-warning"></springform:errors>
			</fieldset>

			<button type="submit" class="btn btn-success">Submit</button>
		</springform:form>

		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>

		<script
			src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

		<script>
			$('#targetDate').datepicker({
				format : 'dd/mm/yyyy'
			});
		</script>
	</div>
</body>
</html>