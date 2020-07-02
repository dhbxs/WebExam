<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 下午 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navigationBar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<div class="page-header" align="center">
    <h1>搜索详情
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
</div>
<div align="center">
<table class="table table-hover" style="width: 80%">
    <thead>
    <tr>
        <td align="middle">书名</td>
        <td align="middle">作者</td>
        <td align="middle">出版社</td>
        <td align="middle">封面</td>
        <td align="middle">库存数量（本）</td>
        <td align="middle">已借阅（本）</td>
        <td align="middle">操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${searchbook}" var="searchbook">
        <tr>
            <td align="middle" style="vertical-align: middle!important;">${searchbook.bName}</td>
            <td align="middle" style="vertical-align: middle!important;">${searchbook.bAuthor}</td>
            <td align="middle" style="vertical-align: middle!important;">${searchbook.bPress}</td>
            <td align="middle" style="vertical-align: middle!important;">
                <img height="150px" width="100px" src="${searchbook.bImg}"/>
            </td>
            <td align="middle" style="vertical-align: middle!important;">${searchbook.bNumber}</td>
            <td align="middle" style="vertical-align: middle!important;">${searchbook.bBorrow}</td>
            <td align="middle" style="vertical-align: middle!important;">
                <a class="btn btn-default"
                   href="../../BorrowServlet?action=borrow&bId=${searchbook.bId}"
                   role="button">借阅
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
