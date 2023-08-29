<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.User"%>
<%@page import="service.Servlet.UserServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="All_CSS_JS.jsp"%>

    <script>
        // Handle button click to redirect
        function editButtonClicked() {
            // Redirect to the editUser.jsp page
            window.location.href = "editUser.jsp";
        }
    </script>
</head>
<body>
    <%@include file="navbar.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <p class="fs-3 text-center">Edit User</p>

                        <%
                        String Email = request.getParameter("email");
                        UserServlet dao = new UserServlet(connectionProvider.getConnection());
                        User s = dao.getUserByEmail();
                        %>

                        <form action="processEditUser.jsp" method="post">
                            <!-- First Name -->
                            <div class="mb-3">
                                <label class="form-label">First Name</label>
                                <input type="text" value="<%= s.getFirstName() %>" name="fname" class="form-control" disabled>
                            </div>

                            <!-- Last Name -->
                            <div class="mb-3">
                                <label class="form-label">Last Name</label>
                                <input type="text" value="<%= s.getLastName() %>" name="lname" class="form-control" disabled>
                            </div>

                            <!-- Phone Number -->
                            <div class="mb-3">
                                <label class="form-label">Phone Number</label>
                                <input type="tel" value="<%= s.getPhoneNumber() %>" name="phoneno" class="form-control" disabled>
                            </div>

                            <!-- Password -->
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input type="password" value="<%= s.getPasswordHash() %>" name="password" class="form-control" disabled>
                            </div>

                            <!-- Email (hidden) -->
                            <input type="hidden" name="email" value="<%= s.getEmail() %>">

                            <!-- Edit Button -->
                            <div>
                                <button type="button" class="btn mx-1 btn-primary float-end" onclick="editButtonClicked()">Edit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
