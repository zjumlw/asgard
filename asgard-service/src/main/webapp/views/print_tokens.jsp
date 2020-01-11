<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-3
  Time: 上午1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Print Tokens</title>
</head>
<body>
<%
  String info = "www.xiaomi.cn";
  pageContext.setAttribute("info", info);
%>
<h3>
  <c:forTokens items="${info}" delims="." var="item">
    ${item},
  </c:forTokens>
</h3>
<h3>
  <c:forTokens items="jia::na::da" delims="::" var="each">
    ${each},
  </c:forTokens>
</h3>
</body>
</html>
