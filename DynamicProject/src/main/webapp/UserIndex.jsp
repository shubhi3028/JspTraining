<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.User"%>
<%@page import="service.Servlet.UserServlet"%>

<%
if (session.getAttribute("email") == null) {
    response.sendRedirect("login.jsp");
}
%>

<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="All_CSS_JS.jsp"%>
</head>
<body class="bg-light">
    <%@include file="navbar.jsp"%>

    <div class="container p-3">
        <div class="card">
            <div class="card-body">
                <p class="text-center fs-1"> User Details</p>

                <c:if test="${not empty succMsg}">
                    <p class="text-center text-sucess">${succMsg}</p>
                    <c:remove var="succMsg" />
                </c:if>

                <c:if test="${not empty errorMsg}">
                    <p class="text-center text-sucess">${errorMsg}</p>
                    <c:remove var="succMsg" />
                </c:if>
              <form action="update" method="post">
              							<div class="mb-3">
              								<label class="form-label">First Name</label> <input type="text"
              									value="<%=s.getFirstName()%>" name="fname" class="form-control">
              							</div>
              							<div class="mb-3">
              								<label class="form-label">Last Name</label> <input type="text"
              									value="<%= s.getLastName() %>" name="lname" class="form-control">
              							</div>

                                       <div class="mb-3">
              								<label class="form-label">Phone Number</label> <input type="tel"
              									value="<%= s.getPhoneNumber() %>" name="phoneno" class="form-control">
              							</div>

              							<div class="mb-3">
              								<label class="form-label">Password</label> <input type="password"
              									value="<%= s.getPasswordHash() %>" name="password" class="form-control">
              							</div>

              							<input type="hidden" name="id" value="<%=s.getId() %>">


              							<button type="submit" class="btn btn-primary col-md-12">Update</button>
              							<a href="editUser.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
              						</form>
            </div>
        </div>
    </div>
</body>
</html>
