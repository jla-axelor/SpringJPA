<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post" action="../login">
        User name : <input type="text" name="userName" />
        Password : <input type="password" name = "password">
                    <input type="submit" />
    </form>
    <br/>
    <br/>
    New user : <a href="../newRegister">Register</a>
</body>

</html>