<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/7/2
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navigationBar.jsp" %>
<html>
<head>
    <title>验证邮箱</title>
</head>
<body>
<div class="page-header" align="center">
    <h1>验证邮箱
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
</div>
<br>
<div align="center">
    <form name="adminAdd" action="${baseUrl}/AdminServlet?action=verifyCaptcha" method="post"
          style="width: 70%">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">验证码</span>
            <input type="text" class="form-control" aria-describedby="basic-addon1" name="captcha"/>
        </div>
        <br>
        <p align="right">
            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    style="width: fit-content; height: fit-content">验证邮箱
            </button>
        </p>
    </form>
</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
