
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <form action="/untitled_war_exploded/insertServlet" method="post">
        id：<input type="text" name="id"><hr>
        name：<input type="text" name="name"><hr>
        gender：<input type="text" name="gender"><hr>
        age：<input type="text" name="age"><hr>
        address：<input type="text" name="address"><hr>
        department：<input type="text" name="department"><hr>
        <input type="submit" value="submit">
    </form>
</body>
</html>
