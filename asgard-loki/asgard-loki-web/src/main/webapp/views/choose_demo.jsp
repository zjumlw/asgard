<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Choose Demo</title>
</head>
<body>
<%
  pageContext.setAttribute("num", 10);
%>
<c:choose>
  <c:when test="${num==10}"><h3>num is 10</h3></c:when>
  <c:when test="${num==20}"><h3>num is 20</h3></c:when>
  <c:otherwise><h3>num not know</h3></c:otherwise>
</c:choose>
</body>
</html>
