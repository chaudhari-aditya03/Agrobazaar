<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Management System</title>
    <link rel="stylesheet" href="css/FarmerLogin.css">
</head>
<body>
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
            <h3>"Farm Fresh, Direct to You"</h3>
            <pre>Shop the best of local produce,
                 grown with care and delivered with trust.</pre>
        </div>
    </section>
    <section class="login-section">
        <div class="login-box">
             <h2 style="border-radius:20px;color:green;background-color:rgba(26, 154, 14, 0.3);border-height:30px;">FARMER LOGIN</h2>
      <br>
            <form action="farmLogin" method="post">
                <div class="input-group">
                    <label for="username"><b>USERNAME</b></label>
                    <input type="text" id="uname" name="uname" placeholder="Enter UserName" required>
                </div>
                <div class="input-group">
                    <label for="password"><b>Password</b></label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn" style="width:80px">Login</button>
                <div class="links">
                    <p>Forgot Password? <a href="Farmer_Reg.jsp"><span>Register</span></a></p>
                </div>
            </form>
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
