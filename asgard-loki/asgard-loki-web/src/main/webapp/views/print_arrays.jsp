<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Print Arrays</title>
</head>
<body>
<jsp:scriptlet>
  String info[] = new String[3];
  info[0] = "mi";
  info[1] = "xiaoim";
  info[2] = "beijing";
  pageContext.setAttribute("info", info);
</jsp:scriptlet>

<h3>all:
  <c:forEach items="${info}" var="item">
    ${item},
  </c:forEach>
</h3>
<h3>
  <c:forEach items="${info}" var="item" step="2">
    ${item},
  </c:forEach>
</h3>
<h3>
  <c:forEach items="${info}" var="item" begin="0" end="1">
    ${item},
  </c:forEach>
</h3>

<%
  Map<String, String> map = new HashMap<>();
  map.put("1", "One");
  map.put("2", "Two");
  pageContext.setAttribute("map", map);
%>
<c:forEach items="${pageScope.map}" var="item">
  ${item.key} --> ${item.value}
</c:forEach>

</h3>
</body>
</html>
