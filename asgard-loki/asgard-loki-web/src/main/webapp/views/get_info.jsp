<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-29
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>GetInfo</title>
</head>
<body>
<h2>session attribute: <%=session.getAttribute("username")%></h2>
<h2>request attribute: <%=request.getAttribute("info")%></h2>
<h2>application attribute: <%=application.getAttribute("app")%></h2>
</body>
</html>
