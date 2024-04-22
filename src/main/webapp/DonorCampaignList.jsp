<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donation Campaigns</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        /* Custom CSS for alternating row colors */
        .table-striped-custom tbody tr:nth-of-type(odd) {
            background-color: #f2f2f2;
        }
        .table td, .table th {
            text-align: center;
            vertical-align: middle !important;
    </style>
</head>
<body>
<%@include file="DonorNavbar.jsp" %>
<div style="width: 900px;" class="mx-auto">
	<nav class="nav nav-pills nav-fill">
	  <a class="nav-item nav-link " href="<%= request.getServletContext().getContextPath()%>/DonorDonationListServlet">Donation History</a>
	  <a class="nav-item nav-link" href="<%= request.getServletContext().getContextPath()%>/DonorProfileServlet">Profile</a>
	  <a class="nav-item nav-link active" href="<%= request.getServletContext().getContextPath()%>/DonorCampaignListServlet">Campaign List</a>
	</nav>
</div>
<div class="container">
        <h1 class="mt-5 mb-3">Blood Donation Campaigns near You</h1>
        <table class="table table-striped table-bordered table-striped-custom">
            <thead class="thead-light">
                <tr>
                    <th>Date</th>
                    <th>Location</th>
                    <th>City</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="campaign" items="${campaigns}" varStatus="status">
                    <tr>
                        <td>${campaign.date}</td>
                        <td>${campaign.location}</td>
                        <td>${campaign.city}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="<%= request.getServletContext().getContextPath()%>/DonorAllCampaignsServlet"><button type="button" class="btn btn-lg btn-primary">See All Campaigns</button></a>
    </div>
    <!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>