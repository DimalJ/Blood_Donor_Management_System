<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Donor </title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
   <style type="text/css">
    .button-container {
            display: flex;
            justify-content: space-between;
        }

        .button-container button {
            width: 150px; 
            margin-right: 10px;
        }
   </style>
  
   <script>
        // Function to validate password match
        function validatePassword() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
	
            if (password.length < 8) {
                alert("Password must be at least 8 characters long.");
                return false;
            }
            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        }
        document.addEventListener("DOMContentLoaded", function() {
            var passwordInput = document.getElementById("password");
            passwordInput.addEventListener("input", function() {
                var password = passwordInput.value;
                if (password.length < 8) {
                    document.getElementById("passwordError").innerText = "Password must be at least 8 characters long.";
                } else {
                    document.getElementById("passwordError").innerText = "";
                }
            });
        });
        document.getElementById('birthday').addEventListener('change', function() {
            var birthdayInput = this.value;
            var today = new Date();
            var birthday = new Date(birthdayInput);
            var age = today.getFullYear() - birthday.getFullYear();
            var m = today.getMonth() - birthday.getMonth();
            if (m < 0 || (m === 0 && today.getDate() < birthday.getDate())) {
                age--;
            }
            if (age < 18) {
                document.getElementById("birthdayError").innerText = "You must be 18 years or older to register.";
                this.value = "";
            } else {
                document.getElementById("birthdayError").innerText = "";
            }
        });
        
        function goBack() {
            window.history.back();
        }
    </script>
</head>
<body>
<%@include file="navbar.jsp" %>  
    <div class="container">
        <h1 class="mt-5 mb-3">Update Donor Information</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/UpdateDonorServlet" onsubmit="return validatePassword()" method="POST">
            <input type="hidden" class="form-control" id="id" name="id" value="${donor.id}" >
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${donor.firstName}"required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${donor.lastName}"required>
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" value="${donor.city}"required>
            </div>
           <div class="form-group">
                 <label for="birthday">Birthday</label>
                <input type="date" class="form-control" id="birthday" name="birthday" value="${donor.birthday}"required>
                <small id="birthdayError" class="form-text text-danger"></small>
            </div>
            <div class="form-group">
                <label for="bloodType">Blood Type</label>
                <select class="form-control" id="bloodType" name="bloodType" required>
                    <option value="">Select Blood Type</option>
                    <option value="O+" ${donor.bloodType == 'O+' ? 'selected' : ''}>O positive</option>
                    <option value="O-" ${donor.bloodType == 'O-' ? 'selected' : ''}>O negative</option>
                    <option value="A+" ${donor.bloodType == 'A+' ? 'selected' : ''}>A positive</option>
                    <option value="A-" ${donor.bloodType == 'A-' ? 'selected' : ''}>A negative</option>
                    <option value="B+" ${donor.bloodType == 'B+' ? 'selected' : ''}>B positive</option>
                    <option value="B-" ${donor.bloodType == 'B-' ? 'selected' : ''}>B negative</option>
                    <option value="AB+" ${donor.bloodType == 'AB+' ? 'selected' : ''}>AB positive</option>
                    <option value="AB-" ${donor.bloodType == 'AB-' ? 'selected' : ''}>AB negative</option>
                </select>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${donor.email}" required>
            </div>
            <div class="form-group">
                <label for="NIC">NIC</label>
                <input type="text" class="form-control" id="NIC" name="NIC" value="${donor.nic}" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="text" class="form-control" id="mobile" name="mobile" value="${donor.mobile}" required>
            </div>
       		<div class="button-container">
            	<button type="submit" class="btn btn-primary">Update</button>
             	<button type="button" onclick="goBack()">Cancel</button>
             </div>
           
        </form>
    </div>
   
  <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   
    <br><br><br>
    <%@include file="footer.jsp" %>
</body>
</html>