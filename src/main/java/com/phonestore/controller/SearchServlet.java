package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        DAO dao = new DAO();
        List<Product> listProduct = dao.searchByName(txtSearch);
        List<Category> listCategory = dao.getAllCategory();
        Product lastProduct = dao.getLast();

        request.setAttribute("categoryList", listCategory);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("productList", listProduct);
        request.setAttribute("search", txtSearch);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
