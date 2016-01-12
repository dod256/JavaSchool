<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
       <ul class="pager">
          <li class="previous"><a href="stationPagerDec.html">Previous</a></li>
          <li class="next"><a href="stationPagerInc.html">Next</a></li>
        </ul>
          <table class="table table-hover">
            <thead>
            <tr>
              <th>Stations</th>
            </tr>
            </thead>
            <c:set var="stationList" value="${sessionScope.stationList}"/>
            <c:forEach items="${stationList}" var="station">
              <tr>
                <td><h5>${station.getName()}</h5></td>
              </tr>
            </c:forEach>
          </table>

    </div>
  </div>
</div>

</body>
</html>