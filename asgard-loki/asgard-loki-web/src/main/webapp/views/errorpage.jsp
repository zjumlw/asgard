<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-6
  Time: 上午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
  <title>ErrorPage</title>
</head>
<body>
<p>
  ERROR: <% exception.printStackTrace(new PrintWriter(out));%>
</p>

</body>
</html>
