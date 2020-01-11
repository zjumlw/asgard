<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Get Attribute Demo</title>
</head>
<body>
<%
  pageContext.setAttribute("color", "black");
  request.setAttribute("color", "green");
  session.setAttribute("color", "blue");
  application.setAttribute("color", "white");
%>
<h1>page: ${pageScope.color}</h1>
<h2>request: ${requestScope.color}</h2>
<h3>session: ${sessionScope.color}</h3>
<h4>applicationo: ${applicationScope.color}</h4>
</body>
</html>
