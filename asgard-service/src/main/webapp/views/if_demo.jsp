<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>If Demo</title>
</head>
<body>
<c:if test="${param.ref=='mi'}" var="res1" scope="page">
  <h3>Welcome ${param.ref}</h3>
</c:if>
<c:if test="${10<30}" var="res2">
  <h3>10 less than 30</h3>
</c:if>
</body>
</html>
