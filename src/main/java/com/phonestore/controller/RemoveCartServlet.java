package com.phonestore.controller;

import com.phonestore.model.Item;
import com.phonestore.model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoveCartServlet", urlPatterns = "/removecart")
public class RemoveCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("pid"));
        Order order = (Order) session.getAttribute("order");
        List<Item> list = order.getItems();
        for (int i=0; i < list.size();i++){
            if(list.get(i).getProduct().getId() == id)
                list.remove(i);
        }
        order.setItems(list);
        session.setAttribute("order",order);
        request.getRequestDispatcher("cart.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
