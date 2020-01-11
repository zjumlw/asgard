<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-6
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sum</title>
</head>
<body>
<%!
  private int toInt(String num) {
    return Integer.parseInt(num);
  }
%>
<%
  int num1 = toInt(request.getParameter("num1"));
  int num2 = toInt(request.getParameter("num2"));
%>
<p>
  result: <%=num1+num2%>
</p>
</body>
</html>
