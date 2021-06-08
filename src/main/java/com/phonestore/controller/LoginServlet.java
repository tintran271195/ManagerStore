package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        DAO dao = new DAO();
        Account account = dao.login(username, password);
        if (account == null) {

            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("home").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        DAO dao = new DAO();
        Account account = dao.login(username, password);
        if (account == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc",account);
            session.setMaxInactiveInterval(300);
            request.getRequestDispatcher("home").forward(request, response);
        }
    }
}
