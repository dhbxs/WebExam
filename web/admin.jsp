<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/30
  Time: 上午 7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="navigationBar.jsp" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<div class="container" style="width: 300px; height: 500px" align="center">
    <form class="form-signin" method="post" action="SignInServlet?action=rootVerify" id="form">
        <img class="mb-4" src="https://gitee.com/dhbxs/blogImage/raw/master/img/20200630002551.png" alt="" width="130" height="130">
        <h2 class="form-signin-heading">登录后台</h2>
        <label for="inputUserName" class="sr-only">管理员</label>
        <input type="text" id="inputUserName" name="inputUserName" class="form-control" placeholder="用户名" required
               autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="密码"
               required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="btn">登录</button>
        <br>
    </form>
</div>
</body>
</html>
<script>
    $('#btn').bind('click', function () {
        $.ajax({
            type: "post",
            url: "SignInServlet?action=rootVerify",
            data: $("#form").serialize(),//将表单序列化为JSON对象
            dataType: "json",
            success: function (res) {
                if (res.code == -1)
                    alert(res.message);
                else if (res.code == 0) {
                    alert(res.message);
                    location.href = '${baseUrl}/QueryBooksServlet?action=queryAllBooks';
                }
            }
        });

    })
</script>
