<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Train Manager</title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="../user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
          <c:set var="trainList" value="${sessionScope.trainList}"/>
          <c:choose>
            <c:when test="${trainList == null}">
              <h3>There are no trains</h3>
            </c:when>
            <c:otherwise>
            <h1>All Trains</h1>
              <table class="table table-hover">
                <thead>
                <tr>
                  <td>Train Name</td>
                  <td>Departure Date</td>
                  <td>Departure Station</td>
                  <td>Arrival Station</td>
                  <td>Number of free seats</td>
                  <td>Cost</td>
                  <td>Show Passengers</td>
                </tr>
                </thead>
                <c:forEach items="${trainList}" var="train">
                  <tr>
                    <td><h5>${train.getName()}</h5></td>
                    <td><h5>${train.getDepartureDateString()}</h5></td>
                    <td><h5>${train.getDepartureStation()} <small>${train.getDepartureStationTime()}</small></h5></td>
                    <td><h5>${train.getArrivalStation()} <small>${train.getArrivalStationTime()}</small></h5></td>
                    <td><h5>${train.getNumberOfFreeSeats()}</h5></td>
                    <td><h5>${train.getCost()}</h5></td>
                    <td>
                      <form role = "form" name = "showPassengersForm" action = "showPassengers.form" method = post>
                        <div class = "form-group">
                          <input type="hidden" name = "trainId" value = ${train.getId()}>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type = "submit" class = "btn btn-default">Show All</button>
                      </form>
                    </td>
                  </tr>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>

    </div>
  </div>
</div>

</body>
</html>