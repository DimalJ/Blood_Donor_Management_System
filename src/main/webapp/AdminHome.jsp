<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
</head>
<body>
<%@include file="navbar.jsp" %>
	

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 mb-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Campaign Management</h5>
                    <p class="card-text">Manage campaigns and events</p>
                      <div class="align-items-center">
                    <a href="<%= request.getServletContext().getContextPath()%>/AdminCampaignListServlet" class="btn btn-warning">Campaign List</a>
                    <a href="addCampaign.jsp" class="btn btn-warning">Add Campaign</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 mb-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Donor Management</h5>
                    <p class="card-text">Manage donor records</p>
                      <div class="align-items-center">
                    <a href="AdminSearchDonor.jsp" class="btn btn-danger">Search Donor</a>
                    <a href="AdminAddDonor.jsp" class="btn btn-danger ">Add Donor</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 mb-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Admin Management</h5>
                    <p class="card-text">Manage admin users</p>
                     <div class="align-items-center">
                    <a href="SearchAdmin.jsp" class="btn btn-info">Search Admin</a>
                    <a href="AddAdmin.jsp" class="btn btn-info ">Add Admin</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 mb-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Donation Management</h5>
                    <p class="card-text">Manage donation records</p>
                     <div class="align-items-center">
                    <a href="SearchDonation.jsp" class="btn btn-dark">Search Donation</a>
                    <a href="AddDonation.jsp" class="btn btn-dark ">Add Donation</a>
                     </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@include file="footer.jsp" %>
</body>
</html>