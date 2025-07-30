package com.servlet;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        // Retrieve product details from the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM farm_Product WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, productId);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    request.setAttribute("productId", resultSet.getInt("id"));
                    request.setAttribute("productName", resultSet.getString("product_name"));
                    request.setAttribute("productDescription", resultSet.getString("product_description"));
                    request.setAttribute("productPrice", resultSet.getDouble("product_price"));
                    request.setAttribute("productQuantity", resultSet.getInt("product_quantity"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Forward to the Edit Product JSP page
        request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("product_name");
        String productDescription = request.getParameter("product_description");
        double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));

        // Update product details in the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE farm_Product SET product_name = ?, product_description = ?, product_price = ?, product_quantity = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, productName);
                preparedStatement.setString(2, productDescription);
                preparedStatement.setDouble(3, productPrice);
                preparedStatement.setInt(4, productQuantity);
                preparedStatement.setInt(5, productId);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to the Farmer Dashboard
        response.sendRedirect("FarmerDashboardServlet");
    }
}
