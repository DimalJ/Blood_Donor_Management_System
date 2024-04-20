<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Donations</title>
<script type="text/javascript">
        function validateForm() {
            var nic = document.getElementById("bloodType").value;
           

            // Check if at least one field is not empty
            if (nic.trim() === "" ) {
                alert("Please select a value.");
                return false;
            }
            return true;
        }
      
        function confirmDelete(id) {
            var confirmed = confirm("Are you sure you want to delete this Donor?");
                if (confirmed) {
                    // Redirect to the delete servlet with donorId and password as parameters
                    window.location.href = "DeleteDonationServlet?id=" + id ;
                }
        }
        
 </script>
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-8">
        <h1>Donation Search</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/SearchDonationServlet" method="get" class="form-inline" onsubmit="return validateForm()">
            <div class="form-group">
        <label for="bloodType">Blood Type</label>
        <select class="form-control" id="bloodType" name="bloodType" required>
          <option value="">Select Blood Type</option>
          <option value="O+">O positive</option>
          <option value="O-">O negative</option>
          <option value="A+">A positive</option>
          <option value="A-">A negative</option>
          <option value="B+">B positive</option>
          <option value="B-">B negative</option>
          <option value="AB+">AB positive</option>
          <option value="AB-">AB negative</option>
        </select>
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
    <h2>Donation List</h2>
    <table class="table">
        <thead>
            <tr>
                <th>NIC</th>
                <th>Date</th>
                <th>City</th>
                <th>BloodType</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over adminList using JSP forEach loop --%>
            <c:forEach var="donation" items="${donations}">
                <tr>
                   <td> <a href="DonorHome.jsp">${donation.nic}</a></td>
                    <td>${donation.date}</td>
                    <td>${donation.city}</td>
                    <td>${donation.bloodType}</td>
                          
                    <td>
                        <!-- Delete button -->
                         <Button  class="btn btn-danger" onclick="confirmDelete(${donation.id})">Delete</Button>
                       
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
</body>
</html>