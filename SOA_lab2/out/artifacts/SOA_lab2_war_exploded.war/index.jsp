<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zosiek
  Date: 13.03.19
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>POZDRAWIACZ</title>
  </head>
  <body>
  <h1>POZDRAWIAM KAROLINĘ STĘPIEŃ</h1>

  <%
    Date tmp = new Date();
    out.print("<h2> Dokładnie o godzinie: " + tmp.toString() + "</h2>");
  %>

  <h2>Zawsze dobrze pozdrawiać Karo!</h2>

  </body>
</html>
