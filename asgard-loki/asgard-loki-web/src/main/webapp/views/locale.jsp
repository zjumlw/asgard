<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Locale</title>
</head>
<body>
<%
  pageContext.setAttribute("date", new Date());
%>
<h3>中文显示日期：
  <fmt:setLocale value="zh_CN"/>
  <fmt:formatDate value="${date}"/>
</h3>

<h3>英文显示日期：
  <fmt:setLocale value="en_US"/>
  <fmt:formatDate value="${date}"/>
</h3>

</body>
</html>
