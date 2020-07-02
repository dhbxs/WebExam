<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 上午 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navigationBar.jsp" %>
<%@ page import="club.dhbxs.beans.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>图书借阅系统</title>
</head>
<%
    User user = (User) request.getSession().getAttribute("user");
    Integer hitsCount =
            (Integer) application.getAttribute("hitCounter");
    if (hitsCount == null || hitsCount == 0) {
        hitsCount = 1;
    } else {
        hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<body>
<div class="page-header" align="center">
    <h1>馆藏图书信息
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
    <h2>欢迎<%=user.getuName()%>
    </h2>
</div>

<div align="center">
    <form action="${baseUrl}/QueryBooksServlet?action=searchBooksByName" method="post" style="width: 80%">
        <div class="col-lg-6">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="输入书名检索" id="search" name="search">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="submit">检索</button>
                </span>
            </div><!-- /input-group -->
        </div>
    </form>
    <br>
    <br>
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
                           href="../../BorrowServlet?action=borrow&bId=${books.bId}"
                           role="button">借阅
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
<footer style="align-self: center">
    <div class="text-center py-3">
        <div>
            <a href="https://dhbxs.club" target="_blank" rel="nofollow noopener">
                <span>我的个人博客</span></a>
        </div>
        <div>
            您是第<%=hitsCount %>个访问用户
        </div>
    </div>
</footer>
</html>
