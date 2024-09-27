package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.bean.Cart;
import com.bean.User;
import com.bean.Wishlist;
import com.dao.CartDao;
import com.dao.UserDao;
import com.dao.WishlistDao;
import com.service.Services;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("sign up"))
		{
			Boolean flagBoolean=UserDao.checkEmail(request.getParameter("email"));
			if(flagBoolean==false)
			{
				if(request.getParameter("password").equals(request.getParameter("cpassword")))
				{
					User user=new User();
					user.setUsertype(request.getParameter("usertype"));
					user.setFname(request.getParameter("fname"));
					user.setLname(request.getParameter("lname"));
					user.setEmail(request.getParameter("email"));
					user.setMobile(request.getParameter("mobile"));
					user.setAddress(request.getParameter("address"));
					user.setPassword(request.getParameter("password"));
					UserDao.signupUser(user);
					response.sendRedirect("login.jsp");
				}
				else 
				{
					request.setAttribute("msg", "Password & Confirm Password Does Not Matched");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email Already Registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			User user=UserDao.login(request.getParameter("email"));
			if(user!=null)
			{
				if(user.getPassword().equals(request.getParameter("password")))
				{
					if(user.getUsertype().equals("buyer"))
					{
						HttpSession session=request.getSession();
						session.setAttribute("user", user);
						List<Wishlist> list=WishlistDao.getWishlistByUser(user.getUid());
						session.setAttribute("wishlist_count", list.size());
						List<Cart> list1=CartDao.getCartByUser(user.getUid());
						session.setAttribute("cart_count", list1.size());
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else
					{
						HttpSession session=request.getSession();
						session.setAttribute("user", user);
						request.getRequestDispatcher("seller-index.jsp").forward(request, response);
					}
				}
				else 
				{
					request.setAttribute("msg","Incorrect Password");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg","Email Not Registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("change password"))
		{
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("user");
			if(user.getPassword().equals(request.getParameter("old_password")))
			{
				if(request.getParameter("new_password").equals(request.getParameter("cnew_password")))
				{
					if(!request.getParameter("old_password").equals(request.getParameter("new_password")))
					{
						UserDao.changePassword(user.getEmail(), request.getParameter("new_password"));
						response.sendRedirect("logout.jsp");
					}
					else
					{
						if(user.getUsertype().equals("buyer"))
						{
							request.setAttribute("msg", "Old Pasword & New Password Must Be Different");
							request.getRequestDispatcher("change-password.jsp").forward(request, response);
						}
						else 
						{
							request.setAttribute("msg", "Old Pasword & New Password Must Be Different");
							request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
						}
					}
				}
				else
				{
					if(user.getUsertype().equals("buyer"))
					{
						request.setAttribute("msg", "New Pasword & Confirm New Password Does Not Matched");
						request.getRequestDispatcher("change-password.jsp").forward(request, response);
					}
					else
					{
						request.setAttribute("msg", "New Pasword & Confirm New Password Does Not Matched");
						request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
					}
				}
			}
			else 
			{
				if(user.getUsertype().equals("buyer"))
				{
					request.setAttribute("msg", "Old Password Does Not Matched");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
				else 
				{
					request.setAttribute("msg", "Old Password Does Not Matched");
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
				}
			}
		}
		else if(action.equalsIgnoreCase("send otp"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==true)
			{
				Random t = new Random();
		    	int minRange = 1000, maxRange= 9999;
	        	int otp = t.nextInt(maxRange - minRange) + minRange;
	        	Services.sendMail(request.getParameter("email"), otp);
	        	request.setAttribute("email", request.getParameter("email"));
	        	request.setAttribute("otp", otp);
	        	request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Email Not Registered");
				request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify otp"))
		{
			int otp=Integer.parseInt(request.getParameter("otp"));
			int uotp=Integer.parseInt(request.getParameter("uotp"));
			String email=request.getParameter("email");
			if(otp==uotp)
			{
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Invalid OTP");
				request.setAttribute("otp", otp);
				request.setAttribute("email", email);
				request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update password"))
		{
			String email=request.getParameter("email");
			String np=request.getParameter("new_password");
			String cnp=request.getParameter("cnew_password");
			
			if(np.equals(cnp))
			{
				UserDao.changePassword(email, np);
				request.setAttribute("msg", "Password Updated Successfully");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Password & Confirm Password Does Not Matched");
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
	}

}
