<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/2
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>最传统的 form 表单传参</title>
</head>
<body>
    <div>
        <form action="/api/admin/regForm" method="post">
            用户名：<input type="text" name="adminName"><br>
            密码：<input type="text" name="adminPwd"><br>
            <input type="submit" value="注册"><br>
        </form>
    </div>
</body>
</html>
