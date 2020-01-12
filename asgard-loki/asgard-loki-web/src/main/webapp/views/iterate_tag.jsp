<%@ taglib prefix="will" uri="will_tag" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-2
  Time: 上午1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Iterate Tag</title>
</head>
<body>
<%
  List<String> all = new ArrayList<>();
  all.add("www.xiaomi.cn");
  all.add("www.mi.com");
  all.add("www.miui.com");
  request.setAttribute("all", all);
%>
<will:present name="all" scope="request">
  <will:iterate id="url" name="all" scope="request">
    <h3>url: ${pageScope.url}</h3>
  </will:iterate>
</will:present>
</body>
</html>
