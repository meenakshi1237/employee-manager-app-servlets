<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- inline css for styles -->
<style type="text/css">
form {
	border: 2px solid black;
	margin-top: 130px;
	margin-left:450px;
	padding-top:50px;
	padding-bottom:50px;
	width: 30%;
	background-color: lime;
	}
	.newuser {
		margin-left: 400px;
		padding-top: 40px;
		color: red;
	}
	.email{
		padding-bottom: 50px;
	}
	.password{
		padding-bottom: 50px;
	}
	
	.enteremail{
		height: 20px;
		width: 180px;
	}
	.enterpassword{
		height: 20px;
		width: 180px;
	}
	.login{
		height: 40px;
		width: 300px;
		background-color:black;
		color: white;
	}
</style>
</head>
<body>
	<form action="login" method="post">
		<center>
			<div class="email">
				Email: <input type="email" name="user_email" class="enteremail">
			</div>
			<br>
			<div class="password">
				Password: <input type="password" name="user_password" class="enterpassword">
			</div>
			<br>
			<div class="submit">
				<br> <input type="submit" value="Login"  class="login">
			</div>
		</center>
	</form>
	<div class="newuser">
		<h4>New User</h4>
	<a href="registration.jsp">Register Here</a>
	</div>
</body>
</html>