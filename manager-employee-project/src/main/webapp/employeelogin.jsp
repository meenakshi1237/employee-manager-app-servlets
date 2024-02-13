<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.hello{
		background-color: black;
		color: white;
		font-size: 40px;
		padding-left: 20px;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	.viewtasks{
		height: 50px;
		width: 200px;
		background-color: olive;
		color: white;
	}
	.logout{
		height: 50px;
		width: 200px;
		background-color: olive;
		color: white;
	}
</style>
<body>
	<%
		Users user=(Users)session.getAttribute("loggedin_user");
	%>
	<center>
		<h1 class="hello">Hello <%=user.getName()%></h1>
	
		<a href="viewemployeetasks.jsp"> <button class="viewtasks">View Taks</button></a>
		<br>
		<br>
		<a href="logout.jsp"><button class="logout">Logout</button></a>
	</center>
</body>
</html>