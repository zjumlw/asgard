<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Print Attribute Demo 02</title>
</head>
<body>
<%
  request.setAttribute("color", "red");
%>
<h3>${color}</h3>
</body>
</html>
