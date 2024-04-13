<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Donor" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
  <a class="navbar-brand" href="#">Sri Lankan National Blood Transfusion Service</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"> Welcome, ${sessionScope.firstName} <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%= request.getServletContext().getContextPath()%>/LogoutServlet" onclick="confirmLogout()">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<script type="text/javascript">
    function confirmLogout() {
        if (confirm("Are you sure you want to logout?")) {
            
        }
    }
</script>