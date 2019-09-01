<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>forEach标签</title>
</head>
<body>

    <%
        List list=new ArrayList();
        list.add("ni");
        list.add("hao");
        list.add("wqs");
        request.setAttribute("list",list);
    %>

    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${s.index} ${i}  ${s.count} <br>
    </c:forEach>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str} <br>
    </c:forEach>
</body>
</html>
