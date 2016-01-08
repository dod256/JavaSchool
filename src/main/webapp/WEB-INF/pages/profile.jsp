<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <%@ include file = "/WEB-INF/pages/style.jsp" %>
<body>

<%@ include file = "/WEB-INF/pages/menu.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <%@ include file="profileSmall.jsp"%>
        </div>
        <div class="col-sm-10 text-left">
            <h1>Personal Information</h1>
            <h4>First Name: <small>${sessionScope.currentUser.getFirstName()}</small></h4>
            <h4>Last Name: <small>${sessionScope.currentUser.getLastName()}</small></h4>
            <h4>Birthday: <small>${sessionScope.currentUser.getBirthDateString()}</small></h4>


            <c:choose>
            <c:when test="${sessionScope.ticketList == null}">
                <h3>You don't have any tickets.</h3>
            </c:when>
            <c:when test="${sessionScope.ticketList != null}">
                <h1>Ticket List</h1>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td>Ticket Number</td>
                        <td>Departure Date</td>
                        <td>Train Name</td>
                        <td>Departure Station</td>
                        <td>Arrival Station</td>
                    </tr>
                    </thead>
                    <c:set var="ticketList" value="${sessionScope.ticketList}"/>
                    <c:forEach items="${ticketList}" var="ticket">
                        <tr>
                            <td><h5>${ticket.getId()}</h5></td>
                            <td><h5>${ticket.getDepartureDateString()}</h5></td>
                            <td><h5>${ticket.getTrain()}</h5></td>
                            <td><h5>${ticket.getDepartureStation()} <small>time</small></h5></td>
                            <td><h5>${ticket.getArrivalStation()} <small>time</small></h5></td>
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