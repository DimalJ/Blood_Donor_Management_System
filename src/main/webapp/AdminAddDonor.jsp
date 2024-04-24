<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Donor</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
   <script>
        // Function to validate password match
        function validatePassword() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;

            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%@include file="navbar.jsp" %>
    <div class="container">
        <h1 class="mt-5 mb-3">Add Donor</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/DonorRegisterServlet" method="POST">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" required>
            </div>
           <div class="form-group">
                 <label for="birthday">Birthday</label>
                <input type="date" class="form-control" id="birthday" name="birthday" required>
                <small id="birthdayError" class="form-text text-danger"></small>
            </div>
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
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="NIC">NIC</label>
                <input type="text" class="form-control" id="NIC" name="NIC" required>
            </div>
             <div class="form-group">
	            <label for="password">Password:</label>
	        	<input type="password" class="form-control" id="password" name="password" required>
			</div>
			<div>
		        <label for="confirmPassword">Confirm Password:</label>
		        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
       		</div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="text" class="form-control" id="mobile" name="mobile" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
    <br>
    <br>
  <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Add event listener to the birthday input field
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
    </script>
    <%@include file="footer.jsp" %>
</body>
</html>
