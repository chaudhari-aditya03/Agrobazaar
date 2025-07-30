<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders - Farming Management System</title>
    <link rel="stylesheet" href="css/Customer_Dashboard.css">
</head>
<body>

    <header>
        <h1>Customer Dashboard</h1>
        <nav class="nav-container">
            <ul class="nav-links">
                <li><a href="CustomerDashboard">Products</a></li>
                <li><a href="Corder.jsp">My Orders</a></li>
                <li><a href="CAccount.jsp">My Account</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="orders">
            <h2>My Orders</h2>
            <div class="order-list">
                <% 
                    // Retrieve the cart from the session
                    String cart = (String) session.getAttribute("cart");

                    if (cart != null && !cart.isEmpty()) {
                %>
                <div class="order-items">
                    <%= cart %>
                </div>
                <% 
                    } else {
                %>
                <p>No orders yet. Start shopping!</p>
                <% 
                    }
                %>
            </div>
        </section>
    </main>

     <footer>
        <div class="footer-sections">
            <div class="footer-links">
                <h2><u>Quick Links</u></h2>
                <br>
                <ul>
                    <li><a href="HomePage.jsp">Home</a></li>
                    <li><a href="About.jsp">About Us</a></li>
                    <li><a href="ContactUs.jsp">Contact</a></li>
                </ul>
            </div>
            <div class="footer-info">
                <h2><u>About Farming Management</u></h2>
                <br>
                <p>Farming Management System helps farmers track crop growth, manage resources efficiently, and improve yield using technology.</p>
            </div>
            <div class="footer-contact">
                <h2><u>Contact Us</u></h2><br>
                <p>Address: Sangamner</p>
                <p>Email: aditya@agrobazaar.com</p>
                <p>Phone: +91-7709648063</p>
            </div>
        </div>
    </footer>

</body>
</html>
