<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
      <h1>Status</h1>

      <c:choose>
        <c:when test="${sessionScope.operationResultMessage.getStatus() == 'success'}">
          <div class="alert alert-success">
            <strong>${sessionScope.operationResultMessage.getMessage()}</strong>
          </div>
        </c:when>
        <c:when test="${sessionScope.operationResultMessage.getStatus() == 'danger'}">
          <div class="alert alert-danger">
            <strong>${sessionScope.operationResultMessage.getMessage()}</strong>
          </div>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>