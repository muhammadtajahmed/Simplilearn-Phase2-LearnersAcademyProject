<%@ page import="java.util.List" %>
<%@ page import="org.simplilearn.learnersacademy.entities.Student" %>
<%@ page import="org.simplilearn.learnersacademy.entities.EClass" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1 align="center">Student List</h1>
    <table border ="1" width="500" align="center">
        <tr>
            <th><b>Student Roll No</b></th>
            <th><b>Student Name</b></th>
            <th><b>Class</b></th>
        </tr>
        <%
                List<Student> students= (List<Student>) request.getAttribute("Student_List");
                for(Student s:students){    %>
        <tr>
            <td align="center"><%=s.getRollno()%></td>
            <td align="center"><%=s.getSname()%></td>
            <%EClass eclass=s.getEclass();%>
            <td align="center"><%=eclass.getCname()%></td>
        </tr>
        <%}%>
    </table>

</body>
</html>
