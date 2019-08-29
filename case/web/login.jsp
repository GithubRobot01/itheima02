<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload=function () {
            document.getElementById("img").onclick=function () {
                this.src="/case/checkCodeServlet?"+new Date().getTime();
            }
        }
    </script>
    <style>
        #name,#pass,#check,#img{
            margin-top: 10px;
            border: 2px solid darkgrey;
        }
        #img{
            margin-left: 10px;
        }
        #btn{
            width: 80px;
            height: 30px;
            margin-left: 130px;
            border: 2px solid darkgrey;
        }
        span{
            color: red;
        }
    </style>
</head>
<body>
<form action="/case/LoginServlet" method="post">
    <label for="name">用户名:</label>
    <input type="text" name="username" id="name" placeholder="请输入用户名">
    <span><%=request.getAttribute("name_error")==null?"":request.getAttribute("name_error")%></span>
    <br>
    <label for="pass">密&nbsp;&nbsp;&nbsp;码:</label>
    <input type="password" name="password" id="pass" placeholder="请输入密码">
    <span><%=request.getAttribute("pass_error")==null?"":request.getAttribute("pass_error")%></span>
    <br>
    <label for="check">验证码:</label>
    <input type="text" name="checkCode" id="check" placeholder="请输入验证码">
    <span><%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")%></span>
    <br>
    <img id="img" src="/case/checkCodeServlet">
    <br>
    <input type="submit" id="btn" value="登录">
</form>
</body>
</html>
