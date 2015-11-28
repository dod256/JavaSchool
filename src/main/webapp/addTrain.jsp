<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Add train</title>
    <link type="text/css" rel="stylesheet" href="Styles/styles.css" />

  </head>
  <body>
    <%@ include file = "/menu.jsp" %>
    <form name = "AddTrainForm" action = "AddTrainServlet" method = post>
      <div class = "form-element">
        <label> Departure date </label>
        <input type="date" name="date">
      </div>
      <div class = "form-element">
        <label> Number of seats </label>
        <input type="text" name="numberOfSeats">
      </div>
      <div class = "form-element">
        <label> Cost per ticket </label>
        <input type="text" name="cost">
      </div>
      <div class = "form-element">
        <input type="submit" value="Add">
      </div>
    </form>

  </body>
</html>
