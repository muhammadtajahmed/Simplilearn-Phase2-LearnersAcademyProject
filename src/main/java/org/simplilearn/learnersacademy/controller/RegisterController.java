package org.simplilearn.learnersacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.learnersacademy.services.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    UserService service=new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        service.createUser(username,password);
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
