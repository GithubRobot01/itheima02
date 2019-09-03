<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload=function () {
            document.getElementById("form").onsubmit=function () {
                return checkName()&&checkAge()&&checkQq()&&checkEmail();
            }
            document.getElementById("name").onblur=checkName;
            document.getElementById("age").onblur=checkAge;
            document.getElementById("qq").onblur=checkQq;
            document.getElementById("email").onblur=checkEmail;
        }

        function checkName() {
            var name = document.getElementById("name").value;
            var reg=/^[\u4e00-\u9fa5]{2,4}$/;
            var flag=reg.test(name);
            var s_name = document.getElementById("s_name");
            if (flag){
                s_name.innerHTML="<font color='green'>名字可用</font>";
            }else {
                s_name.innerHTML="<font color='red'>名字应为2-4位汉字</font>";
            }
            return flag;
        }

        function checkAge() {
            var age = document.getElementById("age").value;
            var reg=/^\d{1,2}$/;
            var s_age = document.getElementById("s_age");
            var flag=reg.test(age);
            if (flag){
                s_age.innerHTML="<font color='green'>年龄输入正确</font>";
            }else {
                s_age.innerHTML="<font color='red'>年龄格式(1-99)</font>";
            }
            return flag;
        }
        function checkQq() {
            var qq = document.getElementById("qq").value;
            var reg=/^\d{8,10}$/;
            var s_qq = document.getElementById("s_qq");
            var flag=reg.test(qq);
            if (flag){
                s_qq.innerHTML="<font color='green'>QQ号码正确</font>";
            }else {
                s_qq.innerHTML="<font color='red'>QQ号码应为8-10位的数字</font>";
            }
            return flag;
        }
        function checkEmail() {
            var email = document.getElementById("email").value;
            var reg=/^\d{8,10}@qq\.com$/;
            var s_email = document.getElementById("s_email");
            var flag=reg.test(email);
            if (flag){
                s_email.innerHTML="<font color='green'>QQ邮箱正确</font>";
            }else {
                s_email.innerHTML="<font color='red'>邮箱格式QQ号码+@qq.com</font>";
            }
            return flag;
        }

    </script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" id="form" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span id="s_name" class="msg"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            <span id="s_age" class="msg"></span>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="河南">河南</option>
                <option value="湖北">湖北</option>
                <option value="北京">北京</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" id="qq" placeholder="请输入QQ号码"/>
            <span id="s_qq" class="msg"></span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
            <span id="s_email" class="msg"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>