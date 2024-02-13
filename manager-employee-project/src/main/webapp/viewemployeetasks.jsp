<%@page import="com.dao.UserDao"%>
<%@page import="com.entity.Users"%>
<%@page import="com.entity.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.selectstatus{
		background-color: aqua;
		color: black;
		height: 25px;
		width: 90px;
		border-radius: 7px;
	}
	.edit {
		background-color: white;
		color: black;
		height: 25px;
		width: 90px;
		border-radius: 7px;
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
		UserDao userdao=new UserDao();
		Users user=(Users)session.getAttribute("loggedin_user");
		List<Task> tasks=userdao.getEmployeeTasks(user);
		if(tasks!=null){
			for(Task task:tasks){
			
	%>
	<center>
		<h3>Task id:- <%=task.getId() %></h3>
	<h3>Description:- <%=task.getDescription() %></h3>
	<h3>Created DateTime:- <%=task.getCreateddatetime() %></h3>
	<h3>Completed DateTime:- <%=task.getCompletedatetime() %></h3>
	<h3>Status:- <%=task.getStatus() %></h3>
		
		<form action="changestatus" method="post">
			<select name="selectstatus" class="selectstatus">
				<option value="assigned"> <%="assigned"%> </option>
				<option value="completed"> <%="completed"%> </option>
			</select>
			
			<button name="taskId" value="<%=task.getId() %>" class="edit">Edit</button>
		</form>
		
	<h3>---------------------------------------------------------------------------</h3>
	</center>
	<%
		}
			}
		
	%>
	<center>
		<a href="logout.jsp" ><button class="logout">Logout</button> </a>
	</center>
</body>
</html>