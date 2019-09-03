<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>案例</title>
</head>
<body>
    <%
        User user1=new User();
        user1.setName("zs");
        user1.setAge(22);
        user1.setBirth(new Date());

        User user2=new User();
        user2.setName("ls");
        user2.setAge(23);
        user2.setBirth(new Date());

        User user3=new User();
        user3.setName("ww");
        user3.setAge(24);
        user3.setBirth(new Date());

        List list=new ArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        request.setAttribute("list",list);
    %>

    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>日期</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <%--隔行变色--%>
            <c:if test="${s.count%2==1}">
                <tr bgcolor="red">

            </c:if>
            <c:if test="${s.count%2==0}">
                <tr bgcolor="green">

            </c:if>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <fmt:formatDate value="${user.birth}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
