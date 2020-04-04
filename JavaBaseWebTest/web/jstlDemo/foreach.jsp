<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="xupt.edu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/19
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1. 遍历1 到10，输出--%>
<table border="1">
<c:forEach begin="1" end="10" var="i">
<tr>
    <td>${i}</td>
</tr>
</c:forEach>
</table>

<%--遍历Object 数组--%>
<%
request.setAttribute("attr",new String[]{"123456","789654"});
%>
<c:forEach items="${requestScope.attr}" var="item">
${item}<br>
</c:forEach>

<%--遍历Map 集合--%>
<%
    Map<String,Object>map=new HashMap<>();
    map.put("key1","val1");
    map.put("key2","val2");
    map.put("key3","val3");
    request.setAttribute("map",map);
%>

<c:forEach items="${map}" var="entry">
    ${entry.key}=${entry.value}<br>
</c:forEach>

<%--遍历List 集合---list 中存放Student 类，有属性：编号，用户名，密码，年龄，电话信息--%>
<%
    List<Student>list=new ArrayList<>();
    for (int i = 0; i <10 ; i++) {
        list.add(new Student(i,"name"+i,18+i,"phone"+i) );
    }
    request.setAttribute("list",list);
%>
<table border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>手机号</td>
        <td>操作</td>
    </tr>
<c:forEach items="${list}" var="item" varStatus="statu" >
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.age}</td>
        <td>${item.phone}</td>
        <td>${statu.index}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>
