<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
  <%@ include file = "/style.jsp" %>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>
    </div>
    <div class="col-sm-10 text-left">

      <form for = "form" name = "ShowRoutesForm" action = "ShowRoutesServlet" method = post>
        <div class = "form-group">
          <label for = "departureStation"> Departure Station </label>
          <input type="text" class="form-control" id = "departureStation" name="departureStation">
        </div>
        <div class = "form-group">
          <label for = "arrivalStation"> Arrival Station </label>
          <input type="text" class="form-control" id = "arrivalStation" name="arrivalStation">
        </div>
        <div class = "form-group">
          <label>Departure time range</label>
          <input type="time" class="form-control" name="firstTime">
          <input type="time" class="form-control" name="secondTime">
        </div>
        <button type = "submit" class = "btn btn-default">Find</button>
      </form>

      <form role = "form" name = "ShowAllRoutesForm" action = "ShowAllRoutesServlet" method = post>
          <button type = "submit" class = "btn btn-default">Show all routes</button>
      </form>


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
                <form role = "form" name = "AddRouteForm" action = "AddRouteToTrainServlet" method = post>
                  <div class = "form-group">
                    <input type="hidden" name = "routeId" value = ${route.getRouteId()}>
                  </div>
                    <button type = "submit" class = "btn btn-default">Add</button>
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
  </div>
</div>

</body>
</html>
