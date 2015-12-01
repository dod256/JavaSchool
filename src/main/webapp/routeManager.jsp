<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Route Manager</title>
  <%@ include file = "/style.jsp" %>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

      <form role = "form" name = "SetAddActionForm" action = "RouteManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "create">
        </div>
        <button type = "submit" class = "btn btn-default">Create</button>
      </form>

      <form role = "form" name = "SetDeleteActionForm" action = "RouteManagerSetActionServlet" method = post>
        <div class = "form-group">
          <input type="hidden" name = "actionType" value = "delete">
        </div>
        <button type = "submit" class = "btn btn-default">Delete</button>
      </form>

    </div>
    <div class="col-sm-10 text-left">
      <c:choose>
        <c:when test="${sessionScope.currentManagerAction == null}">
          <div class="alert alert-info">
            <h1>Status</h1>
            <strong>Please, select action</strong>
          </div>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'create'}">
          <h1>Create route</h1>
          <h1>ToDo add magic</h1>
        </c:when>
        <c:when test="${sessionScope.currentManagerAction == 'delete'}">
          <h1>Delete route</h1>
          <h1>ToDo delete magic</h1>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>