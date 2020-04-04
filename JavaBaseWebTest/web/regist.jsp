<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/28
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/JavaBaseWebTest/registServlet" method="post">
    用户名：<input type="text" name="username"><br>
    验证码：<input type="text" style="width: 80px;" name="code">
    <img src="http://localhost:8080/JavaBaseWebTest/kaptcha.jpg" alt="" style="width: 100px; height: 28px;"> <br>
    <input type="submit" value="登录">
</form>



</body>
</html>
