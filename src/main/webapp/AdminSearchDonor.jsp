
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User</title>
<script>
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
    </script>
 <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="navbar.jsp" %>
 <h2>Search User</h2>
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
  	${Message}
  	<br>
  <div class="container">
    <h2>User List</h2>
    <table class="table">
        <thead>
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
                    <td>${donor.nic}</td>
                    <td>${donor.firstName}</td>
                    <td>${donor.lastName}</td>
                    <td>
                        <!-- Update button -->
                        <a href="updateCampaign.jsp?id=${campaign.id}&date=${campaign.date}&location=${campaign.location}&city=${campaign.city}" class="btn btn-primary">Update</a>
                        
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${campaign.id})">Delete</Button>
                       
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