package org.simplilearn.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.services.SaveService;
import org.simplilearn.learnersacademy.services.ShowLists;

@WebServlet("/class")
public class ClassController extends HttpServlet {
    ShowLists showlists=new ShowLists();

    SaveService service=new SaveService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EClass> classes=showlists.showClasses();
        request.setAttribute("Classes_List",classes);
        RequestDispatcher rd=request.getRequestDispatcher("/listofclasses.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name=request.getParameter("cname");
            service.createClass(name);
            RequestDispatcher rd=request.getRequestDispatcher("class.jsp");
            rd.forward(request,response);
    }
}
