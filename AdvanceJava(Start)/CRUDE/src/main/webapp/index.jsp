<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>
<b style ="color:blue;">

</b>
<form name="frm" method="post" action="StudentController">
    <table>
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
            <td>Address</td>
            <td><textarea rows="5" cols="21" name="address"></textarea> </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value="male">Male
                <input type="radio" name="gender" value="female">Female
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="action" value="Insert" class="btn btn-primary">
            </td>
        </tr>
    </table>
</form>
<a href="show.jsp">Show All Student</a>
</body>
</html>