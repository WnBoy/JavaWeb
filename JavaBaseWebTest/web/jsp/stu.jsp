<%@ page import="java.util.List" %>
<%@ page import="xupt.edu.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/18
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px blue solid;
        }
    </style>
</head>
<body>

    <h1>学生信息</h1>

<%
    List<Student>list = (List<Student>) request.getAttribute("list");
%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    <% for (Student s: list) {%>
    <tr>
        <td><%=s.getId() %></td>
        <td><%=s.getName() %></td>
        <td><%=s.getAge() %></td>
        <td><%=s.getPhone() %></td>
        <td>添加/删除</td>
    </tr>
   <% }%>

</table>

</body>
</html>
