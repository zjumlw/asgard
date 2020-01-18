<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"></head>
<body>
<%@include file="include/header.html"%>
<h2>Your Profile</h2>
<c:out value="${spitter.username}"/><br>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
<%@include file="include/footer.html"%>
</body>
</html>