package com.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/farmerproduct")
@MultipartConfig(maxFileSize = 52428800)  // Limit size of uploaded image
public class StoreFarmerProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/AGROBAZAAR"; 
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "7709648063"; 

    private static final String INSERT_PRODUCT_SQL = 
        "INSERT INTO farm_Product (farmer_id, product_name, product_description, product_price, product_quantity, product_image) VALUES (?, ?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer farmerId = (Integer) session.getAttribute("farmer_id");

        if (farmerId == null) {
            response.getWriter().println("<h1>Please log in first!</h1>");
            return;
        }
        PrintWriter out = response.getWriter();
        String productName = request.getParameter("product_name");
        String productDescription = request.getParameter("product_description");
        double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
        Part productImagePart = request.getPart("product_image");  

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);

            preparedStatement.setInt(1, farmerId);
            preparedStatement.setString(2, productName);
            preparedStatement.setString(3, productDescription);
            preparedStatement.setDouble(4, productPrice);
            preparedStatement.setInt(5, productQuantity);

            if (productImagePart != null && productImagePart.getSize() > 0)
            {
                InputStream imageInputStream = productImagePart.getInputStream();
                preparedStatement.setBlob(6, imageInputStream);
            } else 
            {
                preparedStatement.setNull(6, java.sql.Types.BLOB);
            }

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) 
            {
                response.sendRedirect("FarmerDashboardServlet");
            } 
            else
            {
            	 response.sendRedirect("Farmer_Product.jsp");
            	 out.println("<h1>Error: Unable to add product.</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>SQL Error: " + e.getMessage() + "</h1>");
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
