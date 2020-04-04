<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/18
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%=pageContext.getRequest().getScheme() %>

<%
    pageContext.setAttribute("req",request);
%>

<hr/>
1. 协议：${req.scheme}<br/>
2. 服务器ip：${pageContext.request.serverPort}<br/>
3. 服务器端口：${pageContext.request.serverPort}<br/>
4. 获取工程路径：${pageContext.request.contextPath}<br/>
5. 获取请求方法：${pageContext.request.method}<br/>
6. 获取客户端ip 地址：${pageContext.request.remoteHost}<br/>
7. 获取会话的id 编号：${pageContext.session.id}<br/>


</body>
</html>
