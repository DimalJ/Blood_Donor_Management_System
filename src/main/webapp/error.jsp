<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <h1>Error</h1>
    <p><%= request.getAttribute("errorMessage") %></p>
    <%@include file="footer.jsp" %>
</body>
</html>