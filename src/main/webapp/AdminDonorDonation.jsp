<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Donation History</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/style.css">
    <script type="text/javascript">
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

  <br> <br> 
  	<div class="container">
  	${Message}
  	</div>
  	<br>
  <div class="container">
    <h2>Donation List</h2>
    <table class="table table-striped table-bordered table-striped-custom">
        <thead class="thead-light">
            <tr>
            	<th class=>NIC</th>
                <th class="mx-auto">Date</th>
                <th>City</th>
                <th>BloodType</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over adminList using JSP forEach loop --%>
            <c:forEach var="donation" items="${donations}">
                <tr>
                	<td>${donation.nic}</td>
                    <td>${donation.date}</td>
                    <td>${donation.city}</td>
                    <td>${donation.bloodType}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@include file="footer.jsp" %>
</body>
</html>