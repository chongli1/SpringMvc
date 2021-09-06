<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/3
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
        <div>
            <%--<form action="/api/admin/yuansheng" method="post">--%>
            <%--<form action="/api/admin/modelAndView" method="post">--%>
            <%--<form action="/api/admin/model" method="post">--%>
            <%--<form action="/api/admin/modelMap" method="post">--%>
            <form action="/api/admin/map" method="post">
               用户名： <input type="text" name="adminName"><br>
               密码：  <input type="text" name="adminPwd"><br>
                <input type="submit" value="登录">
            </form>
        </div>
</body>
</html>
