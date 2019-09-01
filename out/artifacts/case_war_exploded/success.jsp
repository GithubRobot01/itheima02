<%@ page import="day16.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    out.write("登录成功!"+user.getUsername()+",欢迎您!");
%>
</body>
</html>
