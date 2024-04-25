<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
	        <form action="<%= request.getServletContext().getContextPath()%>/LoginServlet" method="POST">
	        	${Message}
	            <div class="form-group">
	                <label for="username">Username</label>
	                <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
	            </div>
	            <div class="form-group">
	                <label for="password">Password</label>
	                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
	            </div>
	            <button type="submit" class="btn btn-primary btn-block">Login</button>
	            <p>Don't have an account? <a href="registration.jsp">Sign up...</a> </p>
	            <br>
	            <p>Forget Password? <a href="forgetPassword.jsp">Click here...</a> </p>
	        </form>
	    </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>
