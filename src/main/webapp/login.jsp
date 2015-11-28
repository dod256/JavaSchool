<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Login</h1>
<form name = "LoginForm" action = "LoginServlet" method = post>
  <div class = "form-element">
    <label> Email: </label>
    <input type="text" name="email">
  </div>
  <div class = "form-element">
    <label> Password: </label>
    <input type="password" name="password">
  </div>
  <div class = "form-element">
    <input type="submit" value="Log in">
  </div>
</form>
