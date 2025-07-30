<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Management System</title>
    <link rel="stylesheet" href="css/FarmerLogin.css">
</head>
<body>
    <!-- Navbar -->
    <header>
        <nav class="navbar">
            <div class="logo-container">
                <img src="css/img/agrilogo.png" class="logo-img" alt="Logo">
                <h1 class="logo-name"><u>AGROBAZAAR..!</u></h1>
            </div>
              <div class="menu-icon" id="menu-icon">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
        <ul class="nav-links" id="nav-links">
        
                    <li><a href="HomePage.jsp"><u>Home</u></a></li>
                 <li><a href="About.jsp"><u>About Us</u></a></li>
                <li><a href="ContactUs.jsp"><u>Contact Us</u></a></li>
        
        </ul>
        </nav>
    </header>

    <main>
        <section class="hero">
            <div class="hero-content">
               
            </div>
        </section>

        <section class="login-section">
            <div class="login-box">
                <h1 class="login-title" style="color:red;">Login</h1>
                <div class="input-group">
                    <label for="role"><h3>Select Role</h3></label>
                    <select id="role" onchange="redirectBasedOnRole()">
                        <option value="">-- Select Role --</option>
                          <option value="AdminLogin.jsp">Admin Login</option>
                        <option value="HomeFarmer.jsp">Farmer</option>
                        <option value="HomeCustomer.jsp">Customer</option>
                       
                    </select>
                </div>
                <div>
                    <button type="submit" class="btn">Login</button>
                </div><br>
                <div class="links">
                    <p>Forgot Password? <a href="#"><span>Reset</span></a></p>
                </div>
            </div>
        </section>
    </main>

    <footer></footer>

    <script>
        function redirectBasedOnRole() {
            const roleDropdown = document.getElementById('role');
            const selectedValue = roleDropdown.value;
            if (selectedValue) {
                window.location.href = selectedValue;
            }
        }
        const menuIcon = document.getElementById('menu-icon');
        const navLinks = document.getElementById('nav-links');

        menuIcon.addEventListener('click', () => {
            navLinks.classList.toggle('active');
        });
    </script>
</body>
</html>
