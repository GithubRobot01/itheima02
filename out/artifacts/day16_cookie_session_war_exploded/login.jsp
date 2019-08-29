<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        div{
            color: red;
        }
    </style>
    <script>
        window.onload=function () {
            document.getElementById("img").onclick=function () {
                this.src="/day16/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
</head>
<body>
<form action="/day16/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>    <input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode" placeholder="请输入验证码"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/day16/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
    <div><%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error") %></div>

    <div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>
</body>
</html>
