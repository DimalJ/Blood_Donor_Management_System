<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Donor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="DonorNavbar.jsp" %>

  <h1>User Profile</h1>
    <%
    // Retrieve the Donor object from the request attribute
    Donor donor = (Donor) request.getAttribute("donor");

    // Check if the donor object is not null
    if (donor != null) {
%>
    <div>
        <p><strong>First Name:</strong> <%= donor.getFirstName() %></p>
        <p><strong>Last Name:</strong> <%= donor.getLastName() %></p>
        <!-- Add more details as needed -->
    </div>
<%
    } else {
        // Handle the case when donor object is null
        out.println("Donor details not found.");
    }
%>
    
 <!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>