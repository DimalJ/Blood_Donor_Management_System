<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>password Reset</title>
    <link rel="icon" href="./images/blood.ico" type="image/x-icon">
    <link rel="stylesheet" href="./css/style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .loginContainer {
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    height: 100vh;
		}
        .login-box {
        	
            width: 350px;
            padding: 20px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        .login-box h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
    </style>
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
        
    </script>
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="container">
            <a class="navbar-brand mr-auto" href="CampaignListServlet">Sri Lankan National Blood Transfusion Service</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

        </div>
    </nav>
    <div class="loginContainer">
	    <div class="login-box">
	        <h2>Login</h2>
	        <form action="<%= request.getServletContext().getContextPath()%>/PasswordResetServlet"  onsubmit="return validatePassword()" method="POST">
	        	${Message}
	            <div class="form-group">
	                <label for="username">Username</label>
	                <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
	            </div>
	            <div class="form-group">
	                <label for="email">Email</label>
	                <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
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
       		<div>
	            <button type="submit" class="btn btn-primary btn-block">Submit</button>
	            
	            </div>
	        </form>
	    </div>
    </div>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

   
    <br><br><br>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@include file="footer.jsp" %>
</body>
</html>
