<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    \${3>4}
    ${3<4}
    <br>
    <h3>算术运算符</h3>
    ${3+4}<br>
    ${3/4}<br>
    ${3 div 4}<br>
    ${3%4}<br>
    ${3 mod 4}<br>

<%
    String s1="abc";
    String s2=null;
    String s3="";
    request.setAttribute("str1",s1);
    request.setAttribute("str2",s2);
    request.setAttribute("str3",s3);
%>
    ${empty str1}
    ${empty str2}
    ${empty str3}
</body>
</html>
