<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Orders</title>
  <link rel="stylesheet" href="css/Customer_order.css">
</head>
<body>
  <div class="view-orders">
    <h1>View Orders</h1>
    
    <table class="orders-table">
      <thead>
        <tr>
          <th>Order ID</th>
          <th>Customer Name</th>
          <th>Product</th>
          <th>Quantity</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>John Doe</td>
          <td>Tomatoes</td>
          <td>50 kg</td>
          <td>Shipped</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Jane Smith</td>
          <td>Apples</td>
          <td>30 kg</td>
          <td>Processing</td>
        </tr>
        <tr>
          <td>3</td>
          <td>Mark Johnson</td>
          <td>Potatoes</td>
          <td>100 kg</td>
          <td>Pending</td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
</html>
    