<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Import Param</title>
</head>
<body>
<c:import url="param.jsp" charEncoding="utf-8">
  <c:param name="name" value="Mao"/>
  <c:param name="url" value="https://www.xiaomi.cn"/>
</c:import>
</body>
</html>
