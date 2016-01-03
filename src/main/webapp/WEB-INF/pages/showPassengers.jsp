<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Passengers</title>
  <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="greeting.jsp"%>

    </div>
    <div class="col-sm-10 text-left">

      <c:set var="passengerList" value="${sessionScope.passengerList}"/>
      <c:choose>
        <c:when test="${passengerList == null || passengerList.size() == 0}">
          <h1>No registered passengers</h1>
        </c:when>
        <c:when test="${passengerList != null && passengerList.size() > 0}">
          <h1>Passengers</h1>
          <table class="table table-hover">
            <thead>
            <tr>
              <td>First Name</td>
              <td>Last Name</td>
              <td>Birthday</td>
            </tr>
            </thead>
            <c:forEach items="${passengerList}" var="passenger">
              <tr>
                <td><h5>${passenger.getFirstName()}</h5></td>
                <td><h5>${passenger.getLastName()}</h5></td>
                <td><h5>${passenger.getBirthDateString()}</h5></td>
              </tr>
            </c:forEach>
          </table>
        </c:when>
      </c:choose>

    </div>
  </div>
</div>

</body>
</html>