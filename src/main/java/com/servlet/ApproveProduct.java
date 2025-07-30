package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApproveProduct")
public class ApproveProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "7709648063";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String productName = request.getParameter("product_name");
        String productPrice = request.getParameter("product_price");
        String discountStr = request.getParameter("discount");

        if (productId == null || productName == null || productPrice == null || discountStr == null) {
            response.getWriter().write("Error: Missing product details.");
            return;
        }

        int productDiscount;
        try {
            productDiscount = Integer.parseInt(discountStr);
        } catch (NumberFormatException e) {
            response.getWriter().write("Error: Invalid discount format.");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            response.getWriter().write("Error: JDBC Driver not found.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            connection.setAutoCommit(false);

            String selectQuery = "SELECT product_image FROM farm_Product WHERE id = ?";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, Integer.parseInt(productId));
                try (ResultSet rs = selectStmt.executeQuery()) {
                    byte[] productImage = null;
                    if (rs.next()) {
                        productImage = rs.getBytes("product_image");
                    }

                    if (productImage != null) {
                        String imageDirectory = getServletContext().getRealPath("/images");
                        File directory = new File(imageDirectory);
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }

                        String imagePath = imageDirectory + File.separator + productId + ".jpg";
                        try (FileOutputStream fos = new FileOutputStream(imagePath)) {
                            fos.write(productImage);
                        }

                        String relativePath = "images/" + productId + ".jpg"; 
                        String insertQuery = "INSERT INTO Farmer_Product_1 (Product_ID, Product_Name, Price, Discount, Image_Path, Approve) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                            insertStmt.setInt(1, Integer.parseInt(productId));
                            insertStmt.setString(2, productName);
                            insertStmt.setDouble(3, Double.parseDouble(productPrice));
                            insertStmt.setInt(4, productDiscount);
                            insertStmt.setString(5, relativePath);
                            insertStmt.setBoolean(6, true);
                            insertStmt.executeUpdate();
                            connection.commit();
                            response.sendRedirect("DisplayFarmerProductServlet");
                        }
                    } else {
                        response.getWriter().write("Error: Product image not found.");
                    }
                }
            } catch (SQLException e) {
                connection.rollback();
                response.getWriter().write("Error processing request: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            response.getWriter().write("Error: Unable to connect to the database.");
            e.printStackTrace();
        }
    }
}
