<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-18
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"></head>
<body>
<%@include file="header.html"%>
<jsp:include page="<%=bodyfile%>"/>
<%@include file="footer.html"%>
</body>
</html>
