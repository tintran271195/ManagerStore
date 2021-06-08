package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product product = dao.getProductById(id);
        List<Category> listCategory = dao.getAllCategory();
        Product lastProduct = dao.getLast();

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("productDetail", product);
        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
