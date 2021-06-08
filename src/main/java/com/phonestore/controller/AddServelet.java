package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddServelt", value = "/add")
public class AddServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int sellID = account.getId();
        Product product = new Product(name,image,price,title,description,category, sellID);
        DAO dao = new DAO();
        dao.insertProduct(product);
        response.sendRedirect("managerproduct");
    }
}
