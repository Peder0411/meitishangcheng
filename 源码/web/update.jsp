<%@ page import="vote.service.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
    User user = (User) request.getAttribute("user");
%>
<form action="/untitled_war_exploded/updateServlet" method="post">
    id：<input type="text" name="id" value="<%=user.getId()%>"><br>
    name：<input type="text" name="name" value="<%=user.getName()%>"><br>
    gender：<input type="text" name="gender" value="<%=user.getGender()%>"><br>
    age：<input type="text" name="age" value="<%=user.getAge()%>"><br>
    address：<input type="text" name="address" value="<%=user.getAddress()%>"><br>
    department：<input type="text" name="department" value="<%=user.getDepartment()%>"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
