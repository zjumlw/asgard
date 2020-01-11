<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Request Attribute Remove</title>
</head>
<body>
<%
  request.setAttribute("number", 4);
  request.removeAttribute("number");
%>
</body>
</html>
