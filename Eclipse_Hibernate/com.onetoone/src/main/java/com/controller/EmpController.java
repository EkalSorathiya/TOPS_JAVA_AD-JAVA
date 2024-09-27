package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.bean.EmpInfo;
import com.doa.EmpDao;

@WebServlet("/EmpController")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			EmpInfo einfo=new EmpInfo();
			einfo.setFname(request.getParameter("fname"));
			einfo.setLname(request.getParameter("lname"));
			einfo.setEmail(request.getParameter("email"));
			
			
			EmpDao.insertEmpInfo(einfo);
			
			Emp e=new Emp();
			e.setDept(request.getParameter("dept"));
			e.setJob(request.getParameter("job"));
			e.setEinfo(einfo);
			EmpDao.insertEmp(e);
			response.sendRedirect("show.jsp");
			
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			Emp e=EmpDao.getEmp(eid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);;
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			EmpInfo einfo=new EmpInfo();
			einfo.setEpid(Integer.parseInt(request.getParameter("epid")));
			einfo.setFname(request.getParameter("fname"));
			einfo.setLname(request.getParameter("lname"));
			einfo.setEmail(request.getParameter("email"));
			
			Emp e=new Emp();
			e.setEid(Integer.parseInt(request.getParameter("eid")));
			e.setDept(request.getParameter("dept"));
			e.setJob(request.getParameter("job"));
			e.setEinfo(einfo);
			EmpDao.insertEmp(e);
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));	
			EmpDao.deleteEmp(eid);
			response.sendRedirect("show.jsp");
		}
	}

}
