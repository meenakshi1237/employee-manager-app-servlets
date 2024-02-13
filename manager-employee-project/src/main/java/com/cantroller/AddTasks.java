package com.cantroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TaskDao;
import com.entity.Task;
import com.helper.CreateTask;
@WebServlet(value = "/addtasks")
public class AddTasks extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String description=req.getParameter("task_description");
		String status=req.getParameter("task_status");
		String employeeid=req.getParameter("dropdown");
		int empid=Integer.parseInt(employeeid);
	
		PrintWriter printwriter=resp.getWriter();
//		printwriter.print("<h1>status</h1>");
		TaskDao taskdao=new TaskDao();
		Task task=CreateTask.createTask(description, status);
		if(task!=null) {
			Task addedtask= taskdao.addTask(task,empid);
			if(addedtask!=null) {
				printwriter.print("<h1>Task added sucessfully</h1>");
				
				printwriter.print("<a href=\"logout.jsp\"><button>Logout</button> </a>");
			}
		}
	}
}
