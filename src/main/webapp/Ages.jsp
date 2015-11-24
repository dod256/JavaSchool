<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ages</title>
</head>

<h2>New User</h2>
<br>
<form action="AddServlet" method=post>
    <input type="text" name="name" size="25" placeholder = "name">
    <br>
    <input type="text" name="age" size="15" placeholder = "age">
    <br>
    <input type="submit" value="Add">
</form>

<table>
    <c:forEach var = "person" items = "@{personList}" >
        <tr>
            <td>${person.getName()}</td>
            <td>${person.getAge()}</td>
        </tr>
    </c:forEach>
</table>

</html>