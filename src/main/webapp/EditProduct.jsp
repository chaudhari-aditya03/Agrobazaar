<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background: url('css/img/bg.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 15px;
        }
        h1 {
            color: #2c3e50;
            font-size: 2rem;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 20px 25px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 500px;
        }
        label {
            display: block;
            font-weight: 600;
            color: #34495e;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccd1d1;
            border-radius: 5px;
            font-size: 1rem;
        }
        textarea {
            height: 100px;
            resize: vertical;
        }
        button {
            background-color: #27ae60;
            color: #ffffff;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            width: 100%;
        }
        button:hover {
            background-color: #219150;
        }
        @media (max-width: 600px) {
            form {
                padding: 15px 20px;
            }
            h1 {
                font-size: 1.5rem;
            }
            button {
                padding: 10px 15px;
            }
        }
    </style>
</head>
<body>
   
    <form action="EditProductServlet" method="post">
    <h1>Edit Products</h1>
        <input type="hidden" name="id" value="${productId}">
        
        <label for="product_name">Product Name:</label>
        <input type="text" id="product_name" name="product_name" value="${productName}" required>
        
        <label for="product_description">Description:</label>
        <textarea id="product_description" name="product_description" required>${productDescription}</textarea>
        
        <label for="product_price">Price:</label>
        <input type="number" id="product_price" name="product_price" value="${productPrice}" required>
        
        <label for="product_quantity">Quantity:</label>
        <input type="number" id="product_quantity" name="product_quantity" value="${productQuantity}" required>
        
        <button type="submit">Save Changes</button>
    </form>
</body>
</html>
