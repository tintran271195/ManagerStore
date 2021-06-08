package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        if (!pass.equals(repass)){
            response.sendRedirect("login.jsp");
        } else {
            DAO dao = new DAO();
            Account account = dao.checkUser(user);
            if(account == null){
                dao.signUp(user,pass);
                response.sendRedirect("home");
            } else {
                response.sendRedirect("login.jsp");
            }
        }
        
    }
}
