<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AGROBAZAAR - Homepage</title>
    <link rel="stylesheet" href="css/MainHomePage.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="logo-container">
                <img src="css/img/agrilogo.png" class="logo-img" alt="Logo">
                <h1 class="logo-name"><u>AGROBAZAAR..!</u></h1>
            </div>
            <button class="hamburger" id="hamburger">
                <span class="bar"></span><span class="bar"></span><span class="bar"></span>
            </button>
            <ul class="nav-links" id="nav-links">
                <li><a href="HomePage.jsp"><u>Home</u></a></li>
                <li><a href="About.jsp"><u>About Us</u></a></li>
                <li><a href="ContactUs.jsp"><u>Contact Us</u></a></li>
                <li><a href="LoginPage.jsp"><u>Login...!</u></a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="contain">
            <div class="image-container">
               <img src="css/img/box5.jpg" alt="Image">
            </div>
            <div class="txt">
                <p>Fresh Healthy</p>
                <h2>Vegetables</h2>
            </div>
            <section class="hero">
                <div class="hero-content">
                    <h3>"Farm Fresh, Direct to You"</h3>
                    <pre>Shop the best of local produce, grown with care and delivered with trust.</pre>
                </div>
                <a href="LoginPage.jsp"><button class="visit-now">Visit Now</button></a>
            </section>
        </div>
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

    <script>
        const hamburger = document.getElementById('hamburger');
        const navLinks = document.getElementById('nav-links');
        hamburger.addEventListener('click', () => navLinks.classList.toggle('show'));
    </script>
</body>
</html>
