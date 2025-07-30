package com.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) 
        {
            String query = "DELETE FROM farm_Product WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
            {
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("FarmerDashboardServlet");
    }
}

