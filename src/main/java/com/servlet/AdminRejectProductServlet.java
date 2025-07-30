package com.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RejectProduct")
public class AdminRejectProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    // SQL query to update product status to "reject"
    private static final String REJECT_PRODUCT_SQL = "UPDATE farm_Product SET product_status = 'reject' WHERE id = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(REJECT_PRODUCT_SQL)) {
            preparedStatement.setInt(1, Integer.parseInt(productId));
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("error");
        }
    }
}
