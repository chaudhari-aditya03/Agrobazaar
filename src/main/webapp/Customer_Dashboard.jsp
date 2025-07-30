<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products - Farming Management System</title>
    <link rel="stylesheet" href="css/Customer_Dashboard.css">
<link href="https://fonts.googleapis.com/css2?family=Averia+Serif+Libre:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&family=Copse&family=DM+Serif+Text:ital@0;1&family=Dancing+Script:wght@400..700&family=EB+Garamond:ital,wght@0,400..800;1,400..800&family=Kalnia+Glaze:wght@100..700&family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&family=Roboto+Mono:ital,wght@0,100..700;1,100..700&family=Roboto+Slab:wght@100..900&display=swap" rel="stylesheet">
  
</head>
<body>
    <header>
        <h1>Customer Dashboard</h1>
        <nav class="nav-container">
            <div class="search-bar">
                <input type="text" placeholder="Search products..." id="search-input">
                <button class="btn" id="search-btn">Search</button>
            </div>
            <ul class="nav-links">
                <li><a href="HomePage.jsp">Home</a></li>
                <li><a href="Corder.jsp">My Orders</a></li>
                <li><a href="CAccount.jsp">My Account</a></li>
                  <li><a href="About.jsp"> About Us </a></li>
                <li><a href="ContactUs.jsp">Contact Us</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="products">
            <!-- Example product cards -->
            <div class="product-card">
                <img class="product-image" src="css/img/tomato1.jpg" alt="Fresh Tomatoes">
                <h3 class="product-name">Tomato</h3>
                <p class="product-price">
                    Price: <del>₹60 per kg</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹50 per kg</h2>
                <button class="btn" aria-label="Add Tomato to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/carrot.jpg" alt="Fresh Carrots">
                <h3 class="product-name">Carrot</h3>
                <p class="product-price">
                    Price: <del>₹50 per kg</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹40 per kg</h2>
                <button class="btn" aria-label="Add Carrot to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/chilli.jpg" alt="Fresh Fenugreek">
                <h3 class="product-name">Chilli</h3>
                <p class="product-price">
                    Price: <del>₹20</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹15</h2>
                <button class="btn" aria-label="Add Fenugreek to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/leadyfingure.jpg" alt="Fresh Ladyfinger">
                <h3 class="product-name">Ladyfinger</h3>
                <p class="product-price">
                    Price: <del>₹60 per kg</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹50 per kg</h2>
                <button class="btn" aria-label="Add Ladyfinger to Cart">Add to Cart</button>
            </div>
        </section>
    </main>
    <br>
    
    <main>
        <section class="products">
            <!-- Example product cards -->
            <div class="product-card">
                <img class="product-image" src="css/img/potato.jpg" alt="Fresh Tomatoes">
                <h3 class="product-name">Potato</h3>
                <p class="product-price">
                    Price: <del>₹55 per kg</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹50 per kg</h2>
                <button class="btn" aria-label="Add Tomato to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/flower.jpg" alt="Fresh Carrots">
                <h3 class="product-name">Flower</h3>
                <p class="product-price">
                    Price: <del>₹20 per </del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹15 per </h2>
                <button class="btn" aria-label="Add Carrot to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/mula.jpg" alt="Fresh Fenugreek">
                <h3 class="product-name">Mula</h3>
                <p class="product-price">
                    Price: <del>₹20</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹15</h2>
                <button class="btn" aria-label="Add Fenugreek to Cart">Add to Cart</button>
            </div>

            <div class="product-card">
                <img class="product-image" src="css/img/brinjal.jpg" alt="Fresh Ladyfinger">
                <h3 class="product-name">Brinjal</h3>
                <p class="product-price">
                    Price: <del>₹45 per kg</del> <span class="discount">10% off</span>
                </p>
                <h2 class="final-price">₹40 per kg</h2>
                <button class="btn" aria-label="Add Ladyfinger to Cart">Add to Cart</button>
            </div>
        </section>
    </main>

    <footer class="font">
        <div class="footer-sections">
            <!-- Navigation Links -->
            <div class="footer-links">
                <ul>
                    <li class="footer-text"><a  href="index.html">Home</a></li>
                    <li class="footer-text"><a  href="about.html">About Us</a></li>
                    <li class="footer-text"><a  href="dashboard.html">Dashboard</a></li>
                    <li class="footer-text"><a  href="shop.html">Shop</a></li>
                    <li class="footer-text"><a  href="contact.html">Contact</a></li>
                </ul>
            </div>

            <!-- Farming Management Information -->
            <div class="footer-info">
                <h2><u>About Farming Management</u></h2>
                <p>Farming Management System helps farmers track crop growth, manage resources efficiently, and improve yield using technology. It includes tools for monitoring, data analysis, and smart farming solutions.</p>
                <p>Check out these helpful resources:</p>
                <ul>
                    <li><a href="https://www.fao.org" target="_blank">FAO - Food and Agriculture Organization</a></li>
                    <li><a href="https://www.nationalagriculturemarket.nic.in" target="_blank">National Agriculture Market</a></li>
                    <li><a href="https://www.icrisat.org" target="_blank">ICRISAT - Smart Farming</a></li>
                </ul>
            </div>

            <!-- Contact and Map -->
            <div class="footer-contact">
                <h2><u>Contact Us</u></h2>
                <p>Address: 123 Farming Lane, Agriculture City, India</p>
                <p>Email: support@farmingsystem.com</p>
                <p>Phone: +91-12345-67890</p>
                <h2><u>Find Us Here:</u></h2>
                <iframe 
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3156.314387329895!2d144.96305771564117!3d-37.814217742632936!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6ad642af0f11fd81%3A0xf5773d7a7885690b!2sFederation%20Square!5e0!3m2!1sen!2sin!4v1636352363549!5m2!1sen!2sin" 
                    width="300" height="200" style="border:0;" allowfullscreen="" loading="lazy">
                </iframe>
            </div>
        </div>

        <div class="footer-bottom">
        </div>
    </footer>
</body>
</html>

