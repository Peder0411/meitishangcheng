<%--
  Created by IntelliJ IDEA.
  User: 参与活动
  Date: 2022/10/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div style="color:#ff0000"><%=request.getAttribute("error")%></div>
    <a href="register.jsp">register</a>
    <br>
    <form method="post" action="/untitled_war_exploded/login">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="login">
    </form>
</body>
</html>
