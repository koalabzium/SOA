<%--
  Created by IntelliJ IDEA.
  User: zosiek
  Date: 20.03.19
  Time: 07:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Logowanie</title>
  </head>
  <body>
  <body>
  <%
    String error = request.getParameter("error");
    if (error != null){
      out.println(error);
    }

  %>
  <form action="login" method="get">

    Login: <input type="text" name="login"/>
    Hasło: <input type="text" name="haslo"/>
    <input type="submit" value="Zaloguj"/>
  </form>
  </body>
  </body>
</html>
