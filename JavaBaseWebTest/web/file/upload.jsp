<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/19
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" action="http://localhost:8080/JavaBaseWebTest/uploadServlet">

    用户名：<input type="text" name="username"><br>
    文件：<input type="file" name="photo"><br>
    <input type="submit" value="提交">

</form>

</body>
</html>
