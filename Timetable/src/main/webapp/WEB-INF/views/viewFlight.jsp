<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Диспетчер</title>
</head>
<body>
	<%@ include file="head.jsp"%>
	<div class="container" style="width: 400px; height: 220px;">

		<form name='view_Flights' action="view_Flights" method='GET'
			role="form" enctype="multipart/form-data">

			<div class="form-group">
				<label>Откуда :</label> <select class="form-control" name="cityOtpr">
					<c:forEach items="${allCity}" var="city">
						<option value="${city.idcity}">${city.name}</option>
					</c:forEach>
				</select>
			</div>
			<br />
			<div class="form-group">
				<label>Куда :</label> <select class="form-control" name="cityPrib">
					<c:forEach items="${allCity}" var="city">
						<option value="${city.idcity}">${city.name}</option>
					</c:forEach>
				</select>
			</div>

			<input class="btn btn-lg btn-default btn-block " name="submit"
				type="submit" value="Посмотреть" />
		</form>
	</div>

	

</body>
</html>