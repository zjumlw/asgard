<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-1
  Time: 下午6:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Print Collection</title>
</head>
<body>
<%
  List<String> all = new ArrayList();
  all.add("mao");
  all.add("beijing");
  all.add("car");
  request.setAttribute("list", all);
%>
<h3>first: ${list[0]}</h3>
<h3>second: ${list[1]}</h3>
<h3>third: ${list[2]}</h3>
</body>
</html>
