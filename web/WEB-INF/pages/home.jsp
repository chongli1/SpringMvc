<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/3
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台界面</title>
</head>
<body>
    <%--<h1>欢迎！管理员：${sessionScope.adminInfo.adminName}登录！！</h1>--%>
    <h1>欢迎！管理员：${requestScope.adminName}登录！！</h1>
    <h1>您的密码是：${requestScope.adminPwd}</h1>
</body>
</html>
