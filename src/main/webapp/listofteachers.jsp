<%@ page import="org.simplilearn.learnersacademy.entities.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>
<h1 align="center">Teacher List</h1>
<table border ="1" width="500" align="center">
    <tr >
        <th><b>Teacher ID</b></th>
        <th><b>Teacher Name</b></th>
        <th><b>Teacher Age</b></th>
    </tr>
    <%
        List<Teacher> teachers= (List<Teacher>) request.getAttribute("Teacher_List");
        for(Teacher t:teachers){    %>
    <tr>
        <td align="center"><%=t.getTid()%></td>
        <td align="center"><%=t.getTname()%></td>
        <td align="center"><%=t.getAge()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
