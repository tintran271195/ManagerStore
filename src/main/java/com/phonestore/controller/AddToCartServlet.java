package com.phonestore.controller;

import com.phonestore.dao.DAO;
import com.phonestore.model.Item;
import com.phonestore.model.Order;
import com.phonestore.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addtocart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        DAO dao = new DAO();
        if (request.getParameter("pid") != null) {
            id = Integer.parseInt(request.getParameter("pid"));
            Product product = dao.getProductById(id);
            if (request.getParameter("quantity") != null) {
                quantity = Integer.parseInt(request.getParameter("quantity"));
            }
            HttpSession session = request.getSession();
            if (session.getAttribute("order") == null) {
                Order order = new Order();
                List<Item> listItems = new ArrayList<>();
                Item item = new Item();
                item.setQuantity(quantity);
                item.setProduct(product);
                item.setPrice(product.getPrice());
                listItems.add(item);
                order.setItems(listItems);
                session.setAttribute("order", order);
            } else {
                Order order = (Order) session.getAttribute("order");
                List<Item> listItem = order.getItems();
                boolean check = false;
                for (Item item : listItem
                ) {
                    if (item.getProduct().getId() == product.getId()) {
                        item.setQuantity(item.getQuantity() + quantity);
                        check = true;
                    }
                }
                if (check == false) {
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setProduct(product);
                    item.setPrice(product.getPrice());
                    listItem.add(item);
                }
                session.setAttribute("order", order);
            }
        }
        response.sendRedirect("home");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
