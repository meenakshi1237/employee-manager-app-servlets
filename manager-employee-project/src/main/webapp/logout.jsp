<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.login{
		height: 40px;
		width: 300px;
		background-color:black;
		color: white;
		font-size: 15px;
	}
</style>
</head>
<body>
	<%
		session.invalidate();
	%>
	<h1>LoggedOut Sucessfully</h1>
	<br>
	<br>
	<a href="login.jsp"><button class="login">LogIn</button> </a>
</body>
</html>