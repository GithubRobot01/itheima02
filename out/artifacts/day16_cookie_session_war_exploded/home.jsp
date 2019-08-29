<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    boolean flag=false;

    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
    String format = sdf.format(date);

    Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length!=0){
        for (Cookie cookie : cookies) {
            String name=cookie.getName();

            //判断是否为第一次访问
            if("lastTime".equals(name)){
                flag=true;
                //URL编码
                format= URLEncoder.encode(format,"utf-8");
                cookie.setValue(format);
                cookie.setMaxAge(60);
                response.addCookie(cookie);
                String value = cookie.getValue();

                //URL解码
                value= URLDecoder.decode(value,"utf-8");
%>

                <h1>欢迎回来，您上次访问时间为:<%=value%></h1>


<%
                break;
            }
        }
    }

    if (cookies==null||cookies.length==0||flag==false){
        format= URLEncoder.encode(format,"utf-8");
        Cookie cookie=new Cookie("lastTime",format);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
%>
        <h1>欢迎您首次来到本网站!</h1>
<%
    }
%>

<input type="text">
</body>
</html>
