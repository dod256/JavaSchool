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

      <%@ include file = "/login.jsp" %>
      <form role = "form" name = "SignUpForm" action = "SignUp.jsp" method = get>
        <button type = "submit" class = "btn btn-default">Sign Up</button>
      </form>

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

      <table class="table table-hover">
        <thead>
          <tr>
            <td>Train Name</td>
            <td>Departure Station</td>
            <td>Arrival Station</td>
            <td>Departure Date</td>
            <td>Arrival Date</td>
          </tr>
        </thead>
        <c:set var="trainList" value="${sessionScope.trainList}"/>
        <c:forEach items="${trainList}" var="train">
          <tr>
            <td>${train.getName()}</td>
            <td>${train.getDepartureStation()}</td>
            <td>${train.getArrivalStation()}</td>
            <td>${train.getDepartureTime()}</td>
            <td>${train.getArrivalTime()}</td>
          </tr>
        </c:forEach>
      </table>

    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>