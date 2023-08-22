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

	<div class="container">
		<div class="row">
			<div class="col-md-6  offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>

						<c:if test="${not empty succMsg}">
							<p class="text-center text-sucess">${succMsg}</p>
							<c:remove var="succMsg" />         
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-sucess">${errorMsg}</p>
							<c:remove var="succMsg" />
						</c:if>

						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label">First Name</label> <input type="text"
									name="fname" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Last Name</label> <input
									name="lname" type="text" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input type="password"
									name="password" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input
									name="email" type="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Phone No</label> <input type="tel"
									name="phoneno" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>