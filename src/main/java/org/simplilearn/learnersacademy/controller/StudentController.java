package org.simplilearn.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.entities.Student;
import org.simplilearn.learnersacademy.services.SaveService;
import org.simplilearn.learnersacademy.services.ShowLists;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    ShowLists showLists=new ShowLists();
    SaveService service=new SaveService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students= showLists.showStudents();
        request.setAttribute("Student_List",students);
        RequestDispatcher rd=request.getRequestDispatcher("/listofstudents.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int rollno= Integer.parseInt(req.getParameter("rollno"));
            String name=req.getParameter("sname");
            service.createStudent(rollno,name);
            RequestDispatcher rd=req.getRequestDispatcher("student.jsp");
            rd.forward(req,resp);

    }

}
