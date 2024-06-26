<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Campaign List</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <script type="text/javascript">
    function confirmDelete(campaignId) {
    	var confirmed = confirm("Are you sure you want to delete this campaign?");
        
        if (confirmed) {
            // Redirect to the delete servlet with the campaignId as a parameter
            window.location.href = "DeleteCampaignServlet?campaignId=" + campaignId;
        }
        
    }
 // Retrieve the success message from the servlet
    var successMessage = "${Message}";

    // Check if the success message is not empty
    if (successMessage.trim() !== "") {
        // Display the success message as a pop-up
        alert(successMessage);
        }
    
    
</script>
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
<%@include file="navbar.jsp" %>
	
<div class="container">
    <h2>Campaign List</h2>
    <table class="table table-striped table-bordered table-striped-custom">
        <thead class="thead-light">
            <tr>
            	<th>Id</th>
                <th>Date</th>
                <th>Location</th>
                <th>City</th>
                <th>Start Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over campaignList using JSP forEach loop --%>
            <c:forEach var="campaign" items="${campaigns}">
                <tr>
                	<td>${campaign.id}</td>
                    <td>${campaign.date}</td>
                    <td>${campaign.location}</td>
                    <td>${campaign.city}</td>
                    <td>${campaign.time}</td>
                    <td>
                        <!-- Update button -->
                        <a href="updateCampaign.jsp?id=${campaign.id}&date=${campaign.date}&location=${campaign.location}&city=${campaign.city}&time=${campaign.time}" class="btn btn-primary">Update</a>
                        
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${campaign.id})">Delete</Button>
                       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>

