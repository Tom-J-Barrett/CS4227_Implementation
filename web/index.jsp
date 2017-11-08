<%@ page import="middleware.ProcessHttpRequest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <b><%ProcessHttpRequest http = new ProcessHttpRequest(request); %></b>
  This is your response: <b><%= http.getResponse() %></b>!
  </body>
</html>
