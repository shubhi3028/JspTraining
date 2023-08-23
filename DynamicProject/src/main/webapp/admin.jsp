<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.service.Servlet.UserServlet"%>
<%@page import="com.databaseConnection.connectionProvider"%>
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

	<%-- Only for checking purpose that database is connect or not<%
	Connection conn = connectionProvider.getConnection();
	out.println(conn);
	%>  --%>

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
							<th scope="col">First  Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Phone Number</th>
							<th scope="col">Email</th>
						</tr>
					</thead>
					<tbody>

						<%
						UserServlet dao = new UserServlet(connectionProvider.getConnection());
						List<User> list = dao.getAllUsers();
						for (User s : list) {
						%>
						<tr>
							<td><%=s.getFirstName()%></td>
							<td><%=s.getLastName()%></td>
							<td><%=s.getEmail()%></td>
							<td><%=s.getPhoneNumber()%></td>
							<td><a href="editUser.jsp?id=<%=s.getId()%>"
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