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
      <%@ include file="greeting.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
      <h1>Status</h1>
      <c:choose>
        <c:when test="${sessionScope.currentMessageType == 'success'}">
          <div class="alert alert-success">
            <strong>Success!</strong> ${sessionScope.currentMessage}
          </div>
        </c:when>
        <c:when test="${sessionScope.currentMessageType == 'danger'}">
          <div class="alert alert-danger">
            <strong>Fail!</strong> ${sessionScope.currentMessage}
          </div>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>