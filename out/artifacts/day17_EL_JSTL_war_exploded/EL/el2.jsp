<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中数据</title>
</head>
<body>
    <%
        request.setAttribute("name","wqs");
        request.setAttribute("age","23");
    %>
    ${requestScope.name}
    ${requestScope.age}
</body>
</html>
