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
<title>Добавление экипажа</title>
</head>
<body>

	<%@ include file="head.jsp"%>
	<br />
	
	<div class="container" style="width: 400px; height: 550px;">

		<h2 class="form-signin-heading font-text" style="text-align: center;">Добавление экипажа</h2>
		<hr/>
		<form name='addCrew' action="add_crew" method='GET'
			role="form" enctype="multipart/form-data">
			
			<table class="table" >
			<tr>
					<c:if test="${not empty error }">
			<i>${error }</i>
		</c:if>
		<c:if test="${not empty success }">
			<i>${success }</i>
		</c:if>
				
					<div class="form-group">
						<label >Номер экипажа:</label> <input class="form-control" type='number'
						name='number' placeholder="Номер экипажа">
					</div>
			
				
			</tr>
			<tr>
				<td>
				<h4 class="form-signin-heading font-text" style="text-align: center;">Пилот 1</h4>	
			
				 <div class="form-group">
					<label>Фамилия :</label>  <input class="form-control" type="text"
						name='secondname1' placeholder="Фамилия" required/>
						</div>
				 <div class="form-group">
					<label>Имя :</label>  <input class="form-control" type="text"
						name='firstname1' placeholder="Имя" required/>
						</div>
				<div class="form-group">
					<label>Отчество :</label> <input class="form-control" type="text"
						name='middlename1' placeholder="Отчество" required/>
				</div>	
				<div class="form-group">
					<label>Дата рождения:</label><input type="date"
						class="form-control" name="date1" value="2010-01-01"/>
				</div>	
				</td>
				<td>
				<h4 class="form-signin-heading font-text" style="text-align: center;">Пилот 2</h4>	
			
				 <div class="form-group">
					<label>Фамилия :</label>  <input class="form-control" type="text"
						name='secondname2' placeholder="Фамилия" />
						</div>
				 <div class="form-group">
					<label>Имя :</label>  <input class="form-control" type="text"
						name='firstname2' placeholder="Имя" />
						</div>
				<div class="form-group">
					<label>Отчество :</label>  <input class="form-control" type="text"
						name='middlename2' placeholder="Отчество" />
				</div>	
				<div class="form-group">
					<label>Дата рождения:</label><input type="date"
						class="form-control" name="date2" value="2010-01-01"/>
				</div>	
				</td>		
			</tr>					
					
				</table>
				<hr/>
					<input class="btn btn-lg btn-default btn-block " name="submit"
							type="submit" value="Добавить" />
		</form>

	</div>
	

</body>
</html>