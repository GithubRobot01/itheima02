<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El获取数据</title>
</head>
<body>
    <%
        User user=new User();
        user.setName("wqs");
        user.setAge(23);
        user.setBirth(new Date());
        request.setAttribute("user",user);

        List list=new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(user);
        request.setAttribute("list",list);

        Map map=new HashMap();
        map.put("gender","female");
        map.put("grade","SSS");
        map.put("number","201520201");
        map.put("user",user);
        request.setAttribute("map",map);
    %>

    ${requestScope.user.name}<br>
    ${user.age}<br>
    ${user.birth}<br>
    ${user.birth.month}<br>
    ${user.birthStr}<br>

    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list["3"].name}<br>

    ${map}<br>
    ${map.gender}<br>
    ${map.grade}<br>
    ${map["number"]}<br>
    ${map.user.name}<br>


</body>
</html>
