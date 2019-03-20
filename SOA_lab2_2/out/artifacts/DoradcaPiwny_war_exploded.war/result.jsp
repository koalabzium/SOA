<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019-03-20
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h3>Twoje piwo na dziś to: </h3>
    <%
        String beer = request.getParameter("chosen");
        out.println(beer);
    %>
</body>
</html>
