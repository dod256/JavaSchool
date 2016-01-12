<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Route Manager</title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="../user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
      <ul class="pager">
        <li class="previous"><a href="routePagerDec.html">Previous</a></li>
        <li class="next"><a href="routePagerInc.html">Next</a></li>
      </ul>
      <table class="table table-hover">
            <thead>
            <tr>
              <th>Routes</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="routeList" value="${sessionScope.routeList}"/>
            <c:forEach items="${routeList}" var="route">
              <tr>
                <c:set var="routeStationList" value="${route.getRouteStations()}"/>
                <c:forEach items="${routeStationList}" var="routeStation">
                  <td><h5>${routeStation.getStation().getName()} <small> ${routeStation.getArrival()}</small></h5></td>
                </c:forEach>
              </tr>
            </c:forEach>
            </tbody>
          </table>
    </div>
  </div>
</div>

</body>
</html>