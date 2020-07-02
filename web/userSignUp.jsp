<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 上午 7:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="navigationBar.jsp"%>
<html>
<head>
    <title>借阅用户注册</title>
</head>
<body>
<div class="container" style="width: 300px; height: 500px" align="center">
    <form class="form-signin" method="post" action="SignUpServlet">
        <img class="mb-4" src="https://gitee.com/dhbxs/blogImage/raw/master/img/20200630002551.png" alt="" width="130" height="130">
        <h2 class="form-signin-heading">请注册</h2>
        <label for="inputUserName" class="sr-only">用户名</label>
        <input type="text" id="inputUserName" name="inputUserName" class="form-control" placeholder="用户名" required
               autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="密码"
               required>
        <br>
        <label for="inputEmail" class="sr-only">Password</label>
        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="邮箱地址"
               required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        <br>
    </form>
</div>
</body>
</html>
