<%
	session.removeAttribute("user");
	session.invalidate();
	request.getRequestDispatcher("login.jsp").forward(request, response);
%>