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
@WebServlet(value = "/login")
public class UserLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		UserDao userdao=new UserDao();
		
		PrintWriter printWriter=resp.getWriter();
		ServletContext context=getServletContext();
		
		context.setAttribute("userdao", userdao);
		
		Users user=userdao.loginUser(email, password);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		if(user!=null) {
			HttpSession session=req.getSession();
			//if user logis in sucessfullu adding to httpsession
			session.setAttribute("loggedin_user", user);
			//if user is employee
			if(user.getRole().equals("Employee")) {
				resp.sendRedirect("employeelogin.jsp");
			}
			//if user is manager
			else if(user.getRole().equals("Manager")) {
				resp.sendRedirect("managerlogin.jsp");
			}
			
		}
		
		else {
			printWriter.print("<h1>Incorrect Email or Password</h1>");
			dispatcher.include(req, resp);
		}
	}
}	
