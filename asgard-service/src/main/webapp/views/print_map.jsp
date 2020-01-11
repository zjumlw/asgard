<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-1
  Time: 下午6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Print map</title>
</head>
<body>
<%
  Map<String, String> map = new HashMap<>();
  map.put("city", "BeiJing");
  map.put("name", "MLW");
  map.put("year", "2020");
  request.setAttribute("map", map);
%>
<h3>city: ${map["city"]}</h3>
<h3>year: ${map.year}</h3>
<h3>name: ${map["name"]}</h3>
</body>
</html>
