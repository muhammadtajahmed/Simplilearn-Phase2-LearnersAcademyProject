package org.simplilearn.learnersacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.services.SetService;

@WebServlet("/setsubject")
public class SetSubject extends HttpServlet {

    SetService service=new SetService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int cid=Integer.parseInt(request.getParameter("cid"));
            String subid=request.getParameter("subid");
            service.setSubject(cid,subid);
            RequestDispatcher rd=request.getRequestDispatcher("class.jsp");
            rd.forward(request,response);

    }
}
