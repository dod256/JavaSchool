<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="home.html">Home</a></li>
                <li><a href="stationTimetable.html">Station timetable</a></li>
                <li><a href="findTrain.html">Find train</a></li>
                <li><a href="pathManager.html">Find path</a></li>
                <li class = "dropdown">
                        <a href = "#" class="dropdown-toggle" data-toggle="dropdown">Station Manager
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="createStation.html">Create station</a></li>
                            <li><a href="showAllStations.html">Show all stations</a></li>
                        </ul>
                </li>
                <li class = "dropdown">
                    <a href = "#" class="dropdown-toggle" data-toggle="dropdown">Train Manager
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="createTrain.html">Create train</a></li>
                        <li><a href="showAllTrains.html">Show all trains</a></li>
                    </ul>
                </li>
                <li class = "dropdown">
                    <a href = "#" class="dropdown-toggle" data-toggle="dropdown">Route Manager
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="createRoute.html">Create route</a></li>
                        <li><a href="showAllRoutes.html">Show all routes</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="profile.html"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
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
                            <a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
