<%--
    用户欢迎页面
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
</head>
<style>
    body{
        background:url("image/background.jpg");
        background-size: cover;
    }
    #div{
        background-color: rgba(254, 255, 249, 0.27);
    }
</style>
<body>

<div class="container panel panel-default" id="div" style="width: 450px; margin-top: 200px;">

    <c:if test="${!empty sessionScope.user}">
        <div>
            <h3>欢迎你！<a href="${pageContext.request.contextPath}/userLoginSuccess.jsp">${sessionScope.user.name}</a></h3>
        </div>
    </c:if>

    <c:if test="${!empty sessionScope.admin}">
        <div>
            <h3>欢迎你！<a href="${pageContext.request.contextPath}/userListServlet">${sessionScope.admin.adminame}</a></h3>
        </div>
    </c:if>

    <div style="margin-left: 75px"><p class="text-danger">${requestScope.login_msg}</p></div>

</div>





</body>
</html>
