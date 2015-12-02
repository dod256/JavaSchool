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

      <h1>Find Train</h1>
      <form role = "form" name = "FindTrainForm" action = "FindTrainServlet" method = post>
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
        <div class = "form-group">
          <label for = "date"> Date </label>
          <input type="date" class="form-control" id = "date" name="date">
        </div>
        <button type="submit" class="btn btn-default">Find</button>
      </form>


      <c:set var="trainTimetable" value="${sessionScope.trainTimetable}"/>
      <c:choose>
      <c:when test="${trainTimetable != null && trainTimetable.getTrainRouteTimes().size() > 0}">
        <h1>Trains</h1>
      <table class="table table-hover">
        <thead>
          <tr>
            <td>Train Name</td>
            <td>Route</td>
            <td>${trainTimetable.getDepartureStation().getName()}</td>
            <td>${trainTimetable.getArrivalStation().getName()}</td>
          </tr>
        </thead>
        <c:forEach items="${trainTimetable.getTrainRouteTimes()}" var="trainRouteTime">
          <tr>
            <td><h5>${trainRouteTime.getTrain().getName()}</h5></td>
            <td>
              <h5>${trainRouteTime.getTrain().getDepartureStation().getStation().getName()} <small>${trainArrivalTime.getTrain().getDepartureStation().getArrival()}</small></h5>
              <h5>${trainRouteTime.getTrain().getArrivalStation().getStation().getName()} <small>${trainArrivalTime.getTrain().getArrivalStation().getArrival()}</small></h5>
            </td>
            <td><h5>${trainRouteTime.getDepartureTimeString()}</h5></td>
            <td><h5>${trainRouteTime.getArrivalTimeString()}</h5></td>
            <td>
              <form role = "form" name = "BuyTicketForm" action = "BuyTicketServlet" method = post>
                <div class = "form-group">
                  <input type="hidden" name = "trainId" value = ${train.getId()}>
                </div>
                <button type = "submit" class = "btn btn-default">Purhase</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
      </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>