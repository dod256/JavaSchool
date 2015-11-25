<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name = "LoginForm" action = "LoginServlet" method = post>
  <b>Login</b>
  <br>
  <input type="text" name="email" size="25" placeholder = "Email">
  <br>
  <input type="password" name="password" size="15" placeholder = "Password">
  <br>
  <input type="submit" value="Login">
</form>
