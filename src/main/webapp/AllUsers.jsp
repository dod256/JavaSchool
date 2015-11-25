<%@ page import="main.Service" %>
<%@ page import="main.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>All Users</title>
</head>

<% request.setAttribute("userList", Service.getUsers()); %>

<table>
  <c:set var="userList" value="${userList}"/>
  <c:forEach items="${userList}" var="name">
    <tr>
      <td>${name.getFirstName()}</td>
      <td>${name.getLastName()}</td>
    </tr>
  </c:forEach>
</table>

</html>