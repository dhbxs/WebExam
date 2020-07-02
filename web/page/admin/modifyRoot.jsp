<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/7/2
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navigationBar.jsp" %>
<%@ page import="club.dhbxs.beans.Root" %>
<html>
<head>
    <title>修改管理员信息</title>
</head>
<%
    Root root = (Root) session.getAttribute("root");
%>
<body>
<div class="page-header" align="center">
    <h1>管理员账户信息
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
</div>
<br>
<div align="center">
    <form name="adminAdd" action="${baseUrl}/AdminServlet?action=modifyRoot" method="post"
          style="width: 70%">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">用户名</span>
            <input type="text" class="form-control" value="<%=root.getrName()%>"
                   aria-describedby="basic-addon1" name="rName"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="password" class="form-control" name="rPassword" value="<%=root.getrPassword()%>"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">邮箱地址</span>
            <input type="test" class="form-control" name="rEmail" value="<%=root.getrEmail()%>"/>
        </div>
        <br>
        <p align="right">
            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    style="width: fit-content; height: fit-content">修改
            </button>
        </p>
    </form>
</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
