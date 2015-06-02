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
	<script async="" type="text/javascript" src="http://yandex.st/jquery/2.0.3/jquery.js"></script>

	
<title>Insert title here</title>
<style>
   <%@include file='css.css' %>

</style>
</head>
<body>
<table border="0" align="center" cellpadding="0" cellspacing="0" class="layout">
  <tr>
    <td align="center" valign="top"><table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top"><table width="780" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="281" height="70" align="left" valign="top"><a href="index"><img src="resources/images/index_01.gif" alt="we" width="281" height="70" border="0" /></a></td>
            <td align="right" valign="bottom" style="padding-bottom:15px; padding-right:20px;"><table border="0" cellspacing="0" cellpadding="0">
              <tr>
                
                
                <td width="50" align="left" valign="middle" class="header"><a href="admin">Администратор</a></td>
                <td width="15" align="left" valign="middle"></td>
                <td width="70" align="left" valign="middle" class="header"><a href="dispatcher">Диспетчер</a></td>

                <td width="17" align="left" valign="middle"></td>
                <% if (session.getAttribute("authorized") != null && !session.getAttribute("authorized").equals("false")){%>
                <td width="150" class="header" align="center"> Здравствуйте, <%if  (session.getAttribute("authorized").equals("admin")){%>admin<%} %> 
                <%if  (session.getAttribute("authorized").equals("dispatcher")){%>dispatcher<%} %>
                </td>
                 <td width="17" align="left" valign="middle"></td>
               	<td width="40" class="header"> <a href = "logout"  >Выйти</a></td>
               	<%} %>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="left" valign="top" style="border-top:#2895DB solid 4px; border-bottom:#2895DB solid 4px;"><table width="780" border="0" cellspacing="0" cellpadding="0" style="border-top:#FFFFFF solid 1px; border-bottom:#FFFFFF solid 2px;">
          <tr>
            <td width="281" height="190" align="left" valign="top"><img src="resources/images/index_16.gif" alt="" width="281" height="190" /></td>
            <td width="264" align="left" valign="top"><img src="resources/images/index_17.gif" alt="" width="264" height="190" /></td>
            <td width="235" align="left" valign="middle" bgcolor="#767F89" style="border-left:#FFFFFF solid 1px;">


			</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  </table>
</body>
</html>