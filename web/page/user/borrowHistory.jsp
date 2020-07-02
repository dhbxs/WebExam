<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 上午 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="club.dhbxs.beans.User" %>
<%@include file="navigationBar.jsp" %>
<html>
<head>
    <title>借阅历史</title>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<div class="page-header" align="center">
    <h1><%=user.getuName()%>的借阅历史
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
</div>
<div align="center">
    <form action="${baseUrl}/" method="post" style="width: 80%">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>借阅日期</td>
                <td>还书日期</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${history}" var="history">
                <tr>
                    <td style="vertical-align: middle!important;">${history.bName}</td>
                    <td style="vertical-align: middle!important;">${history.bAuthor}</td>
                    <td style="vertical-align: middle!important;">${history.bBdate}</td>
                    <td style="vertical-align: middle!important;">${history.bRdate}</td>
                    <td style="vertical-align: middle!important;">${history.bState}</td>
                    <td style="vertical-align: middle!important;">
                        <a class="btn btn-default"
                           href="${baseUrl}/BorrowServlet?action=redecorate&borrowId=${history.borrowId}"
                           role="button">续借
                        </a>
                        <a class="btn btn-default"
                           href="${baseUrl}/BorrowServlet?action=returnBook&borrowId=${history.borrowId}"
                           role="button">还书
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
