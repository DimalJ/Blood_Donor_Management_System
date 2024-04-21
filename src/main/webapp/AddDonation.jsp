<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Donation</title>
<link rel="icon" href="./images/blood.ico" type="image/x-icon">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-5">
    <h2>Blood Donation</h2>
    <div class="container">
    	${Message}
    </div>
    <form action="<%= request.getServletContext().getContextPath()%>/AddDonationServlet" method="post">
      <div class="form-group">
        <label for="nic">NIC</label>
        <input type="text" class="form-control" id="nic" name="nic" required>
      </div>
      <div class="form-group">
        <label for="date">Date</label>
        <input type="date" class="form-control" id="date" name="date" required>
      </div>
      <div class="form-group">
        <label for="city">City</label>
        <input type="text" class="form-control" id="city" name="city" required>
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
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</body>
</html>