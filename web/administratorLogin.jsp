<%--
    管理员页面
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
    <title>管理员登录</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<style>
    body{
        background:url("image/background3.jpg");
        background-size: cover;
    }
    #div{
        background-color: rgba(254, 255, 249, 0.27);
    }
</style>
<body>

<div class="container panel panel-default" id="div" style="width: 450px; margin-top: 200px;">

    <h3 style="text-align: center"><strong>管理员登录</strong></h3>

    <%--登录表单--%>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/adminLoginServlet" method="post">
        <div class="form-group" style="margin-top: 20px">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" placeholder="请输入管理员账号" name="adminame" >
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
            </div>
        </div>
        <div class="form-group" >
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-warning btn-block">登录</button>
                <a class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/userLogin.jsp"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>返回用户登录</a>
            </div>
        </div>

    </form>



    <div style="margin-left: 75px"><p class="text-danger">${requestScope.login_msg}</p></div>

</div>


</body>
</html>
