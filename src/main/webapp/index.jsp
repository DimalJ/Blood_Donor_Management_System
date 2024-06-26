<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Donor Management</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        .table-striped-custom tbody tr:nth-of-type(odd) {
            background-color: #f2f2f2;
        }
        .table td, .table th {
            text-align: center;
            vertical-align: middle !important;
    </style>
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
    <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="container">
            <a class="navbar-brand mr-auto" href="CampaignListServlet">Sri Lankan National Blood Transfusion Service</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login/Register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center">Welcome to Blood Donor Management System</h2>
                <p class="lead text-center">"Every drop counts! Join us in saving lives. Donate blood today."</p>
            </div>
        </div>
    </div>
    <div class="container">
        <h1 class="mt-5 mb-3">Upcoming Blood Donation Campaigns</h1>
        <table class="table table-striped table-bordered table-striped-custom">
            <thead class="thead-light">
                <tr>
                    <th>Date</th>
                    <th>Location</th>
                    <th>City</th>
                    <th>Start Time</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="campaign" items="${campaigns}" varStatus="status">
                    <tr>
                        <td>${campaign.date}</td>
                        <td>${campaign.location}</td>
                        <td>${campaign.city}</td>
                         <td>${campaign.time}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <footer>
    <div class="container">
        <p>Sri Lankan National Blood Transfusion Service</p>
        <p>&copy; DimalJay. All rights reserved.</p>
    </div>
</footer>
</body>
</html>