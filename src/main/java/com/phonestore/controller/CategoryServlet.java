package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String categoryID = request.getParameter("cid");
        // lay category
        DAO dao = new DAO();
        List<Product> listProduct = dao.getProductByCategory(categoryID);
        List<Category> listCategory = dao.getAllCategory();
        Product lastProduct = dao.getLast();


        request.setAttribute("categoryList", listCategory);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("productList", listProduct);
        request.setAttribute("tag", categoryID);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
