package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewOrders")
public class ViewOrdersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>View Orders</title>");
        out.println("<link rel='stylesheet' href='css/Customer_order.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='view-orders'>");
        out.println("<h1>View Orders</h1>");

        out.println("<table class='orders-table'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Order ID</th>");
        out.println("<th>Customer Name</th>");
        out.println("<th>Product</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        // Database connection and data retrieval
        String jdbcURL = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String dbUser = "yourUsername";
        String dbPassword = "yourPassword";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "SELECT order_id, customer_name, product, quantity, status FROM Orders";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                String customerName = resultSet.getString("customer_name");
                String product = resultSet.getString("product");
                int quantity = resultSet.getInt("quantity");
                String status = resultSet.getString("status");

                out.println("<tr>");
                out.println("<td>" + orderId + "</td>");
                out.println("<td>" + customerName + "</td>");
                out.println("<td>" + product + "</td>");
                out.println("<td>" + quantity + "</td>");
                out.println("<td>" + status + "</td>");
                out.println("</tr>");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<tr><td colspan='5'>Error retrieving orders.</td></tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
