<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    if (request.getAttribute("msg")!=null)
    {
        out.println(request.getAttribute("msg"));
    }
%>
<form name="register" method="post" action="UserController">
    <table cellpadding="10px" cellspacing="10px">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="fname"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lname"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Mobile</td>
            <td><input type="text" name="mobile"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td> Confirm Password</td>
            <td><input type="password" name="cpassword"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="action" value="Register"></td>

    </table></form>
</body>
</html>
