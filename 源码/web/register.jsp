<%--
  Created by IntelliJ IDEA.
  User: 参与活动
  Date: 2022/10/4
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<div style="color:#ff0000"><%=request.getAttribute("error")%></div>
<a href="login.jsp">login</a>
<br>
<form method="post" action="/untitled_war_exploded/register">
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    <input type="submit" value="register">
</form>
</body>
</html>
