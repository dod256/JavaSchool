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

          <h1>All Stations</h1>
        <ul class="pager">
          <li class="previous"><a href="stationPagerDec.html">Previous</a></li>
          <li class="next"><a href="stationPagerInc.html">Next</a></li>
        </ul>
          <table class="table table-hover">
            <thead>
            <tr>
              <td>Station</td>
              <td>Info</td>
            </tr>
            </thead>
            <c:set var="stationList" value="${sessionScope.stationList}"/>
            <c:forEach items="${stationList}" var="station">
              <tr>
                <td><h5>${station.getName()}</h5></td>
                <td>
                  <form role = "form" name = "showStationInfoForm" action = "showStationInfo.form" method = post>
                    <div class = "form-group">
                      <input type="hidden" name = "stationId" value = ${station.getId()}>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type = "submit" class = "btn btn-default">Show Info</button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </table>

    </div>
  </div>
</div>

</body>
</html>