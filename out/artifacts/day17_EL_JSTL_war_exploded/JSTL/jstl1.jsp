<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%
        ArrayList list=new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);

        request.setAttribute("number",3);
    %>
    <c:if test="${not empty list}">
        list集合不为空
    </c:if>

    <c:if test="${number%2==1}">
        ${requestScope.number}是奇数
    </c:if>

    <c:if test="${number%2==0}">
        ${requestScope.number}是偶数
    </c:if>
</body>
</html>
