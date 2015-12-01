<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Station Manager</title>
  <%@ include file = "/style.jsp" %>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

      <form role = "form" name = "SetAddActionForm" action = "StationManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "create">
        </div>
        <button type = "submit" class = "btn btn-default">Create</button>
      </form>

      <form role = "form" name = "SetDeleteActionForm" action = "StationManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "delete">
        </div>
        <button type = "submit" class = "btn btn-default">Delete</button>
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
          <h1>Create station</h1>
          <form role = "form" name = "AddStationForm" action = "AddStationServlet" method = post>
            <div class = "form-group">
              <label for = "name"> Name </label>
              <input type="text" class="form-control" id = "name" name="name">
            </div>
            <button type = "submit" class = "btn btn-default">Create</button>
          </form>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'delete'}">
          <h1>Delete station</h1>
          <form role = "form" name = "DeleteStationForm" action = "DeleteStationServlet" method = post>
            <div class = "form-group">
              <label for = "selectName"> Name </label>
              <select class="form-control" id = "selectName" name="name">

              </select>
            </div>
            <button type = "submit" class = "btn btn-default">Delete</button>
          </form>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>