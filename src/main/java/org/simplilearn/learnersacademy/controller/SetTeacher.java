package org.simplilearn.learnersacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.services.SetService;

@WebServlet("/setteacher")
public class SetTeacher extends HttpServlet {
    SetService service=new SetService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String subid=request.getParameter("subid");
                int tid= Integer.parseInt(request.getParameter("tid"));
                service.setTeacher(subid,tid);
                RequestDispatcher rd=request.getRequestDispatcher("subject.jsp");
                rd.forward(request,response);
    }
}