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
      <div class="alert alert-success">
        <strong>Success!</strong> Train added.
      </div>
      <p>Info about train</p>
    </div>
  </div>
</div>

</body>
</html>