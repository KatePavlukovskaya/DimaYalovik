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
<title>Диспетчер</title>
</head>
<body>
<%@ include file="head.jsp"%>

	<div class="container" style="width: 400px; height: 550px;">

				<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
		<h2 class="form-signin-heading font-text" style="text-align: center;">Добавление рейса</h2>
		<hr/>
		<form action='addData' name="addData" method = 'GET' role="form" enctype="multipart/form-data">
			<div class="form-group">
				<label>Номер :</label> <input class="form-control" type='number'
					name='name' placeholder="Номер рейса">
			</div>
			 <div class="form-group">
				<label>Самолёт :</label> <select class="form-control" name = "plane">
					<c:forEach items="${allPlane}" var="plane">
						<option value="${plane.idplane}">${plane.name}</option>
					</c:forEach>				
				</select>
				</div>
				<div  class="form-group"> 
				<label> Экипаж : </label><select class="form-control" name = "crew">
					<c:forEach items="${allCrew}" var="crew">
						<option value="${crew.idcrew}">${crew.number} ${crew.pilot1.secondname} ${crew.pilot2.secondname}</option>
					</c:forEach>				
				</select>
				  </div>
				<div class="form-group">
					<label>Откуда :</label> <select class="form-control" name = "cityOtpr">
					<c:forEach items="${allCity}" var="city">
						<option value="${city.idcity}">${city.name}</option>
					</c:forEach>				
				</select>
				</div>
				<div class="form-group">
					<label>Куда :</label> <select class="form-control" name = "cityPrib">
					<c:forEach items="${allCity}" var="city">
						<option value="${city.idcity}">${city.name}</option>
					</c:forEach>				
				</select>
				</div>
				<div class="form-group">
				<label>Дни вылета:</label> 
					<label class="form-control">
 						 <input type="checkbox" name="Checkbox" value="1"/> пн						
 						 <input type="checkbox" name="Checkbox" value="2"/> вт			
 						 <input type="checkbox" name="Checkbox" value="3"/> ср				
 						 <input type="checkbox" name="Checkbox" value="4"/> чт				
 						 <input type="checkbox" name="Checkbox" value="5"/> пт				
 						 <input type="checkbox" name="Checkbox" value="6"/> сб				
 						 <input type="checkbox" name="Checkbox" value="7"/> вс
				</label>
				</div>
				
				<div class="form-group">
					<label> Время вылета:</label> <input class="form-control"  type="time" name="time1" value="12:00"/>					
				</div>
				<div class="form-group">
					<label> Время прилёта:</label> <input class="form-control"  type="time" name="time2" value="13:00"/>					
				</div>
				<div class="form-group">
					<label> Начало периода:</label> <input class="form-control"  type="date" name="date1" value="2010-01-01"/>					
				</div>
				<div class="form-group">
					<label> Конец периода:</label> <input class="form-control"  type="date" name="date2" value="2010-01-02"/>					
				</div>
				
				
				
				
			<input class="btn btn-lg btn-default btn-block " name="submit"
				type="submit" value="Добавить" />
			</form>

	</div>


	
</body>
</html>					
