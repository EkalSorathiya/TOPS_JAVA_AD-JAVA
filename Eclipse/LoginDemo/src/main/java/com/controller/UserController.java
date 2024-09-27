package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("register"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==false)
			{
				if(request.getParameter("password").equalsIgnoreCase(request.getParameter("cpassword")))
				{
					User u=new User();
					u.setFname(request.getParameter("fname"));
					u.setLname(request.getParameter("lname"));
					u.setEmail(request.getParameter("email"));
					u.setMobile(Long.parseLong(request.getParameter("mobile")));
					u.setPassword(request.getParameter("password"));
					UserDao.registerUser(u);
					response.sendRedirect("login.jsp");
				}
				else
				{
					request.setAttribute("msg", "Password And Confirm Password Does Not Matched");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Email Alread Register");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			User u=UserDao.login(request.getParameter("email"));
			if(u!=null)
			{
				if(u.getPassword().equals(request.getParameter("Password")))
				{
					HttpSession session=request.getSession();
					session.setAttribute("u", u);
					request.getRequestDispatcher("home.jsp").forward(request, response);;
					
				}
				else
				{
					request.setAttribute("msg", "Incorrect Password");
					request.getRequestDispatcher("login.jsp");
				}
			}
			else
			{
				request.setAttribute("msg", "Email Not Register");
				request.getRequestDispatcher("register.jsp");
			}
		}
		
	}

}
