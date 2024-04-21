<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
</head>
<body>
    <h1>Error</h1>
    <p><%= request.getAttribute("errorMessage") %></p>
</body>
</html>