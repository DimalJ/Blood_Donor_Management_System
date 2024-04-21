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
            var nic = document.getElementById("username").value;
            var name = document.getElementById("name").value;

            // Check if at least one field is not empty
            if (nic.trim() === "" && name.trim() === "") {
                alert("Please enter NIC or Name.");
                return false;
            }
            return true;
        }
      
        function confirmDelete(id) {
            var password = prompt("Please enter admin password:");
            if (password !== null) { // Check if the user clicked Cancel
                var confirmed = confirm("Are you sure you want to delete this Donor?");
                if (confirmed) {
                    // Redirect to the delete servlet with donorId and password as parameters
                    window.location.href = "DeleteAdminServlet?adminId=" + id + "&password=" + encodeURIComponent(password);
                }
            }
        }
 </script>
    
    
 <!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
 <div class="container mt-8">
 <h2>Search Admin users</h2>
 </div>
 <div class="container mt-8">
        <h1>Admin user Search</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/SearchAdminServlet" method="get" class="form-inline" onsubmit="return validateForm()">
            <div class="form-group mr-2">
                <label for="nic">NIC: </label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <div class="form-group mr-2">
                <label for="name">or Name: </label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
  </div>
  <br> <br> 
  	<div class="container">
  	${Message}
  	</div>
  	<br>
  <div class="container">
    <h2>User List</h2>
     <table class="table table-striped table-bordered table-striped-custom">
        <thead class="thead-light">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over adminList using JSP forEach loop --%>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td>${admin.firstName}</td>
                    <td>${admin.lastName}</td>
                    <td>${admin.username}</td>
                    <td>
                       
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${admin.id})">Delete</Button>
                       
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
</body>
</html>