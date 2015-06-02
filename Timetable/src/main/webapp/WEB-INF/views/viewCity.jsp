<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<title>Города</title>
</head>
<body>
<%@ include file="head.jsp"%>

<table  align="center">
	<tr >
		<td  align="center">						
				<ul class="nav nav-pills ">
					<li > <a href="viewPlanes"><h3>Самолёты</h3></a> </li>
					<li > <a href="viewCity"><h3>Города</h3></a> </li>
					<li > <a href="viewCrew"><h3>Экипажи</h3></a> </li>
				</ul>	
		</tr>	
</table>
	<hr/>
	<center>
		<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
	</center>
		<form name='deleteCity' action="deleteCity" method='GET'
				role="form" enctype="multipart/form-data">
				<div class="container" style="width: 20%"> 
			<table  class="table table table-hover table-striped " >
				<tr>
						<td width="5"></td><td align="center">Название</td>
					</tr>
				<c:forEach items="${citys}" var="city">				
					<tr>
						<td width="5"><input type="checkbox" name="cityid" value="${city.idcity}" ></td><td align="center">${city.name}</td> 
					</tr>
				</c:forEach>				
			</table>
			<br>
			
			<ul class="nav nav-pills"> 								
  				<li><input class="btn" name="submit" type="submit" value="Удалить"/></li>  
  				<li><a href="addCity">Добавить</a></li> 				
			</ul>					
		</div>
		</form>		

</body>
</html>