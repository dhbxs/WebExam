<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 下午 6:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigationBar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="club.dhbxs.beans.Root" %>
<html>
<head>
    <title>图书馆后台管理系统</title>
</head>
<%
    Root root = (Root) request.getSession().getAttribute("root");

%>
<body>
<div class="page-header" align="center">
    <h1>图书馆后台管理系统
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
    <h2>欢迎<%=root.getrName()%>
    </h2>
</div>

<div align="center">
    <form action="${baseUrl}/BorrowServlet" method="post" style="width: 80%">
        <table class="table table-hover">
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
            <c:forEach items="${books}" var="books">
                <tr>
                    <td align="middle" style="vertical-align: middle!important;">${books.bName}</td>
                    <td align="middle" style="vertical-align: middle!important;">${books.bAuthor}</td>
                    <td align="middle" style="vertical-align: middle!important;">${books.bPress}</td>
                    <td align="middle" style="vertical-align: middle!important;">
                        <img height="150px" width="100px" src="${books.bImg}"/>
                    </td>
                    <td align="middle" style="vertical-align: middle!important;">${books.bNumber}</td>
                    <td align="middle" style="vertical-align: middle!important;">${books.bBorrow}</td>
                    <td align="middle" style="vertical-align: middle!important;">
                        <a class="btn btn-default"
                           href="${baseUrl}/AdminServlet?action=outStock&bId=${books.bId}"
                           role="button">出库
                        </a>
                        <a class="btn btn-default"
                           href="${baseUrl}/QueryBooksServlet?action=searchBooksById&bId=${books.bId}"
                           role="button">修改
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</body>
</html>
