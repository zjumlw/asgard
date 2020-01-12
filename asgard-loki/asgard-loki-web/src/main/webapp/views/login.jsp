<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: will
  Date: 19-12-29
  Time: 下午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<script language="JavaScript">
  function validate(f) {
      if (!(/^\w{5,15}$/.test(f.userid.value))) {
          alert("user id must be 5-15 characters");
          f.userid.focus();
          return false;
      }
      if (!(/^\w{5,15}$/.test(f.userpass.value))) {
          alert("password must be 5-15 characters");
          f.userpass.focus();
          return false;
      }
      return true;
  }
</script>
<body>
<h2>用户登录程序</h2>
<%
  List<String> info = (List<String>) request.getAttribute("info");
  if (info != null) {
    Iterator<String> it = info.iterator();
    while (it.hasNext()) {
%>
      <h4><%=it.next()%></h4>
<%
    }
  }
%>

<form action="/asgard/loki/loginServlet" method="post" onsubmit="return validate(this)">
  账号: <input type="text" name="userid"><br>
  密码: <input type="password" name="userpass"><br>
  <input type="submit" value="登录">
  <input type="reset" value="重置">
</form>

</body>
</html>
