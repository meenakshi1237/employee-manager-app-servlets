<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form {
		border: 2px solid black;
		margin-top: 40px;
		margin-left:450px;
		padding-top:50px;
		padding-bottom:50px;
		width: 30%;
		background-color: lime;
	}
	.existinguser {
		margin-left: 400px;
		padding-top: 10px;
		color: red;
	}
</style>
</head>
<body>
<h1>Welcome to TestYantra Software Solutions</h1>
	<form action="registration" method="post">
		<div>
		Name: <input type="text" name="user_name">
		</div>
		<br>
		<br>
		<div>
		Email: <input type="email" name="user_email">
		</div>
		<br>
		<br>
		<div>
		Password: <input type="password" name="user_password">
		</div>
		<br>
		<br>
		<div>
		Role: <label for="dropdown">Select the Role</label>
		<select id="dropdown" name="dropdown">
			<option value="Employee"> Employee</option>
			<option value="Manager">Manager</option>
		</select>
		</div>
		<br>
		<br>
		<div>
		Designation: <input type="text" name="user_designation">
		</div>
		<br>
		<br>
		<div>
		Salary: <input type="text" name="user_salary">
		</div>
		<br>
		<br>
		<div>
		<input type="submit" value="Register">
		</div>
	</form>
	<h4 class="existinguser">Existing User? </h4><a href="login.jsp" class="existinguser">Login</a>	
</body>
</html>