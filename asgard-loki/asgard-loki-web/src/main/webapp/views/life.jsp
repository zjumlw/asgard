<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 20-1-5
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Life</title>
</head>
<body>
<%!
  private int initVar = 0;
  private int serviceVar = 0;
  private int destroyVar = 0;

  @Override
  public void jspInit() {
      initVar++;
      System.out.println("jspInit, initVar: " + initVar);
  }
  @Override
  public void jspDestroy() {
      destroyVar++;
      System.out.println("jspDestroy, destroyVar: " + destroyVar);
  }
%>
<%
  serviceVar++;
  System.out.println("_jspService, serviceVar: " + serviceVar);

  String content1 = "init cnt: " + initVar;
  String content2 = "service cnt: " + serviceVar;
  String content3 = "destroy cnt: " + destroyVar;
%>
<h3><%=content1%></h3>
<h3><%=content2%></h3>
<h3><%=content3%></h3>

</body>
</html>
