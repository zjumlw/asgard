<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create Url</title>
</head>
<body>
<c:url value="https://www.baidu.com" var="urlinfo">
  <c:param name="logo" value="mi"/>
</c:url>
<a href="${urlinfo}">new_url</a>
</body>
</html>
