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

      <form role = "form" name = "FindTrainForm" action = "FindTrainServlet" method = post>
        <div class = "form-group">
          <label for = "departureStation"> Departure Station </label>
          <input type="text" class="form-control" id = "departureStation" name="departureStation">
        </div>
        <div class = "form-group">
          <label for = "arrivalStation"> Arrival Station </label>
          <input type="text" class="form-control" id = "arrivalStation" name = "arrivalStation">
        </div>
        <div class = "form-group">
          <label for = "date"> Date </label>
          <input type="date" class="form-control" id = "date" name="date">
        </div>
        <button type="submit" class="btn btn-default">Find</button>
      </form>

      <form role = "form" name = "ShowAllTrainForm" action = "ShowAllTrainsServlet" method = post>
        <button type="submit" class="btn btn-default">Show all trains</button>
      </form>

      <table class="table table-hover">
        <thead>
          <tr>
            <td>Train Name</td>
            <td>Departure Station</td>
            <td>Arrival Station</td>
            <td>Number of free seats</td>
            <td>Cost</td>
            <td>Ticket</td>
          </tr>
        </thead>
        <c:set var="trainList" value="${sessionScope.trainList}"/>
        <c:forEach items="${trainList}" var="train">
          <tr>
            <td><h5>${train.getName()}</h5></td>
            <td><h5>${train.getDepartureStation().getStation().getName()} <small>${train.getDepartureStation().getArrival()}</small></h5></td>
            <td><h5>${train.getArrivalStation().getStation().getName()} <small>${train.getArrivalStation().getArrival()}</small></h5></td>
            <td><h5>${train.getNumberOfFreeSeats()}</h5></td>
            <td><h5>${train.getCost()}</h5></td>
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

    </div>
  </div>
</div>

</body>
</html>