<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-2
  Time: 上午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="will" uri="will_tag" %>
<html>
<head>
  <title>Present Tag</title>
</head>
<body>
<%
  String scope = "session";
  session.setAttribute("username", "MaoMao");
%>
<will:present name="username" scope="<%=scope%>">
  <h2><%=scope%> has attribute: ${sessionScope.username}</h2>
</will:present>
<will:present name="allusers" scope="request">
  <h2>request has attribute: ${requestScope.allusers}</h2>
</will:present>
</body>
</html>
