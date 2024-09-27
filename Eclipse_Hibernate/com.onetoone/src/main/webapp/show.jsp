<%@page import="com.doa.EmpDao"%>
<%@page import="com.bean.Emp"%>
<%@page import="java.util.List"%>
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
<%
	List<Emp> list=EmpDao.getAllEmp();
			
%>
<table border="5" width="100%" cellpadding="10px" cellspacing="10px">
	<tr>
		<th>EPID</th>
		<th>FIRST NAME</th>
		<th>LAST NAME</th>
		<th>EMAIL</th>
		<th>EID</th>
		<th>DEPARTMENT</th>
		<th>JOB</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	<%
		for(Emp e:list)
		{
	%>
	<tr>
		<td><%=e.getEinfo().getEpid() %></td>
		<td><%=e.getEinfo().getFname()%></td>
		<td><%=e.getEinfo().getLname()%></td>
		<td><%=e.getEinfo().getEmail()%></td>
		<td><%=e.getEid() %></td>
		<td><%=e.getDept()%></td>
		<td><%=e.getJob()%></td>
		<td>
			<form name="edit" method="post" action="EmpController">
				<input type="hidden" name="eid" value="<%=e.getEid()%>">
				<input type="submit" name="action" value="EDIT" class="btn btn-primary">
			</form>
		</td>
		<td>
			<form name="delete" method="post" action="EmpController">
				<input type="hidden" name="eid" value="<%=e.getEid()%>">
				<input type="submit" name="action" value="DELETE" class="btn btn-danger">
			</form>
		</td>
	</tr>
	<%
		}
	%>
</table>
<a href="insert.jsp">Add New Student</a>
</body>
</html>