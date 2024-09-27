package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.User;
import com.dao.UserDao;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");

        if (action.equalsIgnoreCase("register")) {
            boolean flag=UserDao.checkEmail(request.getParameter("email"));
            if(flag==false) {
                if(request.getParameter("password").equalsIgnoreCase(request.getParameter("cpassword"))) {
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
                    request.setAttribute("msg", "Password&Cpassword Doesnt Match");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
            else {
                request.setAttribute("msg", "Email is already registered");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }

}
