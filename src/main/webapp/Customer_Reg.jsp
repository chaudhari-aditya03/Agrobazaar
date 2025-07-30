<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration</title>
    <link rel="stylesheet" href="css/Customer_Reg.css"> <!-- Link to external CSS file -->
</head>
<body>
    <div class="form-container">
        <h1><u>Customer Registration Form</u></h1>
        <form action="CustRegForm" method="POST">
            <fieldset >
                <h3>Personal Details</h3>
                <label for="fullName">Farmer Full Name:</label>
                <input type="text" id="fullName" name="fullName" required><br><br>
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required><br><br>
                <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" required><br><br>
                <label for="email">Email Address:</label>
                <input type="email" id="email" name="email" required><br><br>
            </fieldset>
            <fieldset>
                <h3>Login Details</h3>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required ><br><br>
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" required><br><br>
            </fieldset>
            <fieldset>
                <h3>Address Details</h3>
                <label for="fullAddress">Full Address:</label>
                <textarea id="fullAddress" name="fullAddress" rows="4"></textarea><br><br>
                <label for="city">City/Village:</label>
                <input type="text" id="city" name="city" required><br><br>
                <label for="state">State:</label>
                <select id="state" name="state" required>
                    <option value="Andhra Pradesh">Andhra Pradesh</option>
                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                <option value="Assam">Assam</option>
                <option value="Bihar">Bihar</option>
                <option value="Chhattisgarh">Chhattisgarh</option>
                <option value="Goa">Goa</option>
                <option value="Gujarat">Gujarat</option>
                <option value="Haryana">Haryana</option>
                <option value="Himachal Pradesh">Himachal Pradesh</option>
                <option value="Jharkhand">Jharkhand</option>
                <option value="Karnataka">Karnataka</option>
                <option value="Kerala">Kerala</option>
                <option value="Madhya Pradesh">Madhya Pradesh</option>
                <option value="Maharashtra">Maharashtra</option>
                <option value="Manipur">Manipur</option>
                <option value="Meghalaya">Meghalaya</option>
                <option value="Mizoram">Mizoram</option>
                <option value="Nagaland">Nagaland</option>
                <option value="Odisha">Odisha</option>
                <option value="Punjab">Punjab</option>
                <option value="Rajasthan">Rajasthan</option>
                <option value="Sikkim">Sikkim</option>
                <option value="Tamil Nadu">Tamil Nadu</option>
                <option value="Telangana">Telangana</option>
                <option value="Tripura">Tripura</option>
                <option value="Uttar Pradesh">Uttar Pradesh</option>
                <option value="Uttarakhand">Uttarakhand</option>
                <option value="West Bengal">West Bengal</option>
                <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                <option value="Chandigarh">Chandigarh</option>
                <option value="Dadra and Nagar Haveli and Daman and Diu">Dadra and Nagar Haveli and Daman and Diu</option>
                <option value="Delhi">Delhi</option>
                <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                <option value="Ladakh">Ladakh</option>
                <option value="Lakshadweep">Lakshadweep</option>
                <option value="Puducherry">Puducherry</option>
                </select><br><br>
                <label for="pincode">Pincode:</label>
                <input type="text" id="pincode" name="pincode"><br><br>
            </fieldset>
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
