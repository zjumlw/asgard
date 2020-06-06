<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-15
  Time: 上午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<h1>Welcome to The Sipttr</h1>
<a href="<c:url value="/spittles"/>">Spittles</a> |
<a href="<c:url value="/spitter/register"/>">Register</a>
</body>
</html>
