package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        HttpSession session = request.getSession();
        String cart = (String) session.getAttribute("cart");

        // If no cart exists, initialize it
        if (cart == null) {
            cart = "";
        }

        // Add the current product to the cart string
        cart += "Product ID: " + productId + ", Name: " + productName + ", Price: &#8377;" + price + "<br>";

        // Save the updated cart in the session
        session.setAttribute("cart", cart);

        // Redirect the user to the orders page (Corder.jsp)
        response.sendRedirect("Corder.jsp");
    }
}
