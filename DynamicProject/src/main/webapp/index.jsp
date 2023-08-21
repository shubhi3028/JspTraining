<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.UserEntity"%>
<%@page import="databaseConnection.connectionProvider"%>
<%@page import="Dao.UserDao"%>

<%

if(session.getAttribute("email")== null){
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
				<p class="text-center fs-1">All User Details</p>

				<c:if test="${not empty succMsg}">
					<p class="text-center text-sucess">${succMsg}</p>
					<c:remove var="succMsg" />
				</c:if>

				<c:if test="${not empty errorMsg}">
					<p class="text-center text-sucess">${errorMsg}</p>
					<c:remove var="succMsg" />
				</c:if>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Password</th>
							<th scope="col">Email</th>
							<th scope="col">Contact No</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						UserDao dao = new UserDao(connectionProvider.getConnection());
						List<UserEntity> list = dao.getAllUser();
						for (UserEntity s : list) {
						%>
						<tr>
							<td><%=s.getFname()%></td>
							<td><%=s.getLname()%></td>
							<td><%=s.getPassword()%></td>
							<td><%=s.getEmail()%></td>
							<td><%=s.getPhoneno()%></td>
							<td><a href="edit_student.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-primary">Edit</a> 
			
								<a href="delete?id=<%=s.getId() %>"
								class="btn btn-sm btn-danger">Delete</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>