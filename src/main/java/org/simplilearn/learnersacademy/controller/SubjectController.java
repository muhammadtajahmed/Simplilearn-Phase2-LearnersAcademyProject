package org.simplilearn.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.services.SaveService;
import org.simplilearn.learnersacademy.services.ShowLists;

@WebServlet("/subject")
public class SubjectController extends HttpServlet {
    ShowLists showLists=new ShowLists();

    SaveService service=new SaveService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects=showLists.showSubjects();
        request.setAttribute("Subjects_List",subjects);
        RequestDispatcher rd=request.getRequestDispatcher("/listofsubjects.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sid=request.getParameter("sid");
            String name=request.getParameter("sname");
            service.createSubject(sid,name);
            RequestDispatcher rd=request.getRequestDispatcher("subject.jsp");
            rd.forward(request,response);
    }
}
