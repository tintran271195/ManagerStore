package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Account;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product product = dao.getProductById(id);
        List<Category> listCategory = dao.getAllCategory();
        request.setAttribute("productDetail",product);
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(id,name,image,price,title,description,category);
        DAO dao = new DAO();
        dao.editProduct(product);
        response.sendRedirect("managerproduct");
    }
}
