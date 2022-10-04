<%@ page import="java.util.List" %>
<%@ page import="vote.service.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
welcome,user <%=session.getAttribute("username")%>
<%
    List<User> users = (List<User>)request.getAttribute("user");
%>
<input type="button" value="add" id="insert">
<hr>
    <table width=70% align="center" border="1" cellpadding="0">
        <center>
        <tr >
            <th>id</th>
            <th>name</th>
            <th>gender</th>
            <th>age</th>
            <th>address</th>
            <th>department</th>
            <th>operation</th>
        </tr>
        <%
            for (User user : users) {
                %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getGender()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getAddress()%></td>
            <td><%=user.getDepartment()%></td>
            <td>
                <a href="/untitled_war_exploded/selectServlet?id=<%=user.getId()%>" >update</a>
                <a href="/untitled_war_exploded/deleteServlet?id=<%=user.getId()%>"> delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </center>
    </table>
</body>
</html>
<script>
    document.getElementById("insert").onclick=function (){
        location.href="insert.jsp";
    }
</script>
