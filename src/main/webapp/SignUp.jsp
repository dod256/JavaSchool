<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Sign Up</title>
    <link type="text/css" rel="stylesheet" href="Styles/styles.css" />
  </head>
<body>
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
<h2>Sign Up</h2>
<br><br>
<form name = "newUserForm" action="SignUp" onSubmit = "return validate()" method=post>
  <div class = "form-element">
    <label> Name </label>
    <input type="text" name="firstName" placeholder = "First">
    <input type="text" name="lastName" placeholder = "Last">
  </div>
  <div class = "form-element">
    <label> Email </label>
    <input type="text" name="email">
  </div>
  <div class = "form-element">
    <label> Create password </label>
    <input type="password" name="password">
  </div>
  <div class = "form-element">
    <label> Confirm your password </label>
    <input type="secondPassword" name="password">
  </div>
  <div class = "form-element">
    <label> Birthday </label>
    <input type="date" name="birthdate">
  </div>
  <div class = "form-element">
    <input type="submit" value="Sign Up">
  </div>
</form>
</body>
</html>
