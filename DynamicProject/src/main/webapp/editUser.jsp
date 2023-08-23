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
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>





</body>
</html>