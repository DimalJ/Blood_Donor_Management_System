<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Campaigns</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
 <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="navbar.jsp" %>
 <h2>Update Campaign</h2>
 <div class="container mt-5">
    <form action="<%= request.getServletContext().getContextPath()%>/UpdateCampaignServlet" method="post">
        <input type="hidden" name="id" value="${param.id}">
         <div class="form-group">
         <label for="date">Date:</label>
            <input type="date" class="form-control" id="date" name="date" value="${param.date}" required>
        </div>
        <div class="form-group">
            <label for="location">Location:</label>
            <input type="text" class="form-control" id="location" name="location" value="${param.location}" required>
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" id="city" name="city" value="${param.city}" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
  </div>
<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>