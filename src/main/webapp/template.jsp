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

      <%@ include file = "/login.jsp" %>
      <form role = "form" name = "SignUpForm" action = "SignUp.jsp" method = get>
        <button type = "submit" class = "btn btn-default">Sign Up</button>
      </form>

    </div>
    <div class="col-sm-10 text-left">
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>