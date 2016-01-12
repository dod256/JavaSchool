<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:choose>
  <c:when test="${sessionScope.currentUser == null}">
    <div class="alert alert-info">
      <strong>Hello, guest.</strong> Log in, please!
    </div>
  </c:when>
  <c:otherwise>
    <div class="alert alert-info">
      <h3><strong><a href="profile.html">${sessionScope.currentUser.getFirstName()} ${sessionScope.currentUser.getLastName()}.</a></strong></h3>
      <h5>Balance: ${sessionScope.currentUser.getBalance()}<span class="glyphicon glyphicon-euro"></span></h5>
      <form action="makeDeposit.form" role="form" name = "makeDepositForm" method = post>
        <div class="form-group">
          <label for="deposit">Deposit</label>
          <input type="text" class="form-control" id="deposit" name = "deposit">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-default">Make deposit</button>
      </form>

    </div>
  </c:otherwise>
</c:choose>

