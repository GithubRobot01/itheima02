<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  index.jsp
  <% System.out.println("index.jsp...");%>
  <%
    request.getRequestDispatcher("/hello.jsp").forward(request,response);
  %>
  </body>
</html>
