<%--
    用户登录成功页面
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
    <title>个人信息</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<style>
    body{
        background:url("image/img1.jpg");
        background-size: cover;
    }
    #head{
        width: 100px;
    }
</style>
<body>

<%--导航条--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/userLoginSuccess.jsp">主页</a>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.user.name} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/updatePassword.jsp">修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/updateUser.jsp">编辑个人信息</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logoffServlet">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="container">

    <div style=" margin-top: 100px; color: white"><h1>欢迎你，${sessionScope.user.name}</h1></div>

    <div style="margin-top: 100px; padding: 10px">
        <div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object img-rounded" id="head" src="image/head.jpg" >
                </a>
            </div>
            <div class="media-body">
                <div style="margin-top: 15px; margin-left: 15px">
                    <h4 class="media-heading" style="color:white;"><strong>${sessionScope.user.name}</strong></h4>
                </div>
                <div style="margin-top: 30px; margin-left: 15px">
                    <h5 style="color: white">二营长，你他娘的意大利炮呢？！</h5>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>
