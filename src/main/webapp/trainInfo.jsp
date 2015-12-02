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

      <c:choose>
      <c:when test="${sessionScope.currentUser != null && sessionScope.currentUser.getUserTypeId() == 1}">
        <form role = "form" name = "ShowAllTrainForm" action = "ShowAllTrainsServlet" method = post>
          <button type="submit" class="btn btn-default">Show all trains</button>
        </form>
      </c:when>
      </c:choose>

    </div>
    <div class="col-sm-10 text-left">

      

      <c:choose>
      <c:when test="${sessionScope.trainList != null}">
        <h1>Trains</h1>
      <table class="table table-hover">
        <thead>
        <tr>
          <td>Train Name</td>
          <td>Departure Station</td>
          <td>Arrival Station</td>
          <td>Number of free seats</td>
          <td>Cost</td>
        </tr>
        </thead>
        <c:set var="trainList" value="${sessionScope.trainList}"/>
        <c:forEach items="${trainList}" var="train">
          <tr>
            <td><h5>${train.getName()}</h5></td>
            <td><h5>${train.getDepartureStation()} <small>${train.getDepartureStationTime()}</small></h5></td>
            <td><h5>${train.getArrivalStation()} <small>${train.getArrivalStationTime()}</small></h5></td>
            <td><h5>${train.getNumberOfFreeSeats()}</h5></td>
            <td><h5>${train.getCost()}</h5></td>
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