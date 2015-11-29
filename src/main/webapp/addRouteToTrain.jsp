<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Add route to train</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha256-KXn5puMvxCw+dAYznun+drMdG1IFl3agK0p/pqT9KAo= sha512-2e8qq0ETcfWRI4HJBzQiA3UoyFk6tbNyG+qSaIBZLyW9Xf3sWZHN/lxe9fTh1U45DpPf07yj94KsUHHWe4Yk1A==" crossorigin="anonymous"></script>    </head>
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
      <input type="text" name="arrivalStation">
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

  <form name = "ShowAllRoutesForm" action = "ShowAllRoutesServlet" method = post>
    <div class = "form-element">
      <input type="submit" value="Show all routes">
    </div>
  </form>


  <div class="container">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Routes</th>
      </tr>
      </thead>
      <tbody>
        <c:set var="routeList" value="${sessionScope.routeList}"/>
        <c:forEach items="${routeList}" var="route">
          <tr>
            <td>
              <form name = "AddRouteForm" action = "AddRouteToTrainServlet" method = post>
                <div class = "form-element">
                  <input type="hidden" name = "routeId" value = ${route.getRouteId()}>
                </div>
                <div class = "form-element">
                  <input type="submit" value="Add">
                </div>
              </form>
            </td>
            <c:set var="stationList" value="${route.getStations()}"/>
            <c:forEach items="${stationList}" var="station">
              <td>${station.getName()}</td>
            </c:forEach>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  </body>
</html>
