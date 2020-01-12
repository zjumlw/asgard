<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-2
  Time: 上午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hello JSTL</title>
</head>
<body>
<h3><c:out value="Hello JSTL"></c:out> </h3>

<%
  pageContext.setAttribute("info", "<www.xiaomi.cn>");
%>
<h3>yes: <c:out value="${info}"/></h3>
<h3>yes escape true: <c:out value="${info}" escapeXml="true"/></h3>
<h3>yes escape false: <c:out value="${info}" escapeXml="false"/></h3>
<h3>no: <c:out value="${ref}" default="no such thing"/> </h3>
<h3>no: <c:out value="${ref}">
  No Such Thing
</c:out> </h3>
</body>
</html>
