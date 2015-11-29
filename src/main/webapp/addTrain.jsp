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
        <button type = "submit" class = "btn btn-default">Add</button>
      </form>


    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
