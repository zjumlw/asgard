<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Redirect</title>
</head>
<body>
<c:redirect url="param.jsp">
  <c:param name="name" value="Mao"/>
  <c:param name="url" value="https://www.xiaomi.cn"/>
</c:redirect>
</body>
</html>
