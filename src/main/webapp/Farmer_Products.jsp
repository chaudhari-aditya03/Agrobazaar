<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Product</title>
  <link rel="stylesheet" href="css/FarmerProducts.css">
</head>
<body>
  <div class="add-product">
    <h1>Add Product</h1>
    <form action="farmerproduct" method="post" enctype="multipart/form-data">
      
      <label for="product_name">Product Name</label>
      <input type="text" id="product_name" name="product_name" required>

      <label for="product_description">Description</label>
      <textarea id="product_description" name="product_description" required></textarea>

      <label for="product_price">Expected Price (<I>in Rs.</I>)</label>
      <input type="number" step="0.01" id="product_price" name="product_price" required>

      <label for="product_quantity">Quantity (<I>in Kg.</I>)</label>
      <input type="number" id="product_quantity" name="product_quantity" required>

      <label for="product_image">Product Image</label>
      <input type="file" id="product_image" name="product_image" accept="image/*">

      <button type="submit">Add Product</button>
    </form>
  </div>
</body>
</html>
