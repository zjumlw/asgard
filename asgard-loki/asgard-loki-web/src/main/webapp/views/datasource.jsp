<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-1
  Time: 下午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>DataSource</title>
</head>
<body>
<%
  String DSNAME = "java:comp/env/jdbc/asgard";
  Context ctx = new InitialContext();
  DataSource ds = (DataSource) ctx.lookup(DSNAME);
  Connection conn = ds.getConnection();
%>
<%=conn%>
<%
  conn.close();
%>
</body>
</html>
