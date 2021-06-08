package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAccountServlet", value = "/editaccount")
public class EditAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("aid");
        DAO dao = new DAO();
        Account account = dao.getAccountById(id);
        request.setAttribute("accountDetail",account);
        request.getRequestDispatcher("editaccount.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int isSell = Integer.parseInt(request.getParameter("isSell"));
        int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
        DAO dao = new DAO();
        dao.editAccount(isSell,isAdmin,id);
        response.sendRedirect("manageraccount");
}
}
