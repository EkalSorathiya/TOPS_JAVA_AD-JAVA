<%@page import="com.dao.ProductDao"%>
<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Product"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=Integer.parseInt(request.getParameter("uid"));
	Cart c=new Cart();
	c.setPid(pid);
	c.setUid(uid);
	Product p=ProductDao.getProduct(pid);
	int product_price=p.getProduct_price();
	c.setProduct_price(product_price);
	c.setProduct_qty(1);
	c.setTotal_price(p.getProduct_price());
	CartDao.addToCart(c);
	List<Cart> list=CartDao.getCartByUser(uid);
	session.setAttribute("cart_count",list.size());
	//request.setAttribute("msg", "Product Added To Cart Successfully");
	//request.getRequestDispatcher("cart.jsp").forward(request, response);
	response.sendRedirect("cart.jsp");
%>