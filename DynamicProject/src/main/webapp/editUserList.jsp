<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.User"%>
<%@page import="databaseConnection.connectionProvider"%>
<%@page import="service.Servlet.UserServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_CSS_JS.jsp"%>

<script type="text/javascript">
    function validateForm() {
        var fname = document.getElementById("fname").value.trim();
        var lname = document.getElementById("lname").value.trim();
        var phoneno = document.getElementById("phoneno").value.trim();
        var password = document.getElementById("password").value.trim();

        // Check for empty fields
        if (fname === "" || lname === "" || phoneno === "" || password === "") {
            alert("Please fill in all fields.");
            return false;
        }

        // Check for valid phone number format (10 digits starting with 6, 7, 8, or 9)
        if (!/^[6-9]\d{9}$/.test(phoneno)) {
            alert("Phone number must start with 6, 7, 8, or 9 and have 10 digits.");
            return false;
        }

        // Check for valid First Name and Last Name (only alphabets)
        if (!/^[a-zA-Z]+$/.test(fname) || !/^[a-zA-Z]+$/.test(lname)) {
            alert("First Name and Last Name should contain only alphabets.");
            return false;
        }

        // Check for no spaces in First Name, Last Name, and Password
        if (/\s/.test(fname) || /\s/.test(lname) || /\s/.test(password)) {
            alert("No spaces allowed in First Name, Last Name, or Password.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <%@include file="navbar.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-md-6  offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <p class="fs-3 text-center">Edit User</p>

                        <%
                        String ID =request.getParameter("id");
                        UserServlet dao = new UserServlet(connectionProvider.getConnection());
                        User s = dao.getUserById(ID);
                        %>
                        <form action="update" method="post" onsubmit="return validateForm();">
                            <div class="mb-3">
                                <label class="form-label">First Name</label>
                                <input type="text" value="<%= s.getFirstName() %>" name="fname" class="form-control" id="fname">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Last Name</label>
                                <input type="text" value="<%= s.getLastName() %>" name="lname" class="form-control" id="lname">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Phone Number</label>
                                <input type="tel" value="<%= s.getPhoneNumber() %>" name="phoneno" class="form-control" id="phoneno">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input type="password" value="<%= s.getPasswordHash() %>" name="password" class="form-control" id="password">
                            </div>

                            <input type="hidden" name="id" value="<%=s.getId() %>">

                            <div>
                                <a href="index.jsp" class="btn mx-1 btn-danger float-end">Cancel</a>
                                <button type="submit" class="btn mx-1 btn-primary float-end">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
