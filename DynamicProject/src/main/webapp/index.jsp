<%@page import="databaseConnection.connectionProvider"%>
<%@page import="data.entity.User"%>
<%@page import="databaseConnection.connectionProvider"%>
<%@page import="service.Servlet.UserServlet"%>

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
							<th scope="col">Email</th>
							<th scope="col">PhoneNumber</th>
							<th scope="col">Actions</th>
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

							<td><a href="editUserList.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-primary">Edit</a>

								<a href="delete?id=<%=s.getId() %>"
                                class="btn btn-sm btn-danger">Delete</a>
                                <a href="approve?id=<%=s.getId() %>"
                                class="btn btn-sm btn-success" >IsApproved</a>

                      <a href="javascript:void(0);" class="btn btn-sm" onclick="toggleStatus('<%=s.getId() %>');" id="statusButton_<%=s.getId() %>">
                     Active
                     </a>

                                </td>
                                       <script>

                                       function sendPostRequest(id) {
                                       var form = document.createElement("form");
                                       form.setAttribute("method", "post");
                                       form.setAttribute("action", "active");
                                       var input = document.createElement("input");
                                       input.setAttribute("name", "id");
                                       input.setAttribute("value", id);

                                       form.appendChild(input);
                                       document.body.appendChild(form);
                                       form.submit();
                                       const buttonStatus = {};
                                       function toggleStatus(userId) {
                                       var button = document.getElementById("statusButton_" + userId);
                                       if (button) {
                                       if (buttonStatus[userId] === "Active" || !buttonStatus[userId]) {
                                       buttonStatus[userId] = "Inactive";
                                       button.innerHTML = "Inactive";
                                       button.style.backgroundColor = "red";
                                       } else {
                                       buttonStatus[userId] = "Active";
                                       button.innerHTML = "Active";
                                       button.style.backgroundColor = "green";
                                       }
                                }
                           }
                           </script>

						</tr>
						<%
						}
						%>
						<%
                        	UserServlet daos = new UserServlet(connectionProvider.getConnection());
                     		List<User> lists=daos.getUsers();
						for (User u : lists) {
                        		%>
             						<tr>
                 			<td><%=u.getFirstName()%></td>
                        	<td><%=u.getLastName()%></td>
                             <td><%=u.getEmail()%></td>
                        	 <td><%=u.getPhoneNumber()%></td>

                        	 <td><a href="editUserList.jsp?id=<%=u.getId()%>"
                             class="btn btn-sm btn-primary">Edit</a>

                             <a href="delete?id=<%=u.getId() %>"
                                class="btn btn-sm btn-danger">Delete</a>


                 <a href="javascript:void(0);" class="btn btn-sm" onclick="toggleStatus('<%=u.getId() %>');" id="statusButton_<%=u.getId() %>">
                   Active
                 </a>


                   </td>
                    <script>
                    function sendPostRequest(id) {
                      var form = document.createElement("form");
                       form.setAttribute("method", "post");
                        form.setAttribute("action", "active");
                         var input = document.createElement("input");
                          input.setAttribute("name", "id");
                           input.setAttribute("value", id);
                           form.appendChild(input);
                           document.body.appendChild(form);
                            form.submit();
                            }
                            const buttonStatus = {};
                             function toggleStatus(userId) {
                             var button = document.getElementById("statusButton_" + userId);
                              if (button) {
                              if (buttonStatus[userId] === "Active" || !buttonStatus[userId]) {
                              buttonStatus[userId] = "Inactive";
                              button.innerHTML = "Inactive";
                              button.style.backgroundColor = "red";
                               } else {
                               buttonStatus[userId] = "Active";
                                button.innerHTML = "Active";
                                 button.style.backgroundColor = "green";
                                  }
                               }
                               }

                    </script>

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