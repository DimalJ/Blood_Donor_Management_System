<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<script type="text/javascript">
        function validateForm() {
            var nic = document.getElementById("nic").value;
            var name = document.getElementById("name").value;

            // Check if at least one field is not empty
            if (nic.trim() === "" && name.trim() === "") {
                alert("Please enter NIC or Name.");
                return false;
            }
            return true;
        }
      
        function confirmDelete(donorId) {
        	var confirmed = confirm("Are you sure you want to delete this Donor?");
            
            if (confirmed) {
                // Redirect to the delete servlet with the campaignId as a parameter
                window.location.href = "DeleteDonorServlet?donorId=" + donorId;
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
<%@include file="navbar.jsp" %>
 <br>
 <br>
 <div class="container mt-8">
        <h1>User Search</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/SearchDonorServlet" method="get" class="form-inline" onsubmit="return validateForm()">
            <div class="form-group mr-2">
                <label for="nic">NIC: </label>
                <input type="text" class="form-control" id="nic" name="nic">
            </div>
            <div class="form-group mr-2">
                <label for="name">or Name: </label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
  </div>
  <br> <br> 
  	
  	<br>
  <div class="container">
    <h2>User List</h2>
    <table class="table table-striped table-bordered table-striped-custom">
        <thead class="thead-light">
            <tr>
                <th>NIC</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over campaignList using JSP forEach loop --%>
            <c:forEach var="donor" items="${donors}">
                <tr>
                    <td><a href="<%= request.getServletContext().getContextPath()%>/AdminDonorDonationListServlet?nic=${donor.nic}">${donor.nic}</a></td>
                    <td>${donor.firstName}</td>
                    <td>${donor.lastName}</td>
                    <td>
                        <!-- Update button -->
                        <a href="<%= request.getServletContext().getContextPath()%>/GetDonorServlet?id=${donor.id}" class="btn btn-primary">Update</a>
                        
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${donor.id})">Delete</Button>
                       
                    </td>
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