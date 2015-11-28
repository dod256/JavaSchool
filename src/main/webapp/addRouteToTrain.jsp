<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Add route to train</title>
    <link type="text/css" rel="stylesheet" href="Styles/styles.css" />
  </head>
  <body>
  <%@ include file = "/menu.jsp" %>
  <br>
  <form name = "ShowRoutesForm" action = "ShowRoutesServlet" method = post>
    <div class = "form-element">
      <label> Departure Station </label>
      <input type="text" name="departureStation">
    </div>
    <div class = "form-element">
      <label> Arrival Station </label>
      <input type="text" name="departureStation">
    </div>
    <div class = "form-element">
      <label> Time </label>
      <input type="time" name="time">
    </div>
    <div class = "form-element">
      <input type="submit" value="Find">
    </div>
  </form>

  <table>
    <tr>
      <td>Train Name</td>
      <td>Departure Station</td>
      <td>Arrival Station</td>
      <td>Departure Date</td>
      <td>Arrival Date</td>
    </tr>
    <c:set var="trainList" value="${sessionScope.trainList}"/>
    <c:forEach items="${trainList}" var="train">
      <tr>
        <td>${train.getName()}</td>
        <td>${train.getDepartureStation()}</td>
        <td>${train.getArrivalStation()}</td>
        <td>${train.getDepartureTime()}</td>
        <td>${train.getArrivalTime()}</td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
