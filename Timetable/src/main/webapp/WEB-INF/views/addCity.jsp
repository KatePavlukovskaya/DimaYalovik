<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Добавление самолёта</title>
</head>
<body>

	<%@ include file="head.jsp"%>
	<br />
	
	<div class="container" style="width: 400px; height: 550px;">

		<h2 class="form-signin-heading font-text" style="text-align: center;">Добавление города</h2>
		<hr/>
			<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
		<form name='addCity' action="add_city" method='GET'
			role="form" enctype="multipart/form-data">
			<div class="form-group">
				<label>Город:</label> <input class="form-control" type='text'
					name='name' placeholder="Название города" required>
			</div>	
					
			<input class="btn btn-lg btn-default btn-block " name="submit"
				type="submit" value="Добавить" />
				
		</form>

	</div>
	

</body>
</html>