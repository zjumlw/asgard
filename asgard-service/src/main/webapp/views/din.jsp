<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-5
  Time: 下午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Din</title>
</head>
<body>
din.jsp is including content.jsp
<%
  request.setAttribute("username","cat");
%>
<jsp:include page="content.jsp"/>
<p>
  din.jsp is doing sth else
</p>
</body>
</html>
