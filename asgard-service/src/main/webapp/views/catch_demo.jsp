<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Catch Demo</title>
</head>
<body>
<c:catch var="errmsg">
  <%
    int n = 10/0;
  %>
</c:catch>
<h3>errmsg: ${errmsg}</h3>
</body>
</html>
