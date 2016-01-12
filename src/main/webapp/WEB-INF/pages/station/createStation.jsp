<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <title>Station Manager</title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="../user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">

          <h1>Create station</h1>
          <c:if test="${param.invalidName != null}">
            <div class="alert alert-danger">
              <p>Invalid name.</p>
            </div>
          </c:if>
        <c:if test="${param.alreadyExist != null}">
            <div class="alert alert-danger">
                <p>The station with the same name already exists.</p>
            </div>
        </c:if>
          <form role = "form" name = "CreateStationForm" action = "createStation.form" method = post>
            <div class = "form-group">
              <label for = "name"> Name </label>
              <input type="text" class="form-control" id = "name" name="name">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type = "submit" class = "btn btn-default">Create</button>
          </form>

    </div>
  </div>
</div>

</body>
</html>