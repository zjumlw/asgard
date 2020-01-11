<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Invoke Method</title>
</head>
<body>
<%
  boolean isSessionNew = session.isNew();
%>
<h3>ip address: ${pageContext.request.remoteAddr}</h3>
<h3>session id: ${pageContext.session.id}</h3>
<h3>is session new: <%=isSessionNew%></h3>
</body>
</html>
