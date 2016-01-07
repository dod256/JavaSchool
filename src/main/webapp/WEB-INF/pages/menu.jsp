<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="home.html">Home</a></li>
                <li><a href="profile.html">Profile</a></li>
                <li><a href="stationTimetable.html">Station timetable</a></li>
                <li><a href="findTrain.html">Find train</a></li>
                <li><a href="pathManager.html">Find path</a></li>
                <c:choose>
                    <c:when test="${sessionScope.currentUser != null && sessionScope.currentUser.getUserTypeId() == 1}">
                        <li><a href="trainManager.html">Train manager</a></li>
                        <li><a href="stationManager.html">Station manager</a></li>
                        <li><a href="routeManager.html">Route manager</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.currentUser == null}">
                        <li>
                            <a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                        </li>
                        <li>
                            <a href="signUp.html">Sign Up</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="logout.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
