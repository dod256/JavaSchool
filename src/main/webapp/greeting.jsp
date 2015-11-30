<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${sessionScope.currentUser == null}">
    <div class="alert alert-info">
      <strong>Hello, guest.</strong> Log in, please!
    </div>
  </c:when>
  <c:otherwise>
    <div class="alert alert-info">
      <strong>Hello, ${sessionScope.currentUser.getFirstName()} ${sessionScope.currentUser.getLastName()}.</strong>
    </div>
  </c:otherwise>
</c:choose>

