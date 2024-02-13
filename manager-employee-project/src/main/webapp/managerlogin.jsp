<%@page import="com.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
		border-radius: 10px;
	}
	.addtask{
		height: 50px;
		width: 200px;
		background-color: olive;
		color: white;
		border-radius: 10px;
	}
	.logout{
		height: 50px;
		width: 200px;
		background-color: olive;
		color: white;
		border-radius: 10px;
	}
</style>
</head>
<body>
	<%
		Users user = (Users) session.getAttribute("loggedin_user");
	%>
	<center>
		<h1 class="hello">HEllo <%=user.getName()%></h1>
		<a href="viewalltasks.jsp"> <button class="viewtasks">Tasks</button> </a>
		<br>
		<br>
	 	<a href="addtask.jsp"> <button class="addtask">Add Task</button> </a>
		<br>
		<br>
		<a href="logout.jsp"><button class="logout">Logout</button> </a>
		</center>
</body>
</html>