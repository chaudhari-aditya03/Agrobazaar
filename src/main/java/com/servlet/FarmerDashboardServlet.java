package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FarmerDashboardServlet")
public class FarmerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("farmer_id") == null) {
            response.sendRedirect("HomeFarmer.jsp");
            return;
        }

        int farmerId = (int) session.getAttribute("farmer_id");
        String farmerName = (String) session.getAttribute("fullname");
        String farmerContact = (String) session.getAttribute("contact_number");
        String farmeremail = (String) session.getAttribute("email");

        double totalSales = 0.0;
        int totalOrders = 0;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Query to get total sales and total orders for the farmer
            String salesQuery = "SELECT SUM(order_total) AS total_sales, COUNT(*) AS total_orders FROM farm_Orders WHERE farmer_id = ? AND order_status = 'Completed'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(salesQuery)) {
                preparedStatement.setInt(1, farmerId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    totalSales = resultSet.getDouble("total_sales");
                    totalOrders = resultSet.getInt("total_orders");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter()) {
            // Start HTML structure
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Farmer Dashboard</title>");
            out.println("<link rel='stylesheet' href='css/FarmerDashboard.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='dashboard-container'>");

            // Header Section
            out.println("<header>");
            out.println("<h1><b>Farmer Dashboard</b></h1>");
            out.println("<br>");
            out.println("<div class='user-info'>");            
            out.println("<main>");
            out.println("<section id='account'>");
            out.println("<h3>My Account</h3>");
            out.println("<br>");
            out.println("<p>Farmer_Name: <span id='customer-contact'> " + farmerName +"</span></p>");
            out.println("<p>Contact_Number: <span id='customer-contact'> " + farmerContact + "</span></p>");
            out.println("<p>E mail: <span id='customer-email'> " + farmeremail + "</span></p>");
            out.println("<a href='LogoutFarmerServlet'><button class='logout-btn'>Logout</button></a>");
            out.println("</section>");
            out.println("</main>");
            out.println("</div>");
            out.println("</header>");

            // Content Section (First Row with Product Management and Sales Summary side by side)
            out.println("<div class='container'>");

            // Product Management Section
            out.println("<div class='product-management'>");
            out.println("<h2>Manage Your Products</h2>");
            out.println("<br>");
            out.println("<a href='Farmer_Products.jsp' class='btn'><button class='add-product-btn'>Add New Product</button></a>");
            out.println("</div>");

            // Sales Summary Section
           // Closing container for first row

            // Product Description Section (Below the first row)
            out.println("<div class='order-list'>");
            out.println("<h2>Product Description</h2>");
            out.println("<table id='order-table'>");
            out.println("<thead><tr><th>Product ID</th><th>Product Name</th><th>Description</th><th>Price</th><th>Quantity</th><th>Status</th><th>Actions</th></tr></thead>");
            out.println("<tbody>");

            // Fetch and display products from the database
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, product_name, product_description, product_price, product_quantity, product_status FROM farm_Product WHERE farmer_id = ?")) {
                   preparedStatement.setInt(1, farmerId);
                   ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    String productName = resultSet.getString("product_name");
                    String productDescription = resultSet.getString("product_description");
                    double productPrice = resultSet.getDouble("product_price");
                    int productQuantity = resultSet.getInt("product_quantity");
                    String productStatus = resultSet.getString("product_status");

                    out.println("<tr>");
                    out.println("<td>" + productId + "</td>");
                    out.println("<td>" + productName + "</td>");
                    out.println("<td>" + productDescription + "</td>");
                    out.println("<td>Rs " + productPrice + "</td>");
                    out.println("<td>" + productQuantity + "kg</td>");
                    
                    // Display status
                    out.println("<td>");
                    if (productStatus.equals("Approved")) {
                        out.println("<span style='color: green;'>Approved</span>");
                    } else if (productStatus.equals("Rejected")) {
                        out.println("<span style='color: red;'>Rejected</span>");
                    } else {
                        out.println("<span style='color: orange;'>Pending</span>");
                    }
                    out.println("</td>");

                    out.println("<td>");
                    out.println("<a href='EditProductServlet?id=" + productId + "'><button class='edit-order-btn'>Edit</button></a>");
                    out.println("<a href='DeleteProductServlet?id=" + productId + "'><button class='delete-order-btn'>Delete</button></a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<tr><td colspan='7'>Unable to fetch product data.</td></tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>"); // order-list
            out.println("</div>"); // Closing dashboard-container

            out.println("</body>");
            out.println("</html>");
        }
    }
}
