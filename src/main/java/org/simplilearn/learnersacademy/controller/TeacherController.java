package org.simplilearn.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.entities.Teacher;
import org.simplilearn.learnersacademy.services.SaveService;
import org.simplilearn.learnersacademy.services.ShowLists;

@WebServlet("/teacher")
public class TeacherController extends HttpServlet {
    ShowLists showlists=new ShowLists();

    SaveService service=new SaveService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers=showlists.showTeachers();
        request.setAttribute("Teacher_List",teachers);
        RequestDispatcher rd=request.getRequestDispatcher("/listofteachers.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("tname");
        int age= Integer.parseInt(request.getParameter("tage"));
        service.createTeacher(name,age);
        RequestDispatcher rd=request.getRequestDispatcher("teacher.jsp");
        rd.forward(request,response);
    }
}
