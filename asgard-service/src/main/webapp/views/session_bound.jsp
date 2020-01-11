<%@ page import="com.will.asgard.service.listener.LoginUser" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Session Bound</title>
</head>
<body>
<%
  LoginUser user = new LoginUser();
  user.setName("MAO");
  session.setAttribute("user", user);
%>
</body>
</html>
