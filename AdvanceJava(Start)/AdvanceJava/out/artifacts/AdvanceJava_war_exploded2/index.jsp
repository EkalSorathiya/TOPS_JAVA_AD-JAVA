<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript">
        

    </script>
</head>
<body>
<form name="frm" method="post" action="">
    <table cellpadding="5px" cellspacing="5px">
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
            <td>Hobby</td>
            <td>
                <input type="checkbox" name="hobby" value="music">Music<br>
                <input type="checkbox" name="hobby" value="dance">Dance<br>
                <input type="checkbox" name="hobby" value="traviling">Traviling<br>
                <input type="checkbox" name="hobby" value="cricket">Cricket<br>
            </td>
        </tr>
        <tr>
            <td>Birth Date</td>
            <td><input type="date" name="birthdate"></td>
        </tr>
        <tr>
            <td>Education</td>
            <td><select name="education">
                <option >----Select Education----</option>
                <option value="10th">10th</option>
                <option value="12th">12th</option>
                <option value="BCA">BCA</option>
                <option value="BBA">BBA</option>
                <option value="BE">BE</option>
                <option value="MCA">MCA</option>
                <option value="ME">ME</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Resume</td>
            <td><input type="file" name="resume"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="cpassword"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="action" value="Register">
            </td>

        </tr>
    </table>
</form>
</body>
</html>
