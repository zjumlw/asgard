<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-5
  Time: 下午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Source</title>
</head>
<body>
<p>
  This is output of source.jsp before forward.
</p>
<jsp:forward page="target.jsp">
  <jsp:param name="username" value="jack"/>
</jsp:forward>
<p>
  This is output of source.jsp after forward.
</p>
</body>
</html>
