<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Route Manager</title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

      <form role = "form" name = "SetAddActionForm" action = "RouteManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "create">
        </div>
        <button type = "submit" class = "btn btn-default">Create</button>
      </form>

      <form role = "form" name = "SetShowAllActionForm" action = "RouteManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "showAll">
        </div>
        <button type = "submit" class = "btn btn-default">Show All</button>
      </form>

      <c:choose>
        <c:when test="${sessionScope.currentManagerAction == 'create'}">
        <form role = "form" name = "AddStationToRouteForm" action = "AddStationToRouteServlet" method = post>
          <button type = "submit" class = "btn btn-default">Add station</button>
        </form>
      </c:when>
      </c:choose>

    </div>
    <div class="col-sm-10 text-left">
      <c:choose>
        <c:when test="${sessionScope.currentManagerAction == null}">
          <h1>Status</h1>
          <div class="alert alert-info">
            <strong>Please, select action</strong>
          </div>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'create'}">
          ${sessionScope.currentManagerAction = null}
          <h1>Create route</h1>
          <form role = "form" name = CreateRouteForm action = "CreateRouteServlet" method = post>
            <div class = "form-group">
              <select class="form-control" id = "station1" name="station1">
                <c:set var="stationList" value="${sessionScope.stationList}"/>
                <c:forEach items="${stationList}" var="station">
                  <option>${station.getName()}</option>
                </c:forEach>
              </select>
            </div>
            <div class = "form-group">
              <label for = "time"> Departure time </label>
              <input type="time" class="form-control" id = "time" name="time">
            </div>
            <c:set var="newRouteStationList" value="${sessionScope.newRouteStationList}"/>
            <c:forEach items="${newRouteStationList}" var="newRouteStation">
              <div class = "form-group">
                <select class="form-control" id = ${newRouteStation} name=${newRouteStation}>
                  <c:set var="stationList" value="${sessionScope.stationList}"/>
                  <c:forEach items="${stationList}" var="station">
                    <option>${station.getName()}</option>
                  </c:forEach>
                </select>
              </div>
              <div class = "form-group">
                <label for = ${newRouteStation}OnWheel> Time On Wheel </label>
                <input type="text" class="form-control" id = ${newRouteStation}OnWheel name=${newRouteStation}OnWheel>
              </div>
              <div class = "form-group">
                <label for = ${newRouteStation}WaitingTime> Waiting Time </label>
                <input type="text" class="form-control" id = ${newRouteStation}WaitingTime name=${newRouteStation}WaitingTime>
              </div>
            </c:forEach>
            <button type = "submit" class = "btn btn-default">Create</button>
          </form>

        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'showAll'}">
          ${sessionScope.currentManagerAction = null}

          <table class="table table-hover">
            <thead>
            <tr>
              <th>Routes</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="routeList" value="${sessionScope.actionObjectList}"/>
            <c:forEach items="${routeList}" var="route">
              <tr>
                <c:set var="routeStationList" value="${route.getRouteStations()}"/>
                <c:forEach items="${routeStationList}" var="routeStation">
                  <td><h5>${routeStation.getStation().getName()} <small> ${routeStation.getArrival()}</small></h5></td>
                </c:forEach>
              </tr>
            </c:forEach>
            </tbody>
          </table>


          ${sessionScope.actionObjectList = null}
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>