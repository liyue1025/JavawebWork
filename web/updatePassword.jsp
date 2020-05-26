<%--
    用户修改密码页面
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
    <title>修改密码</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        $(function () {
            // 重置
            $("#resetting").click(function resetting() {
                location.href = "${pageContext.request.contextPath}/updatePassword.jsp";
            });
            // 返回
            $("#return").click(function () {
                window.history.back();
            });
        })
    </script>
    <style>
        body{
            background:url("image/img2.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>

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

<div class="container" style="width: 700px; margin-top: 40px;">

    <h3 style="text-align: center; color: white"><strong>修改密码</strong></h3>

    <form class="form-horizontal" id="form" method="post" action="${pageContext.request.contextPath}/updataPasswordServlet">

         <div class="form-group" style="margin-top: 30px">
            <label for="password" class="col-sm-2 control-label" style="color: white">旧密码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="password" placeholder="请输入旧密码" name="oldPassword">
            </div>
        </div>

            <div class="form-group">
            <label for="np1" class="col-sm-2 control-label" style="color: white">新密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control input-lg" id="np1" placeholder="请输入新密码" name="newPassword1">
            </div>
        </div>

            <div class="form-group">
            <label for="np2" class="col-sm-2 control-label" style="color: white">确认新密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control input-lg" id="np2" placeholder="请输入新密码" name="newPassword2">
            </div>
        </div>

            <div class="form-group" style="margin-left: 170px; margin-top: 20px">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-primary" type="submit" value="提交"  />
                <input class="btn btn-default" type="reset" value="重置" id="resetting" />
                <input class="btn btn-default" type="button" value="返回" id="return"/>
            </div>
        </div>

    </form>

    <div style="margin-left: 130px"><p class="text-danger" style="font-size: 25px" ><strong>${requestScope.up_msg}</strong></p></div>

</div>


</body>
</html>
