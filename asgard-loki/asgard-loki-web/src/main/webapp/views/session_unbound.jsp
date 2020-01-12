<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Session Unbound</title>
</head>
<body>
<%
  session.removeAttribute("user");
%>
</body>
</html>
