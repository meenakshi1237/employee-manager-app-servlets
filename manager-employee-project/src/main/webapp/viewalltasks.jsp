<%@page import="com.dao.TaskDao"%>
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
		TaskDao taskdao=new TaskDao();
		List<Task> tasks=taskdao.getAllTasks();
		if(tasks!=null){
			for(Task task:tasks){
				
			
		
	%>
	<center>
		<h3>Task id:- <%=task.getId() %></h3>
		<h3>Description:- <%=task.getDescription() %></h3>
		<h3>Created DateTime:- <%=task.getCreateddatetime() %></h3>
		<h3>Completed DateTime:- <%=task.getCompletedatetime() %></h3>
		<h3>Status:- <%=task.getStatus() %></h3>
		<h3>---------------------------------------------------------------------------</h3>
	</center>
	<%
			}
		}
	%>
	<a href="logout.jsp"><button class="logout">Logout</button> </a>
</body>
</html>