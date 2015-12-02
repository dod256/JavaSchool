<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="GetProfileServlet">Profile</a></li>
                <li><a href="PrepareStationTimetableServlet">Station timetable</a></li>
                <li><a href="PrepareFindTrainServlet">Find train</a></li>
                <c:choose>
                    <c:when test="${sessionScope.currentUser != null && sessionScope.currentUser.getUserTypeId() == 1}">
                        <li><a href="trainManager.jsp">Train manager</a></li>
                        <li><a href="stationManager.jsp">Station manager</a></li>
                        <li><a href="routeManager.jsp">Route manager</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.currentUser == null}">
                        <li>
                            <a href="loginPage.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                        </li>
                        <li>
                            <a href="SignUp.jsp">Sign Up</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/LogoutServlet"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
