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
      <%@ include file="user/profileSmall.jsp"%>

      <h3>Find path</h3>

      <form role = "form" name = "fastestFrom" action = "selectPathType.form" method = post>
        <div class = "form-group">
          <input type="hidden" name = "pathType" value = "fastest">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type = "submit" class = "btn btn-default">the Fastest</button>
      </form>

      <form role = "form" name = "cheapestFrom" action = "selectPathType.form" method = post>
        <div class = "form-group">
          <input type="hidden" name = "pathType" value = "cheapest">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type = "submit" class = "btn btn-default">the Cheapest</button>
      </form>

    </div>
    <c:choose>
    <c:when test="${sessionScope.pathType != null}">

    <div class="col-sm-10 text-left">
      <form role = "form" name = "findPathForm" action = "findPath.form" method = post>
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
        <input type="hidden" name = "pathType" value = ${sessionScope.pathType}>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Find</button>
      </form>
    </div>

    </c:when>
    </c:choose>

  </div>
</div>

</body>
</html>