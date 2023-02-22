package org.simplilearn.learnersacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.services.SetService;

@WebServlet("/setclass")
public class SetClass extends HttpServlet {

    SetService service=new SetService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int rollno= Integer.parseInt(request.getParameter("rollno"));
            int cid=Integer.parseInt(request.getParameter("cid"));
            service.setClass(rollno,cid);
            RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
            rd.forward(request,response);
    }
}
