<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="Styles/styles.css" />
    </head>
    <body>

    <div id = "wrapper">
        <header>Index</header>
        <%@ include file = "/menu.jsp" %>
        <section id = "content" class = "clearfix" >
            <section id = "page-content">
                <div class = "content-wrap">
                    <%@ include file = "/login.jsp" %>
                    <form name = "SignUpForm" action = "SignUp.html" method = get>
                        <div class = "form-element">
                            <input type = "submit" value = "Sign Up">
                        </div>
                    </form>
                </div>
            </section>
            <aside></aside>
        </section>
        <div id = "empty-div"></div>
    </div>
    <footer></footer>

    </body>
</html>