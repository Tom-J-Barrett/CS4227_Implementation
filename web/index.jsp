<%@ page import="middleware.ProcessHttpRequest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  Hello <b><%= request.getMethod() %></b>!
  Hello <b><%ProcessHttpRequest http = new ProcessHttpRequest(request); %></b>!
  </body>
</html>
