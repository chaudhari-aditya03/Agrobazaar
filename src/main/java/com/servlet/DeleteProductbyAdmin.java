
package com.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteProductServlet1")
public class DeleteProductbyAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    private static final String DELETE_PRODUCT_SQL = "DELETE FROM farm_Product WHERE id = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {

            preparedStatement.setInt(1, Integer.parseInt(productId));
            int rowsDeleted = preparedStatement.executeUpdate();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                if (rowsDeleted > 0) {
                    response.sendRedirect("DisplayFarmerProductServlet");
                } 
                else {
                    out.println("<h2>Failed to delete product. Product ID not found.</h2>");
                }
                out.println("<a href='DisplayFarmerProductServlet'>Back to Product List</a>");
            }
        } catch (SQLException e) {
            throw new ServletException("Error deleting product: " + e.getMessage(), e);
        }
    }
}
