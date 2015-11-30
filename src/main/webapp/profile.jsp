<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <%@ include file = "/style.jsp" %>
<body>

<%@ include file = "/menu.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <%@ include file="greeting.jsp"%>
        </div>
        <div class="col-sm-10 text-left">
            <h1>Personal Information</h1>
            <h4>First Name: <small>${sessionScope.currentUser.getFirstName()}</small></h4>
            <h4>Last Name: <small>${sessionScope.currentUser.getLastName()}</small></h4>
            <h4>Birthday: <small>${sessionScope.currentUser.getBirthDate()}</small></h4>

            <table class="table table-hover">
                <thead>
                <tr>
                    <td>Ticket Number</td>
                    <td>Train Name</td>
                    <td>Departure Station</td>
                    <td>Arrival Station</td>
                </tr>
                </thead>
                <c:set var="ticketList" value="${sessionScope.ticketList}"/>
                <c:forEach items="${ticketList}" var="train">
                    <tr>
                        <td><h5>${ticket.getId()}</h5></td>
                        <td><h5>${ticket.getTrain().getName()}</h5></td>
                        <td><h5>${ticket.getTrain().getDepartureStation().getStation().getName()} <small>${train.getDepartureStation().getArrival()}</small></h5></td>
                        <td><h5>${ticket.getTrain().getArrivalStation().getStation().getName()} <small>${train.getArrivalStation().getArrival()}</small></h5></td>

                        <td>
                            <form role = "form" name = "BuyTicketForm" action = "BuyTicketServlet" method = post>
                                <div class = "form-group">
                                    <input type="hidden" name = "trainId" value = ${train.getId()}>
                                </div>
                                <button type = "submit" class = "btn btn-default">Buy</button>
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