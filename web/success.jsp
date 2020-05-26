<%--
    用户修改密码成功页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        p{
            text-align: center;
            font-size: 30px;
        }
        body{
            background:url("image/background3.jpg");
            background-size: cover;
        }
    </style>
</head>

<body>

<div style="margin-top: 100px">
    <p>
        <span><font color="white">${requestScope.msg}成功！</font></span>
        <span class="glyphicon glyphicon-ok" aria-hidden="true" style="color: white"></span>
    </p>

    <p>
    <span id="time" style="color: red">5</span><font color="white">秒之后自动跳转<a href="${pageContext.request.contextPath}/userLogin.jsp">登录</a>页面......</font>
    </p>
</div>

<script>

    // 获取元素对象
    var time = document.getElementById("time");
    var second = 5;

    function fun(){
        second --;
        time.innerHTML = second;
        if(second == 0){
            // 关闭循环计时器
            clearInterval(id);
            location.href = "${pageContext.request.contextPath}/userLogin.jsp";
        }
    }

    // 设置定时器
    var id = setInterval(fun,1000);


</script>


</body>
</html>
