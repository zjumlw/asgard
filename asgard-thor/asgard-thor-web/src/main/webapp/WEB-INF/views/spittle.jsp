<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-15
  Time: 下午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Spittles</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"></head>
<body>
<div class="spittleView">
  <div class="spittleMessage">
    <c:out value="${spittle.message}"/>
  </div>
  <div>
    <span class="spittleTime"><c:out value="${spittle.time}"/></span>
  </div>
</div>
</body>
</html>
