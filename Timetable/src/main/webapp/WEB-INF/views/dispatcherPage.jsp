<%@page import="by.bsuir.entity.Flight"%>
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
<script async="" type="text/javascript"
	src="http://yandex.st/jquery/2.0.3/jquery.js"></script>
<title>Диспетчер</title>
</head>
<body>
	<%@ include file="head.jsp"%>
	<hr />
	<center></center>
	<% if (session.getAttribute("authorized") == null || !session.getAttribute("authorized").equals("dispatcher")){%>

	<form action="loginDispatcher" method="GET">
		<hr />
		<div class="container" style="width: 20%">
			<input class="form-control" type="text" name="login"
				placeholder="Логин" /> <input class="form-control" type="password"
				name="password" placeholder="Пароль" /> <input class="form-control"
				type="submit" name="submit" value="Войти" />
		</div>
	</form>
	<%} else {%>
	<br />
	<center>
		<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
	</center>
	<div align="center">
		<a class="btn" href="addFlight">Добавить рейс</a>
	</div>
	<hr />
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

	<c:if test="${not empty allFlight}">
		<form name='deleteFlight' action="deleteFlight" method='GET'
			role="form" enctype="multipart/form-data">
			<div class="container" style="width: 800px; height: 200px;">

				<table border="1" class="table table table-hover table-striped ">
					<tbody>
						<tr>
							<td colspan="13">
								<h4>${cityOtpr}
									<img alt="pl" src="resources/images/plane.png">
									${cityPrib}
								</h4>
							</td>
						</tr>
						<tr>
							<td width="5"></td>
							<td width="5">пн</td>
							<td width="5">вт</td>
							<td width="5">ср</td>
							<td width="5">чт</td>
							<td width="5">пт</td>
							<td width="5">сб</td>
							<td width="5">вс</td>
							<td>Отправление</td>
							<td>Прибытие</td>
							<td>Самолёт</td>
							<td>Рейс</td>
							<td>Выполняются</td>

						</tr>
						<c:forEach items="${allFlight}" var="flight">

							<tr>

								<td width="5"><input type="checkbox" name="idflight"
									value="${flight.id}"></td>

								<td><c:if test="${flight.flightId.days.mon==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.mon==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.tue==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.tue==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.wen==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.wen==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.thu==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.thu==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.fri==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.fri==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.sat==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.sat==false}">
									</c:if></td>
								<td><c:if test="${flight.flightId.days.sun==true}">
										<img alt="pl" src="resources/images/plane.png">
									</c:if> <c:if test="${flight.flightId.days.sun==false}">
									</c:if></td>



								<td>${flight.flightId.timeArrivals}</td>
								<td>${flight.flightId.timeSortie}</td>
								<td>${flight.planeId.name}</td>
								<td>${flight.flightId.name}</td>
								<td>с: ${flight.flightId.dateBegin} <br>
									по:${flight.flightId.dateEnd}
								</td>

							</tr>

						</c:forEach>

					</tbody>
				</table>
				<input class="btn" name="submit" type="submit" value="Удалить" />
		</form>
		</div>
	</c:if>
	<center>
		<c:if test="${not empty successDelete }">
			<i>${successDelete}</i>
		</c:if>
		<c:if test="${not empty errorDelete }">
			<i>${errorDelete}</i>
		</c:if>
	</center>

	<%} %>

</body>
</html>