<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Admin</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
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
        // Retrieve the success message from the servlet
        var successMessage = "${Message}";

        // Check if the success message is not empty
        if (successMessage.trim() !== "") {
            // Display the success message as a pop-up
            alert(successMessage);
        }
 
    </script>
</head>
<body>
<%@include file="navbar.jsp" %>

    <div class="container">
        <h1 class="mt-5 mb-3">Add Admin User</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/AddAdminServlet" onsubmit="return validatePassword()" method="POST">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="form-group">
                <label for="city">username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
             <div class="form-group">
	            <label for="password">Password:</label>
	        	<input type="password" class="form-control" id="password" name="password" required>
	        	<span id="passwordRequirement">Minimum 8 characters</span>
    			<span id="passwordError" style="color: red;"></span>
			</div>
			<div>
		        <label for="confirmPassword">Confirm Password:</label>
		        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
       		</div>
       		<br>
       		<button type="submit" class="btn btn-primary">Register</button>
       		
        </form>
    </div>
 <%@include file="footer.jsp" %>
</body>
</html>
