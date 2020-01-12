<%@ page import="com.will.asgard.common.model.vo.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-2
  Time: 下午11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Set Demo</title>
</head>
<body>
<c:set var="info" value="HelloWorld" scope="request"/>
<h3>value: ${info}</h3>

<%
  request.setAttribute("info", "Mi");
%>
<h3>value: ${info}</h3>

<%
  UserVO userVO = new UserVO();
  request.setAttribute("user", userVO);
%>
<c:set value="Mao" target="${user}" property="name"/>
<h3>property value: ${user.name}</h3>
</body>
</html>
