package com.servlet;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerAdmin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));

        String DB_URL = "jdbc:mysql://localhost:3306/Agrobazaar";
        String DB_USER = "root";
        String DB_PASSWORD = "7709648063";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String deleteQuery = "DELETE FROM customer_reg WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.setInt(1, customerId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect("AdminDashboardServlet");  // Redirect to the Admin Dashboard after successful delete
            } else {
                response.getWriter().write("Error deleting the customer.");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Database connection error.");
        }
    }
}
