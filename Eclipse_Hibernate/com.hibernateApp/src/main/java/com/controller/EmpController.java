package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.dao.EmpDao;
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			Emp e=new Emp();
			e.setFname(request.getParameter("fname"));
			e.setLname(request.getParameter("lname"));
			e.setEmail(request.getParameter("email"));
			e.setMobile(request.getParameter("mobile"));
			e.setAddress(request.getParameter("address"));
			e.setGender(request.getParameter("gender"));
			EmpDao.insertEmp(e);
			response.sendRedirect("show.jsp");	
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			Emp e=EmpDao.getEmp(eid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);			
		}
		else if(action.equalsIgnoreCase("update"))
		{
			Emp e=new Emp();
			e.setEid(Integer.parseInt(request.getParameter("eid")));
			e.setFname(request.getParameter("fname"));
			e.setLname(request.getParameter("lname"));
			e.setEmail(request.getParameter("email"));
			e.setMobile(request.getParameter("mobile"));
			e.setAddress(request.getParameter("address"));
			e.setGender(request.getParameter("gender"));
			EmpDao.insertEmp(e);
			response.sendRedirect("show.jsp");
				
		}
		else if (action.equalsIgnoreCase("delete"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			EmpDao.deleteEmp(eid);
			response.sendRedirect("show.jsp");
		}		
	}
}
