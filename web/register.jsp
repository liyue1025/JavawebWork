<%--
    用户注册页面
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
    <title>注册</title>

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
                location.href = "${pageContext.request.contextPath}/register.jsp";
            });
            // 返回
            $("#return").click(function () {
                window.history.back();
            });
        })
    </script>
    <style>
        body{
            background:url("image/background3.jpg");
            background-size: cover;
        }
        #div{
            background-color: rgba(254, 255, 249, 0.27);
        }
    </style>
</head>
<body>

<div class="container" style="width: 600px; margin-top: 40px; " id="div">

    <h3 style="text-align: center; margin-bottom: 25px">用户注册</h3>

    <%--注册表单--%>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/registerServlet" method="post">

        <div class="form-group" >
            <label for="input" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input name="username" type="text" class="form-control input-lg" id="input">
            </div>
            <div style="margin-left: 120px; margin-top: 50px; color: red">
                <p><strong>${requestScope.reg_msg2}</strong></p>
            </div>

        </div>

        <div class="form-group" >
            <label for="input0" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input name="password" type="password" class="form-control input-lg" id="input0">
            </div>
        </div>

        <div class="form-group" >
            <label for="input1" class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input name="name" type="text" class="form-control input-lg" id="input1">
            </div>
        </div>

        <div class="form-group">
            <label for="input2" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input name="age" type="number" class="form-control input-lg" id="input2">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
               <select class="form-control input-lg" name="gender">
                   <option value="男">---请选择性别---</option>
                   <option value="男">男</option>
                   <option value="女" >女</option>
               </select>
            </div>
        </div>

        <div class="form-group">
            <label for="input4" class="col-sm-2 control-label">邮箱地址</label>
            <div class="col-sm-10">
                <input name="email" type="email" class="form-control input-lg" id="input4" >
            </div>
        </div>

        <div class="form-group">
            <label for="input5" class="col-sm-2 control-label">籍贯</label>
            <div class="col-sm-10">
                <input name="address" type="text" class="form-control input-lg" id="input5" >
            </div>
        </div>


        <div class="form-group" style="margin-left: 120px">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-primary" type="submit" value="提交"  />
                <input class="btn btn-default" type="reset" value="重置" id="resetting" />
                <input class="btn btn-default" type="button" value="返回" id="return"/>
            </div>
        </div>

        <div style="margin-left: 75px"><p class="text-danger">${requestScope.reg_msg}</p></div>

    </form>


</div>


</body>
</html>
