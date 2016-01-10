<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Station Info</title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
      <c:set var="station" value="${sessionScope.station}"/>
      <h1> Info about ${station.getName()}</h1>
      <h3>Distances</h3>
      <table class="table table-hover">
        <thead>
        <tr>
          <td>Station</td>
          <td>Distance</td>
        </tr>
        </thead>
        <c:set var="distanceList" value="${sessionScope.distanceList}"/>
        <c:forEach items="${distanceList}" var="distance">
          <tr>
            <td><h5>${distance.getSecondStation()}</h5></td>
            <td><h5>${distance.getDistance()}</h5></td>
            <td>
              <form role = "form" name = "changeDistanceFrom" action = "changeDistance.form" method = post>
                <div class="form-group">
                  <label for="distance">New Distance</label>
                  <input type="distance" class="form-control" id="distance" name = "distance">
                </div>
                <div class = "form-group">
                  <input type="hidden" name = "firstStation" value = ${distance.getFirstStation()}>
                  <input type="hidden" name = "secondStation" value = ${distance.getSecondStation()}>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type = "submit" class = "btn btn-default">Change Distance</button>
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