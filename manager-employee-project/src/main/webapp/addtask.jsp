<%@page import="com.dao.UserDao"%>
<%@page import="com.entity.Users"%>
<%@page import="java.util.List"%>
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
	margin-top: 130px;
	margin-left:450px;
	padding-top:50px;
	padding-bottom:50px;
	width: 30%;
	background-color: lime;
	}
	.submit{
		margin-top:20px;
		height:30px;
		width:100px;
		margin-left: 150px;
		
	}
</style>
</head>
<body>
	<%
	UserDao userdao = new UserDao();
	List<Users> users = userdao.getAllUsers();
	%>
	
		<form action="addtasks" method="post">
		
		Status: <input type="text" name="task_status" value="assigned" >
		<br>
		<br>
		Assign To: <label for="dropdown"></label>
		 <select id="dropdown" name="dropdown">
			<%
				if(users!=null && users.size()>0){
					for(Users user:users){
						
			%>
			<option value="<%= user.getId()%>"><%=user.getId() %></option>
			<%
					}
				}
			%>
		</select> 
		<br>
		<br>
		
		Description:
		<textarea rows="3" cols="30" name="task_description"></textarea>
		<br>
		<br>
		<input type="submit" name="AddTask" class="submit">
	</form>
	
</body>
</html>