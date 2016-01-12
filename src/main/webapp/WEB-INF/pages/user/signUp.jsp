<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Sign Up</title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="profileSmall.jsp"%>

    </div>
    <div class="col-sm-10 text-left">

      <form action = "signUp.form" role = "form" name = "newUserForm" method=post>
        <c:if test="${param.invalidName != null}">
          <div class="alert alert-danger">
            <p>Invalid name.</p>
          </div>
        </c:if>
        <div class = "form-group">
          <label> Name </label>
          <input type="text" name="firstName" class="form-control" placeholder = "First">
          <input type="text" name="lastName" class="form-control" placeholder = "Last">
        </div>
        <c:if test="${param.invalidEmail != null}">
          <div class="alert alert-danger">
            <p>Invalid email.</p>
          </div>
        </c:if>
        <div class = "form-group">
          <label for = "email"> Email </label>
          <input type="email" class="form-control" id = "email" name="email">
        </div>
        <c:if test="${param.invalidPass != null}">
          <div class="alert alert-danger">
            <p>These passwords don't match.</p>
          </div>
        </c:if>
        <c:if test="${param.invalidPass1 != null}">
          <div class="alert alert-danger">
            <p>Password is empty.</p>
          </div>
        </c:if>
        <div class = "form-group">
          <label for = "password"> Create password </label>
          <input type = "password" class="form-control" id = "password" name="password">
        </div>
        <c:if test="${param.invalidPass != null}">
          <div class="alert alert-danger">
            <p>These passwords don't match.</p>
          </div>
        </c:if>
        <c:if test="${param.invalidPass2 != null}">
          <div class="alert alert-danger">
            <p>Password is empty.</p>
          </div>
        </c:if>
        <div class = "form-group">
          <label for = "secondPassword"> Confirm your password </label>
          <input type="password" class="form-control" id = "secondPassword" name="secondPassword">
        </div>
        <c:if test="${param.invalidDate != null}">
          <div class="alert alert-danger">
            <p>Select date.</p>
          </div>
        </c:if>
        <div class = "form-group">
          <label for = "date"> Birthday </label>
          <input type="date" class="form-control" id = "date" name="birthdate">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Sign Up</button>
      </form>


    </div>
  </div>
</div>

</body>
</html>
