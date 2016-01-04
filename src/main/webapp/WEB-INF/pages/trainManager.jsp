<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Train Manager</title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

      <form role = "form" name = "SetAddActionForm" action = "TrainManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "create">
        </div>
        <button type = "submit" class = "btn btn-default">Create</button>
      </form>

      <form role = "form" name = "ShowAllTrainForm" action = "TrainManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "showAll">
        </div>
        <button type="submit" class="btn btn-default">Show all trains</button>
      </form>

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
          <h1>Create train</h1>
          <form role = "form" name = "AddTrainForm" action = "AddTrainServlet" method = post>
            <div class = "form-group">
              <label for = "name"> Name </label>
              <input type="text" class="form-control" id = "name" name="name">
            </div>
            <div class = "form-group">
              <label for = "date"> Departure date </label>
              <input type="date" class="form-control" id = "date" name="date">
            </div>
            <div class = "form-group">
              <label for = "numberOfSeats"> Number of seats </label>
              <input type="text" class="form-control" id = "numberOfSeats" name="numberOfSeats">
            </div>
            <div class = "form-group">
              <label for = "cost"> Cost per ticket </label>
              <input type="text" class="form-control" id = "cost" name="cost">
            </div>
            <button type = "submit" class = "btn btn-default">Continue</button>
          </form>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'showAll'}">
          ${sessionScope.currentManagerAction = null}
          <c:set var="trainList" value="${sessionScope.actionObjectList}"/>
          <c:choose>
            <c:when test="${trainList != null}">
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
                  <td>Show Passangers</td>
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
                      <form role = "form" name = "ShowPassengersForm" action = "ShowPassengersServlet" method = post>
                        <div class = "form-group">
                          <input type="hidden" name = "trainId" value = ${train.getId()}>
                        </div>
                        <button type = "submit" class = "btn btn-default">Show All</button>
                      </form>
                    </td>
                  </tr>
                </c:forEach>
              </table>
            </c:when>
          </c:choose>
          ${sessionScope.actionObjectList = null}
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>