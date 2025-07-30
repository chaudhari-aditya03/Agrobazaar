<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
    <h1>Add User</h1>
    <form action="AddUser" method="post">
        <label>Name:</label><br>
        <input type="text" name="name" required><br>
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Age:</label><br>
        <input type="number" name="age" required><br><br>
        <input type="submit" value="Add User">
    </form>
</body>
</html>
