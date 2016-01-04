<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Station Manager</title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

      <form role = "form" name = "setAddStationActionForm" action = "setAddStationAction.form" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "createStation">
        </div>
        <button type = "submit" class = "btn btn-default">Create</button>
      </form>

      <form role = "form" name = "setShowAllStationsActionForm" action = "setShowAllStationsAction.form" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "showAllStations">
        </div>
        <button type = "submit" class = "btn btn-default">Show all stations</button>
      </form>

      <form role = "form" name = "setFindStationActionForm" action = "setFindStationAction.form" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "findStation">
        </div>
        <button type = "submit" class = "btn btn-default">Find station</button>
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
        <c:when test="${sessionScope.currentManagerAction == 'createStation'}">
          ${sessionScope.currentManagerAction = null}
          <h1>Create station</h1>
          <form role = "form" name = "AddStationForm" action = "addStation.form" method = post>
            <div class = "form-group">
              <label for = "name"> Name </label>
              <input type="text" class="form-control" id = "name" name="name">
            </div>
            <button type = "submit" class = "btn btn-default">Create</button>
          </form>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'showAllStations'}">
          <h1>All Stations</h1>
          <c:set var="stationList" value="${sessionScope.stationList}"/>
          <c:forEach items="${stationList}" var="station">
            <h5>${station.getName()}</h5>
          </c:forEach>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>