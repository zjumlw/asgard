<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-1
  Time: 下午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="will" uri="will_tag" %>
<html>
<head>
  <title>Date Tag</title>
</head>
<body>
<h1><will:date format="yyyy-MM-dd HH:mm:ss.SSS"/></h1>
<%
  pageContext.setAttribute("fm", "yyyy-MM-dd HH:mm:ss");
%>
<h1><will:date format="${fm}"/></h1>
<%
  String str = "yyyy-MM-dd";
%>
<h1><will:date format="<%=str%>"/></h1>
</body>
</html>
