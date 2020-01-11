<%@ page import="com.will.asgard.common.core.model.vo.DeptVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dept List</title>
</head>
<body>
<%
  List<DeptVO> all = (List<DeptVO>) request.getAttribute("alldept");
  if (all != null) {
%>
<table border="1" width="90">
  <tr>
    <td>dept no</td>
    <td>dept name</td>
    <td>dept location</td>
  </tr>

<%
    Iterator iterator = all.iterator();
    while (iterator.hasNext()) {
        pageContext.setAttribute("dept", iterator.next());
%>
  <tr>
    <td>${dept.number}</td>
    <td>${dept.name}</td>
    <td>${dept.location}</td>
  </tr>
<%
    }
%>
</table>
<%
  }
%>

</body>
</html>
