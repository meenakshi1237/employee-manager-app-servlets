package com.cantroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TaskDao;
import com.entity.Task;
@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String statusId=req.getParameter("taskId");
		String changedStatus=req.getParameter("selectstatus");
		
		int statusid=Integer.parseInt(statusId);
		
		TaskDao taskdao=new TaskDao();
		Task task=taskdao.changeStatus(statusid, changedStatus);
		
		resp.sendRedirect("viewemployeetasks.jsp");
	}
}
