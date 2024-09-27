<%--
  Created by IntelliJ IDEA.
  User: IPSS
  Date: 13-Mar-23
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Student"%>
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
    List<Student> list=StudentDao.getAllStudent();
%>
<table border="5" width="100%" cellpadding="10px" cellspacing="10px">
    <tr>
        <th>ID</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>EMAIL</th>
        <th>MOBILE</th>
        <th>ADDRESS</th>
        <th>GENDER</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <%
        for(Student s:list)
        {
    %>
    <tr>
        <td><%=s.getId() %></td>
        <td><%=s.getFname() %></td>
        <td><%=s.getLname() %></td>
        <td><%=s.getEmail() %></td>
        <td><%=s.getMobile() %></td>
        <td><%=s.getAddress() %></td>
        <td><%=s.getGender() %></td>
        <td>
            <form name="edit" method="post" action="StudentController">
                <input type="hidden" name="id" value="<%=s.getId()%>">
                <input type="submit" name="action" value="EDIT" class="btn btn-primary">
            </form>
        </td>
        <td>
            <form name="delete" method="post" action="StudentController">
                <input type="hidden" name="id" value="<%=s.getId()%>">
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
