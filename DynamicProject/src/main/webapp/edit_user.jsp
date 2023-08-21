<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.UserEntity"%>
<%@page import="data.entity.UserEntity"%>
<%@page import="databaseConnection.connectionProvider"%>
<%@page import="Dao.UserDao"%>
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
						int id = Integer.parseInt(request.getParameter("id"));
						UserDao dao = new UserDao(connectionProvider.getConnection());
						UserEntity s = dao.getStudentById(id);
						%>
						
						
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text" 
									value="<%=s.getFname()%>" name="name" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Date of Birth</label> <input
									value="<%= s.getLname() %>" name="name" type="date" class="form-control">
							</div>
					
							<div class="mb-3">
								<label class="form-label">Address</label> <input type="text"
									value="<%= s.getPassword() %>" name="address" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									value="<%= s.getEmail() %>" name="qualification" type="text" class="form-control">
							</div>
		
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									value="<%= s.getPhoneno() %>" name="email" class="form-control">
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