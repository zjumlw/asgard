<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-31
  Time: 上午2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Get Param Demo</title>
</head>
<body>
<h3>internal: <%=request.getParameter("cat")%></h3>
<h3>etl: ${param.cat}</h3>
</body>
</html>
