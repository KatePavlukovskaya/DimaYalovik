<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="head.jsp"%>
	<hr />
	<center>
		<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
	</center>
	<%
		if (session.getAttribute("authorized") == null
				|| !session.getAttribute("authorized").equals("admin")) {
	%>

	<form action="login" method="GET">
		<hr />
		<div class="container" style="width: 20%">
			<input class="form-control" type="text" name="login"
				placeholder="Логин" /> <input class="form-control" type="password"
				name="password" placeholder="Пароль" /> <input class="form-control"
				type="submit" name="submit" value="Войти" />
		</div>
	</form>
	<%
		} else {
	%>
	<br />
	<table align="center">
		<tr>
			<td align="center">
				<ul class="nav nav-pills">
					<li><a href="viewPlanes"><img
							src="resources/images/air_plane_airport.png" />
						<h2>Самолёты</h2></a></li>
					<li><a href="viewCity"><img
							src="resources/images/178city.png" width="128" height="128" />
						<h2>Города</h2></a></li>
					<li><a href="viewCrew"><img
							src="resources/images/pilot.png" />
						<h2>Экипажи</h2></a></li>
				</ul>
			</td>
		</tr>
	</table>
	<%} %>
</body>
</html>