package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerAccountServlet", urlPatterns = "/manageraccount")
public class ManagerAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        List<Account> listAccount = dao.getAllAccount();

        request.setAttribute("listAccount", listAccount);
        request.getRequestDispatcher("manageraccount.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
