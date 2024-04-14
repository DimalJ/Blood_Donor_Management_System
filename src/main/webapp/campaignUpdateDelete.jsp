<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Campaign List</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script type="text/javascript">
    function confirmDelete(campaignId) {
    	var confirmed = confirm("Are you sure you want to delete this campaign?");
        
        if (confirmed) {
            // Redirect to the delete servlet with the campaignId as a parameter
            window.location.href = "DeleteCampaignServlet?campaignId=" + campaignId;
        }
        
    }
    
</script>
</head>
<body>
<%@include file="navbar.jsp" %>
	${Message}
<div class="container">
    <h2>Campaign List</h2>
    <table class="table">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Date</th>
                <th>Location</th>
                <th>City</th>
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
                    <td>
                        <!-- Update button -->
                        <a href="UpdateCampaignServlet?id=${campaign.id}" class="btn btn-primary">Update</a>
                        
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${campaign.id})">Delete</Button>
                       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

