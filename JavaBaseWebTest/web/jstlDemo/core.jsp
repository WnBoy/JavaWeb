<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/19
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--set标签示例--%>
set设置前：${requestScope.key}<br>
<c:set scope="request" var="key" value="abc"></c:set><br>
set设置后：${requestScope.key}<br>
<%--
ii.<c:if />
if 标签用来做if 判断。
test 属性表示判断的条件（使用EL 表达式输出）
--%>
<c:if test="${12==12}">
    <h2>12==12</h2>
</c:if>
<c:if test="${12!=12}">
    <h2>12!=12</h2>
</c:if>
<br>

<%--
iii.<c:choose> <c:when> <c:otherwise>标签
作用：多路判断。跟switch ... case .... default 非常接近
choose 标签开始选择判断
when 标签表示每一种判断情况
test 属性表示当前这种判断情况的值
otherwise 标签表示剩下的情况
<c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
1、标签里不能使用html 注释，要使用jsp 注释
2、when 标签的父标签一定要是choose 标签
--%>
<c:set scope="request" var="height" value="195"></c:set><br>
<c:choose>
    <%-- 这是html 注释--%>
    <c:when test="${ requestScope.height > 190 }">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${ requestScope.height > 180 }">
        <h2>很高</h2>
    </c:when>
    <c:when test="${ requestScope.height > 170 }">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${requestScope.height > 160}">
                <h3>大于160</h3>
            </c:when>
            <c:when test="${requestScope.height > 150}">
                <h3>大于150</h3>
            </c:when>
            <c:when test="${requestScope.height > 140}">
                <h3>大于140</h3>
            </c:when>
            <c:otherwise>
                其他小于140
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>


</body>
</html>
