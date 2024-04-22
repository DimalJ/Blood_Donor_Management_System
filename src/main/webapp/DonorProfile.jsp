<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Donor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        /* Style for the profile box */
        .profile-box {
            background-color: #f0f0f0;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: 0 auto; 
            width: 50%;
        }
        .button-container {
		  text-align: right; /* Align the content to the right */
		  margin-top: 10px; /* Add some top margin for spacing */
		}
    </style> 	
</head>
<body>
<%@include file="DonorNavbar.jsp" %>
<div style="width: 900px;" class="mx-auto">
	<nav class="nav nav-pills nav-fill">
	  <a class="nav-item nav-link " href="<%= request.getServletContext().getContextPath()%>/DonorDonationListServlet">Donation History</a>
	  <a class="nav-item nav-link active" href="<%= request.getServletContext().getContextPath()%>/DonorProfileServlet">Profile</a>
	  <a class="nav-item nav-link" href="<%= request.getServletContext().getContextPath()%>/DonorCampaignListServlet">Campaign List</a>
	</nav>
</div>
<div class="profile-box">
  <h1>Donor Profile</h1>
    <%
    // Retrieve the Donor object from the request attribute
    Donor donor = (Donor) request.getAttribute("donor");

    // Check if the donor object is not null
    if (donor != null) {
%>
    <div>
        <p><strong>Name:</strong> <%= donor.getFirstName() %> <%= donor.getLastName() %></p>
        <p><strong>Birthday:</strong> <%= donor.getBirthday() %></p>
        <p><strong>City:</strong> <%= donor.getCity() %></p>
        <p><strong>Blood Type:</strong> <%= donor.getBloodType() %></p>
        <p><strong>Email:</strong> <%= donor.getEmail() %></p>
        <p><strong>NIC:</strong> <%= donor.getNic() %></p>
        <p><strong>Mobile:</strong> <%= donor.getMobile() %></p>
    </div>
<%
    } else {
        // Handle the case when donor object is null
        out.println("Donor details not found.");
    }
%>
 	<div class="button-container">
		 <a href="<%= request.getServletContext().getContextPath()%>/GetDonorServlet?id=${donor.getId()}">
		 <button type="button" class="btn btn-lg btn-primary">Update Profile </button></a>
		
 	</div>
 </div>   
 <script>
        // JavaScript function to navigate back to the previous page
        function goBack() {
            window.history.back();
        }
  </script>
 <!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>