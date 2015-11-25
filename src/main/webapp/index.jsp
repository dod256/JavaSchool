<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
    <%@ include file = "/login.jsp" %>
    <form name = "SignUpForm" action = "SignUp.html" method = get>
        <input type = "submit" value = "Sign Up">
    </form>
    </body>
</html>