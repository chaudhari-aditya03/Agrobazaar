package com.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CustomerDashboard")
public class CustomerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Products - Farming Management System</title>");
        out.println("<link rel='stylesheet' href='css/Customer_Dashboard.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<header>");
        out.println("<h1>Customer Dashboard</h1>");
        out.println("<nav class='nav-container'>");
        out.println("<div class='search-bar'>");
        out.println("<input type='text' placeholder='Search products...' id='search-input'>");
        out.println("<button class='btn' id='search-btn'>Search</button>");
        out.println("</div>");
        out.println("<ul class='nav-links'>");
        out.println("<li><a href='HomePage.jsp'>Home</a></li>");
        out.println("<li><a href='Corder.jsp'>My Orders</a></li>");
        out.println("<li><a href='CAccount.jsp'>My Account</a></li>");
        out.println("<li><a href='About.jsp'>About Us</a></li>");
        out.println("<li><a href='ContactUs.jsp'>Contact Us</a></li>");
        out.println("</ul>");
        out.println("</nav>");
        out.println("</header>");

        out.println("<main>");
        out.println("<section class='products'>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AGROBAZAAR", "root", "7709648063");
            String query = "SELECT Product_ID, Product_Name, Price, Discount, Final_Price, Image_Path FROM Farmer_Product_1 WHERE Approve = true";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("Product_Name");
                double price = rs.getDouble("Price");
                double discount = rs.getDouble("Discount");
                double finalPrice = rs.getDouble("Final_Price");

                out.println("<div class='product-card'>");
                out.println("<img src='RetrieveImage?productId=" + rs.getInt("Product_ID") + "' style='max-width: 300px; max-height: 200px;' alt='" + productName + "'>");
                out.println("<h3 class='product-name'>" + productName + "</h3>");
                out.println("<p class='product-price'>Price: <del>&#8377;" + price + "</del> <span class='discount'>" + discount + "% off</span></p>");
                out.println("<h2 class='final-price'>&#8377;" + finalPrice + "</h2>");
                
                // Form to add product to cart
                out.println("<form method='post' action='AddToCartServlet'>");
                out.println("<input type='hidden' name='productId' value='" + rs.getInt("Product_ID") + "'>");
                out.println("<input type='hidden' name='productName' value='" + rs.getString("Product_Name") + "'>");
                out.println("<input type='hidden' name='price' value='" + rs.getDouble("Price") + "'>");
                out.println("<button type='submit' class='btn'>Add to Cart</button>");
                out.println("</form>");

                out.println("</div>");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error loading products. Please try again later.</p>");
            out.println(e.getMessage());
        }

        out.println("</section>");
        out.println("</main>");
        out.println("<footer>");
        out.println("<div class='footer-sections'>");
        out.println("<div class='footer-links'>");
        out.println("<ul>");
        out.println("<li><a href='index.html'>Home</a></li>");
        out.println("<li><a href='about.html'>About Us</a></li>");
        out.println("<li><a href='dashboard.html'>Dashboard</a></li>");
        out.println("<li><a href='shop.html'>Shop</a></li>");
        out.println("<li><a href='contact.html'>Contact</a></li>");
        out.println("</ul>");
        out.println("</div>");

        out.println("<div class='footer-info'>");
        out.println("<h2><u>About Farming Management</u></h2><br>");
        
        out.println("<p>Farming Management System helps farmers track crop growth, manage resources efficiently, and improve yield using technology.</p>");
        out.println("<ul>");
   
        out.println("</ul>");
        out.println("</div>");

        out.println("<div class='footer-contact'>");
        out.println("<h2><u>Contact Us</u></h2>");
        out.println("<p>Email: aditya@agrobazaar.com</p>");
        out.println("<p>Phone: +91-7709648063</p>");
        out.println("</div>");

        out.println("</div>");
        out.println("</footer>");
        out.println("</body>");
        out.println("</html>");
    }
}
