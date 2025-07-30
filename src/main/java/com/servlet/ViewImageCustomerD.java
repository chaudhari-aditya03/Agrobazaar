package com.servlet;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewImageCustomerD")
public class ViewImageCustomerD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_Id"));
        response.setContentType("image/jpeg");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement("SELECT Image_Path FROM Farmer_Product_1 WHERE Product_ID = ?")) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String imagePath = rs.getString("Image_Path");
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    Files.copy(imageFile.toPath(), response.getOutputStream());
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}