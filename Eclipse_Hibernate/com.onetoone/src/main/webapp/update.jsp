<%@page import="com.bean.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<b style="color:blue;">
<%
	if(request.getAttribute("msg")!=null)
	{
		out.println(request.getAttribute("msg"));
	}
	Emp e=(Emp)request.getAttribute("e");
%>
</b>
<form name="frm" method="post" action="EmpController">
	<table cellpadding="5px" cellspacing="5px">
		<tr>
			<td><input type="hidden" name="eid" value="<%=e.getEid()%>">
			<td><input type="hidden" name="epid" value="<%=e.getEinfo().getEpid()%>">
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" value="<%=e.getEinfo().getFname()%>"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" value="<%=e.getEinfo().getLname()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%=e.getEinfo().getEmail()%>"></td>
		</tr>
		<tr>
			<td>Department</td>
			<td><input type="text" name="dept" value="<%=e.getDept()%>"></td>
		</tr>
		<tr>
			<td>Job</td>
			<td><input type="text" name="job" value="<%=e.getJob()%>"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Update" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>

</body>
</html>