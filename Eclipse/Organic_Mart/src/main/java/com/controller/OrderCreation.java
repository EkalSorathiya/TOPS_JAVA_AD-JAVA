package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.json.*;

import com.bean.User;
import com.razorpay.*;


@WebServlet("/OrderCreation")
public class OrderCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		RazorpayClient client=null;
		String orderId=null;
		System.out.println(request.getParameter("amount"));
		try {
			client=new RazorpayClient("rzp_test_x6KVzM3liiKyT0","tktUaTAtZpHHyZE0aAagqLGK");
			JSONObject options=new JSONObject();
			options.put("amount", request.getParameter("amount"));
			options.put("currency", "INR");
			options.put("receipt", "zxr456");
			options.put("payment_capture", true);
			Order order=client.Orders.create(options);
			orderId=order.get("id");
			System.out.println(orderId);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		response.getWriter().append(orderId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		RazorpayClient client=null;
		try {
			client=new RazorpayClient("rzp_test_ejSarP32ojRW7k","v5upzJ2CYoy4PAx23jPBfxR7");
			JSONObject options=new JSONObject();
			options.put("razorpay_payment_id",request.getParameter("razorpay_payment_id"));
			options.put("razorpay_order_id",request.getParameter("razorpay_order_id"));
			options.put("razorpay_signature",request.getParameter("razorpay_signature"));
			boolean SigRes=Utils.verifyPaymentSignature(options,"Secret");
			if(SigRes)
			{
				javax.servlet.http.HttpSession session=request.getSession();
				User u=(User) session.getAttribute("u");
				System.out.println(u.getFname());
				response.getWriter().append("Payment Successfull");
			}
			else
			{
				response.getWriter().append("Payment Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
 