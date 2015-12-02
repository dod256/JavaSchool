<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Station Timetable</title>
    <%@ include file = "/style.jsp" %>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <%@ include file="greeting.jsp"%>
        </div>
        <div class="col-sm-10 text-left">

            <form role = "form" name = "ShowTimetableForm" action = "ShowStationTimetableServlet" method = post>
                <div class = "form-group">
                    <label for = "selectName"> Name </label>
                    <select class="form-control" id = "selectName" name="name">
                        <c:set var="stationList" value="${sessionScope.stationList}"/>
                        <c:forEach items="${stationList}" var="station">
                            <option>${station.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class = "form-group">
                    <label for = "date"> Departure date </label>
                    <input type="date" class="form-control" id = "date" name="date">
                </div>
                <button type = "submit" class = "btn btn-default">Find</button>
            </form>
            <c:set var="stationTimetable" value="${sessionScope.stationTimetable}"/>
            <c:choose>
            <c:when test="${stationTimetable != null && stationTimetable.getTrainArrivalTimes().size() > 0}">
                <h1>${stationTimetable.getStation().getName()} <small> ${stationTimetable.getDateString()}</small></h1>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td>Train Name</td>
                        <td>Route</td>
                        <td>${stationTimetable.getStation().getName()}</td>
                    </tr>
                    </thead>
                    <c:set var="trainArrivalTimeList" value="${stationTimetable.getTrainArrivalTimes()}"/>
                    <c:forEach items="${trainArrivalTimeList}" var="trainArrivalTime">
                        <tr>
                            <td><h5>${trainArrivalTime.getTrain().getName()}</h5></td>
                            <td>
                                <h5>${trainArrivalTime.getTrain().getDepartureStation().getStation().getName()} <small>${trainArrivalTime.getTrain().getDepartureStation().getArrival()}</small></h5>
                                <h5>${trainArrivalTime.getTrain().getArrivalStation().getStation().getName()} <small>${trainArrivalTime.getTrain().getArrivalStation().getArrival()}</small></h5>
                            </td>
                            <td><h5>${trainArrivalTime.getArrivalTimeString()}</h5></td>
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