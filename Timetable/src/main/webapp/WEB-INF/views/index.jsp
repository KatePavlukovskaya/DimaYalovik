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

<title>Составление рассписания</title>
<style>
   <%@include file='css.css' %>
   

</style>

</head>

<body>
<%@ include file="head.jsp"%>

		<div class="container" style="width: 400px; height: 320px;">

		<form name='view_Flights_index' action="view_Flights_index" method='GET'
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
			<br />
			<div class="form-group">
			<label>Дата вылета:</label>
			 <input class="form-control"  type="date" name="date" value="${date}"
			  max="2017-01-01" min="${date}"/>
			</div>

			<input class="btn btn-lg btn-default btn-block " name="submit"
				type="submit"  value="Посмотреть" />
		</form>
	</div>
	
	<c:if test="${not empty error }">
	<hr/>
			<center><i style="color: red">${error }</i></center>
	</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
		
	<c:if test="${not empty allFlight }">
	
	<div class="container" style="width: 800px; height: 200px;">
		<table  class="table table table-hover table-striped ">
			<tbody>
				<tr>
					<td colspan="12"> <h4>${cityOtpr} <img alt="pl" src="resources/images/plane.png"> ${cityPrib}</h4></td>
				</tr>
				<tr>					
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
				<c:forEach items="${allFlight}" var="flight" >	
				<form name='deleteFlight' action="deleteFlight" method='GET'
							role="form" enctype="multipart/form-data">				
					<tr>											
							 									
									<td>												      
						     		 <c:if test="${flight.flightId.days.mon==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.mon==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.tue==true}"><img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.tue==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.wen==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.wen==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.thu==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.thu==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.fri==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.fri==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.sat==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.sat==false}"> </c:if>					      
									</td>
									<td>												      
						     		 <c:if test="${flight.flightId.days.sun==true}"> <img alt="pl" src="resources/images/plane.png"></c:if>	
						     		 <c:if test="${flight.flightId.days.sun==false}"> </c:if>					      
									</td>
										
							
								
						<td>${flight.flightId.timeArrivals}</td>
						<td>${flight.flightId.timeSortie}</td>
						<td>${flight.planeId.name}</td>
						<td>${flight.flightId.name}</td>
						<td>с: ${flight.flightId.dateBegin} <br> по:${flight.flightId.dateEnd}</td>
						
					
					</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
	</c:if>

</body></html>