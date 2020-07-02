<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/7/2
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigationBar.jsp" %>
<%@ page import="club.dhbxs.beans.Book" %>
<html>
<head>
    <title>修改图书信息</title>
</head>
<%
    Book info = (Book) request.getSession().getAttribute("modifybook");
%>
<body>
<div class="page-header" align="center">
    <h1>修改馆藏图书信息
        <small>
            <a href="https://dhbxs.club"> dhbxs.club </a>
        </small>
    </h1>
</div>
<br>
<div align="center">
    <form name="adminAdd" action="${baseUrl}/AdminServlet?action=modify&&id=<%=info.getbId()%>" method="post"
          style="width: 70%">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">书名</span>
            <input type="text" class="form-control" value="<%=info.getbName()%>"
                   aria-describedby="basic-addon1" name="bName"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">作者</span>
            <input type="text" class="form-control" name="bAuthor" value="<%=info.getbAuthor()%>"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">出版社</span>
            <input type="test" class="form-control" name="bPress" value="<%=info.getbPress()%>"/>
            <span class="input-group-addon">社</span>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">封面图片</span>
            <input type="text" class="form-control" name="bImg" value="<%=info.getbImg()%>"/>
            <span class="input-group-addon">URL</span>
        </div>
        <br>
        <div align="center" class="input-group">
            <span class="input-group-addon">馆藏数量</span>
            <input type="number" class="form-control" name="bNumber" value="<%=info.getbNumber()%>"/>
            <span class="input-group-addon">本</span>
        </div>
        <br>
        <p align="right">
            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    style="width: fit-content; height: fit-content">立即修改
            </button>
        </p>
    </form>
</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
