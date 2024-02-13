package com.cantroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.Users;
import com.helper.CreateUser;
@WebServlet(value = "/registration")
public class UserRegistration extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("user_name");
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		String role=req.getParameter("dropdown");
		String designation=req.getParameter("user_designation");
		String salary=req.getParameter("user_salary");
		double usersalary=Double.parseDouble(salary);
		//printwriter
		PrintWriter printwriter=resp.getWriter();
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		Users user=CreateUser.createUser(name, email, password, role, designation, usersalary);
		UserDao userdao=new UserDao();
		if(user!=null) {
			Users saveduser=userdao.saveUser(user);
			ServletContext context=getServletContext();
			context.setAttribute("userdao", userdao);
			if(saveduser!=null) {
				printwriter.print("<h1>User Saved Sucessfully</h1>");
				dispatcher.include(req, resp);
			}
			else {
				printwriter.print("<h1>Something went wrong please try again</h1>");
				resp.sendRedirect("registration.jsp");
			}
		}
	}
}
