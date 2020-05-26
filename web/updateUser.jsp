<%--
    修改用户信息
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
    <title>编辑个人信息</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        $(function () {
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
<html>
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

<div class="container" id="div" style="width: 600px; margin-top: 40px">

    <h3 style="text-align: center; margin-bottom: 20px; color: white"><strong>修改个人信息</strong></h3>

    <form class="form-horizontal" action="${pageContext.request.contextPath}/updataUserServlet" method="post">

         <div class="form-group" >
            <label for="input1" class="col-sm-2 control-label" style="color: white">昵称</label>
            <div class="col-sm-10">
                <input name="name" type="text" class="form-control input-lg" id="input1" value="${sessionScope.user.name}">
            </div>
         </div>

        <div class="form-group">
            <label for="input2" class="col-sm-2 control-label" style="color: white">年龄</label>
            <div class="col-sm-10">
                <input name="age" type="number" class="form-control input-lg" id="input2" value="${sessionScope.user.age}">
            </div>
        </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" style="color: white">性别</label>
                <div class="col-sm-10">
                    <%--判断--%>
                    <c:if test="${sessionScope.user.gender == '女'}">
                        <select class="form-control input-lg" name="gender">
                            <option value="男" >男</option>
                            <option value="女" selected>女</option>
                        </select>
                    </c:if>
                    <c:if test="${sessionScope.user.gender == '男'}">
                        <select class="form-control input-lg" name="gender">
                            <option value="男" selected>男</option>
                            <option value="女" >女</option>
                        </select>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label for="input4" class="col-sm-2 control-label" style="color: white">邮箱地址</label>
                <div class="col-sm-10">
                    <input name="email" type="email" class="form-control input-lg" id="input4" value="${sessionScope.user.email}">
                </div>
            </div>

            <div class="form-group">
                <label for="input5" class="col-sm-2 control-label" style="color: white">籍贯</label>
                <div class="col-sm-10">
                    <input name="address" type="text" class="form-control input-lg" id="input5" value="${sessionScope.user.address}">
                </div>
            </div>


            <div class="form-group" style="margin-left: 150px">
                <div class="col-sm-offset-2 col-sm-10">
                    <input class="btn btn-primary" type="submit" value="提交"  />
                    <input class="btn btn-default" type="button" value="返回" id="return"/>
                </div>
            </div>

            <%--隐藏域，将id值传过去--%>
        <input type="hidden" name="id" value="${sessionScope.user.id}">

    </form>
</div>
</body>
</html>
