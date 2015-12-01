<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Sign Up</title>
  <%@ include file = "/style.jsp" %>
  <script>
    function validate() {
      var x = document.forms["newUserForm"]["firstName"].value;
      if (x.length  < 1 || x.length > 30) {
        alert("invalid length");
        return false;
      }
      var re1 = new RegExp("[a-zA-Z0-9]+");
      if (!re1.test(x)) {
        alert("invalid symbols");
        return false;
      }
      return true;
    }
  </script>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

    </div>
    <div class="col-sm-10 text-left">

      <form role = "form" name = "newUserForm" action="SignUp" onSubmit = "return validate()" method=post>
        <div class = "form-group">
          <label> Name </label>
          <input type="text" name="firstName" class="form-control" placeholder = "First">
          <input type="text" name="lastName" class="form-control" placeholder = "Last">
        </div>
        <div class = "form-group">
          <label for = "email"> Email </label>
          <input type="text" class="form-control" id = "email" name="email">
        </div>
        <div class = "form-group">
          <label for = "password"> Create password </label>
          <input type = "password" class="form-control" id = "password" name="password">
        </div>
        <div class = "form-group">
          <label for = "secondPassword"> Confirm your password </label>
          <input type="password" class="form-control" id = "secondPassword" name="password">
        </div>
        <div class = "form-group">
          <label for = "date"> Birthday </label>
          <input type="date" class="form-control" id = "date" name="birthdate">
        </div>
        <button type="submit" class="btn btn-default">Sign Up</button>
      </form>


    </div>
  </div>
</div>

</body>
</html>
