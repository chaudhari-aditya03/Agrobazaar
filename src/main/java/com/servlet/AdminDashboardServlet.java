package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Agrobazaar";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "7709648063";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String farmerQuery = "SELECT id, fullname FROM farmer_Registration";
            Statement stmt1 = conn.createStatement();
            ResultSet farmerRs = stmt1.executeQuery(farmerQuery);

            String customerQuery = "SELECT id, full_name FROM customer_reg";
            Statement stmt2 = conn.createStatement();
            ResultSet customerRs = stmt2.executeQuery(customerQuery);

            HttpSession session = request.getSession();

            StringBuilder farmerList = new StringBuilder();
            while (farmerRs.next()) {
                int farmerId = farmerRs.getInt("id");
                String farmerName = farmerRs.getString("fullname");
                farmerList.append("<tr><td>").append(farmerId).append("</td><td>").append(farmerName)
                          .append("</td><td><button class=\"action-btn delete\" onclick=\"window.location.href='DeleteFarmerServlet?farmerId=")
                          .append(farmerId).append("';\">Delete</button></td></tr>");
            }


            session.setAttribute("farmerList", farmerList.toString());

            StringBuilder customerList = new StringBuilder();
            while (customerRs.next()) {
                int customerId = customerRs.getInt("id");
                String customerName = customerRs.getString("full_name");
                customerList.append("<tr><td>").append(customerId).append("</td><td>").append(customerName)
                            .append("</td><td><button class=\"action-btn delete\" onclick=\"window.location.href='DeleteCustomerServlet?customerId=")
                            .append(customerId).append("';\">Delete</button></td></tr>");
            }

            session.setAttribute("customerList", customerList.toString());

            farmerRs.close();
            customerRs.close();
            stmt1.close();
            stmt2.close();
            conn.close();

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Admin Panel</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/AdminDashboard.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"sidebar\">");
            out.println("<h2>Admin Panel</h2>");
            out.println("<ul>");
            out.println("<li><a href=\"AdminDashboardServlet\">Dashboard</a></li>");
            out.println("<li><a href=\"DisplayFarmerProductServlet\">Farmer Products</a></li>");
            out.println("<li><a href=\"About.jsp\">About Us</a></li>");
            out.println("<li><a href=\"LogoutAdmin\">Logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("<div class=\"main-content\">");
            out.println("<header>");
            out.println("<h1>Welcome, Admin</h1>");
            out.println("</header>");

            out.println("<section class=\"dashboard\">");
            out.println("<div class=\"card\"><h3>Total Farmer Users</h3><p>120</p></div>");
            out.println("<div class=\"card\"><h3>Active Farmer Users</h3><p>85</p></div>");
            out.println("<div class=\"card\"><h3>Report</h3><p>15</p></div>");
            out.println("<div class=\"card\"><h3>Total Customer Users</h3><p>150</p></div>");
            out.println("<div class=\"card\"><h3>Active Customer Users</h3><p>90</p></div>");
            out.println("<div class=\"card\"><h3>Report</h3><p>15</p></div>");
            out.println("</section>");

            out.println("<section class=\"table-section\">");
            out.println("<h2>Farmer List</h2>");
            out.println("<table>");
            out.println("<thead><tr><th>Farmer ID</th><th>Farmer Name</th><th>Action</th></tr></thead>");
            out.println("<tbody>");
            out.println(session.getAttribute("farmerList"));
            out.println("</tbody>");
            out.println("</table>");
            out.println("</section>");

            out.println("<section class=\"table-section\">");
            out.println("<h2 class=\"cus\">Customer List</h2>");
            out.println("<table>");
            out.println("<thead><tr><th>Customer ID</th><th>Customer Name</th><th>Action</th></tr></thead>");
            out.println("<tbody>");
            out.println(session.getAttribute("customerList"));
            out.println("</tbody>");
            out.println("</table>");
            out.println("</section>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Database connection error.");
            out.println(e);
        }
    }
}
