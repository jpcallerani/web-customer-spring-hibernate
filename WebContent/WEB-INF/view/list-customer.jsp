<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!-- button add customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!-- table code -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an update link -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an update link -->
					<c:url var="deleteLink" value="/customer/showFormForDelete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>

						<td>
							<!-- display link update --> <a href="${updateLink}">Update</a>
						</td>
						<td>
							<!-- display link delete --> <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
