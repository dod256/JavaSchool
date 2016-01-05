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
      <h1>Some Info</h1>
      <c:set var="station" value="${sessionScope.station}"/>
      <h5>${station.getName()}</h5>
    </div>
  </div>
</div>

</body>
</html>