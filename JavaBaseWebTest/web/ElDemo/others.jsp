<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/18
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

获取姓名：${param.username}<br>
获取密码：${param.password}<br>
<hr>
获取姓名：${paramValues.username[0]}<br>
获取姓名：${paramValues.password[0]}<br>
获取爱好：${paramValues.hobby[0]}<br>
获取爱好：${paramValues.hobby[1]}<br>


</body>
</html>
