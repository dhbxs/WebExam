<%--
  Created by IntelliJ IDEA.
  User: 17235
  Date: 2020/6/27
  Time: 下午 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String baseUrl = request.getContextPath();
    pageContext.setAttribute("baseUrl", baseUrl);
%>
<link href="${baseUrl}/css/bootstrap.min.css" rel="stylesheet">
<script src="${baseUrl}/js/jquery-3.5.1.min.js"></script>
<script src="${baseUrl}/js/bootstrap.min.js"></script>