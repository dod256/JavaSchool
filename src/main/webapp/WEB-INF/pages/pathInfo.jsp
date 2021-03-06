<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <%@ include file = "/WEB-INF/pages/style/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="user/profileSmall.jsp"%>
    </div>
    <div class="col-sm-10 text-left">
      <h1>Result</h1>
      <c:choose>
      <c:when test="${path == null}">
        <h3>Path doesn't exist</h3>
        <a href = "pathManager.html">Search again</a>
      </c:when>
      <c:when test="${path != null}">
        <table class="table table-hover">
                <thead>
                <tr>
                  <td>From</td>
                  <td>To</td>
                  <td>Train</td>
                </tr>
                </thead>
                <c:forEach items="${path.getPath()}" var="part">
                  <tr>
                    <td><h5>${part.getDepartureStation()} <small>${part.getDepartureDateTimeString()}</small></h5></td>
                    <td><h5>${part.getArrivalStation()} <small>${part.getArrivalDateTimeString()}</small></h5></td>
                    <td><h5>${part.getTrain()}</h5></td>
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