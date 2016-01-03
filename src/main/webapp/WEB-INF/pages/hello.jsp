<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
Hello <%= request.getAttribute("name")%>
</body>
</html>
