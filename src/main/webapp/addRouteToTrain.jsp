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
      <label>Departure time range</label>
      <input type="time" name="firstTime">
      <input type="time" name="secondTime">
    </div>
    <div class = "form-element">
      <input type="submit" value="Find">
    </div>
  </form>

  <table>
    <c:set var="routesList" value="${sessionScope.routesList}"/>
    <c:forEach items="${routesList}" var="route">
      <tr>
        <c:set var="stationsList" value="${route.getStations()}"/>
        <c:forEach items="${stationsList}" var="station">
          <td>${station.GetName()}</td>
        </c:forEach>
        <td>
          <form name = "AddRouteForm" action = "AddRouteToTrainServlet" method = post>
            <div class = "form-element">
              <input type="hidden" name = "routeId" value = ${route.getId()}>
            </div>
            <div class = "form-element">
              <input type="submit" value="Add">
            </div>
          </form>

        </td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
