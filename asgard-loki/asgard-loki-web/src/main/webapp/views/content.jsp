<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-5
  Time: 下午11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Content</title>
</head>
<body>
<p>
  Output from content.jsp
</p>
etl: ${param.city} <br>
city: <%=request.getParameter("city")%>
</body>
</html>
