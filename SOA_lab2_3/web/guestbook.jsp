<%@ page import="java.util.Vector" %>
<%@ page import="notDefault.GuestData" %>
<%--
  Created by IntelliJ IDEA.
  User: zosiek
  Date: 20.03.19
  Time: 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Księga gości</title>
</head>
<body>
<p>Please submit your feedback</p>
<form action="guestbook" method="get">

    Your name: <input type="text" name="name"/>
    <br/>
    Your email: <input type="text" name="email"/>
    <br/>
    Feedback: <input type="text" name="feedback"/>
    <br/>
    <input type="submit" value="Submit"/>

</form>

<%
    Vector<GuestData> guests = (Vector<GuestData>) request.getAttribute("guests");
    if (guests != null) {
        for (GuestData guest : guests) {
            out.print("<b>" + guest.name + "</b>" + " (" + guest.email + ") says:");
            out.print("<br/>");
            out.print(guest.feedback);
            out.print("<br/>");
            out.print("<br/>");
        }
    }

%>

</body>
</html>
