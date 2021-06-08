package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        DAO dao = new DAO();
        List<Product> listProduct = dao.getAllProduct();
        List<Category> listCategory = dao.getAllCategory();
        Product lastProduct = dao.getLast();
        //b2: set data to jsp
        request.setAttribute("categoryList", listCategory);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("productList", listProduct);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
        DAO dao = new DAO();
        List<Product> listProduct = dao.getAllProduct();
        List<Category> listCategory = dao.getAllCategory();
        Product lastProduct = dao.getLast();
        //b2: set data to jsp
        request.setAttribute("categoryList", listCategory);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("productList", listProduct);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
