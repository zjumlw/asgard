<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-1
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Param Value Demo</title>
</head>
<body>
<c:if test="${paramValues.inst[0] == null}">
  <h3>没有参数</h3>
</c:if>
<c:if test="${paramValues.inst[0] != null}">
  <h3>第一个参数： ${paramValues.inst[0]}</h3>
</c:if>
<c:if test="${paramValues.inst[1] != null}">
  <h3>第二个参数： ${paramValues.inst[1]}</h3>
</c:if>
<c:if test="${paramValues.inst[2] != null}">
  <h3>第三个参数： ${paramValues.inst[2]}</h3>
</c:if>
</body>
</html>
