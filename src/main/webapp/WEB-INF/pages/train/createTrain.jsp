<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
          <form role = "form" name = "addTrainForm" action = "addTrain.form" method = post>
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
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type = "submit" class = "btn btn-default">Continue</button>
          </form>

    </div>
  </div>
</div>

</body>
</html>