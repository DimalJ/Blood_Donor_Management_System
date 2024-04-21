<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
    // Retrieve the success message from the servlet
    var successMessage = "${Message}";

    // Check if the success message is not empty
    if (successMessage.trim() !== "") {
        // Display the success message as a pop-up
        alert(successMessage);
    }
</script>
</head>
<body>
<%@include file="navbar.jsp" %>
	
<div class="container mt-">
    <h2>Home</h2>
    <a href="addCampaign.jsp" class="btn btn-warning" >Add Campaign</a>
</div>
<div class="container mt-5">
    <a href="<%= request.getServletContext().getContextPath()%>/AdminCampaignListServlet" class="btn btn-warning">Campaign List</a>
</div>
<div class="container mt-5">
    <a href="AdminAddDonor.jsp" class="btn btn-danger">Add Donor</a>
</div>
<div class="container mt-5">
    <a href="AdminSearchDonor.jsp" class="btn btn-danger">Search Donor</a>
</div>
<div class="container mt-5">
    <a href="AddAdmin.jsp" class="btn btn-info">Add Admin</a>
</div>
<div class="container mt-5">
    <a href="SearchAdmin.jsp" class="btn btn-info">Search Admin</a>
</div>
<div class="container mt-5">
    <a href="AddDonation.jsp" class="btn btn-dark">add Donation</a>
</div>
<div class="container mt-5">
    <a href="SearchDonation.jsp" class="btn btn-dark">Search Donation</a>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>