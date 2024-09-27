<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Wishlist"%>
<%@page import="com.dao.WishlistDao"%>
<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=Integer.parseInt(request.getParameter("uid"));
	Cart w=new Cart();
	w.setPid(pid);
	w.setUid(uid);
	CartDao.removeFromCart(w);
	List<Cart> list=CartDao.getCartByUser(uid);
	session.setAttribute("cart_count", list.size());
	request.setAttribute("msg", "Product Deleted From Cart Successfully");
	request.getRequestDispatcher("cart.jsp").forward(request, response);
%>