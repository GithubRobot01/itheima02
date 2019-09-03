<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        window.onload=function () {
            document.getElementById("form").onsubmit=function () {
                return checkAge()&&checkQq()&&checkEmail();
            }
            document.getElementById("age").onblur=checkAge;
            document.getElementById("qq").onblur=checkQq;
            document.getElementById("email").onblur=checkEmail;
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
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post" id="form">

        <%--隐藏域用于提交用户id便于在数据库修改用户信息--%>
        <input type="hidden" value="${user.id}" name="id">

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" value="${user.name}" id="name" name="name" readonly="readonly" placeholder="请输入姓名" />
            <span id="s_name"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='男'}">
                <input type="radio" name="gender" value="男"  checked/>男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender=='女'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女"  checked/>女
            </c:if>
            <span id="s_gender"></span>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
            <span id="s_age"></span>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control" >
                <c:if test="${user.address=='河南'}">
                    <option value="河南" selected>河南</option>
                    <option value="湖北">湖北</option>
                    <option value="北京">北京</option>
                </c:if>
                <c:if test="${user.address=='湖北'}">
                    <option value="河南">河南</option>
                    <option value="湖北" selected>湖北</option>
                    <option value="北京">北京</option>
                </c:if>
                <c:if test="${user.address=='北京'}">
                    <option value="河南">河南</option>
                    <option value="湖北">湖北</option>
                    <option value="北京" selected>北京</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" value="${user.qq}" id="qq" name="qq" placeholder="请输入QQ号码"/>
            <span id="s_qq"></span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" value="${user.email}" id="email" name="email" placeholder="请输入邮箱地址"/>
            <span id="s_email"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>