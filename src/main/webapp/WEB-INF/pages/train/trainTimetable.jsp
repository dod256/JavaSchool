<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="../user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">

      <h1>Find Train</h1>
      <form role = "form" name = "findTrainTimetableForm" action = "findTrainTimetable.form" method = post>
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
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
            <td>Number of free seats</td>
            <td>Cost</td>
          </tr>
        </thead>
        <c:forEach items="${trainTimetable.getTrainRouteTimes()}" var="trainRouteTime">
          <tr>
            <td><h5>${trainRouteTime.getTrain().getName()}</h5></td>
            <td>
              <h5>${trainRouteTime.getTrain().getDepartureStation()} <small>${trainArrivalTime.getTrain().getDepartureStation().getArrival()}</small></h5>
              <h5>${trainRouteTime.getTrain().getArrivalStation()} <small>${trainArrivalTime.getTrain().getArrivalStation().getArrival()}</small></h5>
            </td>
            <td><h5>${trainRouteTime.getDepartureTimeString()}</h5></td>
            <td><h5>${trainRouteTime.getArrivalTimeString()}</h5></td>
            <td><h5>${trainRouteTime.getTrain().getNumberOfFreeSeats()}</h5></td>
            <td><h5>${trainRouteTime.getTrain().getCost()}</h5></td>
            <td>
              <form role = "form" name = "purchaseTicketForm" action = "purchaseTicket.form" method = post>
                <div class = "form-group">
                  <input type="hidden" name = "trainId" value = ${trainRouteTime.getTrain().getId()}>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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