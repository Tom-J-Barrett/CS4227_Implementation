<%--
  Created by IntelliJ IDEA.
  User: tom13
  Date: 11/10/2017
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="engine" class="CS4227.GreetingEngine" scope="session"/>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  Hello <b><%= request.getMethod() %></b>!
  </body>
</html>
