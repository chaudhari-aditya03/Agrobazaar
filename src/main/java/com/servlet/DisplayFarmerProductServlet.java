package com.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DisplayFarmerProductServlet")
public class DisplayFarmerProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    private static final String SELECT_PRODUCTS_SQL =
        "SELECT f.id, f.farmer_id, fr.fullname AS farmer_name, f.product_name, " +
        "f.product_quantity, f.product_price, f.product_image " +
        "FROM farm_Product f " +
        "JOIN farmer_Registration fr ON f.farmer_id = fr.id " +
        "WHERE f.product_status = false";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Farmer Products</title>");
            out.println("<link rel='stylesheet' href='css/DisplayFarmerProduct.css'>");
            out.println("<script>");
            out.println("function removeRow(rowId) {");
            out.println("  var row = document.getElementById(rowId);");
            out.println("  if (row) row.style.display = 'none';");
            out.println("}");
            out.println("function changeButtonColor(buttonId) {");
            out.println("  var button = document.getElementById(buttonId);");
            out.println("  if (button) button.style.backgroundColor = 'yellow';");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header><h1>Farmer Products</h1></header>");
            out.println("<div class='container'><table><thead><tr>");
            out.println("<th>Farmer ID</th><th>Name</th><th>Product Name</th><th>Quantity</th><th>Expected Price</th><th>Image</th><th>Actions</th>");
            out.println("</tr></thead><tbody>");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(SELECT_PRODUCTS_SQL)) {

                while (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    int farmerId = resultSet.getInt("farmer_id");
                    String farmerName = resultSet.getString("farmer_name");
                    String productName = resultSet.getString("product_name");
                    int quantity = resultSet.getInt("product_quantity");
                    double price = resultSet.getDouble("product_price");

                    String rowId = "row-" + productId;

                    out.println("<tr id='" + rowId + "'>");
                    out.println("<td>" + farmerId + "</td>");
                    out.println("<td>" + farmerName + "</td>");
                    out.println("<td>" + productName + "</td>");
                    out.println("<td>" + quantity + " Kg</td>");
                    out.println("<td>Rs. " + price + "</td>");

                    out.println("<td>");
                    out.println("<img src='ViewImageServlet?productId=" + productId + "' style='max-width: 300px; max-height: 200px;' alt='Product Image'>");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("<form action='ApproveProduct' method='post'>");
                    out.println("Discount(in %) <input type='number' name='discount' required>");
                    out.println("<br>");
                    out.println("<input type='hidden' name='productId' value='" + productId + "'>");
                    out.println("<input type='hidden' name='product_name' value='" + productName + "'>");
                    out.println("<input type='hidden' name='product_price' value='" + price + "'>");
                    out.println("<button id='approveBtn-" + productId + "' class='add-btn' type='submit' onclick='changeButtonColor(\"approveBtn-" + productId + "\")'>Add Product</button>");
                    out.println("</form>");
                    out.println("<form action='DeleteProductServlet1' method='post'>");
                    out.println("<input type='hidden' name='productId' value='" + productId + "'>");
                    out.println("<button  class='delete-btn' onclick='removeRow(\"" + rowId + "\")'>Delete</button>");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            } catch (SQLException e) {
                out.println("<tr><td colspan='7'>Error fetching data: " + e.getMessage() + "</td></tr>");
            }

            out.println("</tbody></table></div>");
            out.println("</body></html>");
        } catch (ClassNotFoundException e) {
            response.getWriter().println("<h1>Error: MySQL JDBC Driver not found!</h1>");
        }
    }
}
