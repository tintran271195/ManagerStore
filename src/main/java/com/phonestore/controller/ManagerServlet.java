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

@WebServlet(name = "ManagerServlet", urlPatterns = "/managerproduct")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        int id = account.getId();
        DAO dao = new DAO();
        List<Product> listProduct = dao.getProductBySellId(id);
        List<Category> listCategory = dao.getAllCategory();

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("managerproduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
