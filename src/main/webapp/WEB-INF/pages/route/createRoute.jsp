<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Route Manager</title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="../user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
          <h1>New route creation</h1>
          <form role = "form" name = "createRouteForm" action = "createRoute.form" method = post>
            <div class = "form-group">
              <button type = "submit" class = "btn btn-default">Create route</button>
            </div>
          </form>
          <form role = "form" name = addStationToRouteForm action = "addStationToRoute.form" method = post>
            <div class = "form-group">
              <select class="form-control" id = "station" name="station">
                <c:set var="stationList" value="${sessionScope.stationList}"/>
                <c:forEach items="${stationList}" var="station">
                  <option>${station.getName()}</option>
                </c:forEach>
              </select>
            </div>
            <div class = "form-group">
              <label for = "arrivalTime"> Arrival Time </label>
              <input type="time" class = "form-control" id = "arrivalTime" name= "arrivalTime">
            </div>
            <div class = "form-group">
              <label for = daysOnWheel> Days On Wheel </label>
              <input type="text" class="form-control" id = "daysOnWheel" name = "daysOnWheel">
            </div>
            <div class = "form-group">
              <label for = waitingTime> Waiting Time </label>
              <input type="time" class="form-control" id = "waitingTime" name="waitingTime">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class = "form-group">
              <button type = "submit" class = "btn btn-default">Add station</button>
            </div>
          </form>
          <table class="table table-hover">
            <thead>
            <tr>
              <th>Station</th>
              <th>Arrival Time</th>
              <th>Waiting Time</th>
              <th>Days on Wheel</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="currentRoute" value="${sessionScope.routeBuilder.getRouteStations()}"/>
            <c:forEach items="${currentRoute}" var="routeStation">
              <tr>
                <td><h5>${routeStation.getStation()}</h5></td>
                <td><h5>${routeStation.getArrivalTimeString()}</h5></td>
                <td><h5>${routeStation.getWaitingTimeString()}</h5></td>
                <td><h5>${routeStation.getDaysOnWheel()}</h5></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
    </div>
  </div>
</div>

</body>
</html>