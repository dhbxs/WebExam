<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 上午 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../css.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>navigationBar</title>
</head>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="https://dhbxs.club/">
                <img alt="Brand" src="https://gitee.com/dhbxs/blogImage/raw/master/img/favicon.png" height="18px"
                     width="18px"/>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${baseUrl}/page/user/home.jsp">首页 <span
                        class="sr-only">(current)</span></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${baseUrl}/QueryHistryServlet">借阅历史 <span
                        class="sr-only">(current)</span></a></li>
                <li class="active"><a href="${baseUrl}/SignInServlet?action=signOut">安全退出 <span
                        class="sr-only">(current)</span></a></li>
            </ul>
        </div>
    </div>
</nav>
</html>
