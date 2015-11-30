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
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="StationTimetable.jsp">Station timetable</a></li>
                <li><a href="TrainTimetable.jsp">Find train</a></li>
                <c:choose>
                    <c:when test="${sessionScope.currentUser != null && sessionScope.currentUser.getUserTypeId() == 1}">
                        <li><a href="addTrain.jsp">Add train</a></li>
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
