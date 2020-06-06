<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-18
  Time: 上午2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Spittr</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"></head>
<body>
<h1>Register</h1>
<form method="post">
  FirstName:<input type="text" name="firstName" id="firstName"/><br/>
  LastName:<input type="text" name="lastName" id="lastName"/><br/>
  Username:<input type="text" name="username" id="username"/><br/>
  Password:<input type="password" name="password" id="password"/><br/>
  <input type="submit" value="Register">
</form>
<%--<sf:form method="post" modelAttribute="spitter">--%>
<%--  <sf:label path="firstName" cssErrorClass="error">FirstName: </sf:label>--%>
<%--  <sf:input path="firstName" cssErrorClass="error"/><br/>--%>
<%--  LastName: <sf:input path="lastName"/><br/>--%>
<%--  Email: <sf:input path="email" type="email"/><br/>--%>
<%--  Username: <sf:input path="username"/><br/>--%>
<%--  Password: <sf:password path="password"/><br/>--%>
<%--  <input type="submit" value="Register">--%>
<%--</sf:form>--%>
</body>
</html>
