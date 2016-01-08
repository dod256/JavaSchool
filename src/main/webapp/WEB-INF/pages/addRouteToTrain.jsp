<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="profileSmall.jsp"%>
      <form role = "form" name = "showAllRoutesForTrainForm" action = "showAllRoutesForTrain.form" method = post>
        <button type = "submit" class = "btn btn-default">Show all routes</button>
      </form>
    </div>
    <div class="col-sm-10 text-left">

      <h1> Select Route </h1>

      <form role = "form" name = "showRoutesForTrainForm" action = "showRoutesForTrain.form" method = post>
        <div class = "form-group">
          <label for = "departureStation"> Departure Station </label>
          <select class="form-control" id = "departureStation" name="departureStation">
            <c:set var="stationList" value="${sessionScope.stationList}"/>
            <c:forEach items="${stationList}" var="station">
              <option>${station.getName()}</option>
            </c:forEach>
          </select>
        </div>
        <div class = "form-group">
          <label for = "arrivalStation"> Arrival Station </label>
          <select class="form-control" id = "arrivalStation" name="arrivalStation">
            <c:set var="stationList" value="${sessionScope.stationList}"/>
            <c:forEach items="${stationList}" var="station">
              <option>${station.getName()}</option>
            </c:forEach>
          </select>
        </div>
        <button type = "submit" class = "btn btn-default">Find</button>
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
                <form role = "form" name = "addRouteToTrainForm" action = "addRouteToTrain.form" method = post>
                  <div class = "form-group">
                    <input type="hidden" name = "routeId" value = ${route.getRouteId()}>
                  </div>
                    <button type = "submit" class = "btn btn-default">Add</button>
                </form>
              </td>
              <c:set var="routeStationList" value="${route.getRouteStations()}"/>
              <c:forEach items="${routeStationList}" var="routeStation">
                <td><h5>${routeStation.getStation().getName()} <small> ${routeStation.getArrival()}</small></h5></td>
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
