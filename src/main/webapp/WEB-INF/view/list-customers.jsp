<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Customer List</title>
	<link rel="stylesheet" href= '<spring:url value ="/resources/css/style.css"/>' />
	</head>
	<body>
		<h1>
		CRM - Customer Relationship Manager
		<br>
		Customer List:
		</h1>
		<div class="wrapper">
			<button class="btn" type="button" onclick="window.location.href='add-customer';return false;">Add Customer</button>
			<button class="btn" type="button" onclick="window.location.href='list';return false;" >View All Customers</button>
			<form action="search" class="search-form">
					<input name="name" placeholder="Enter Customer Name"/>
					<button class="button" type="submit">Search</button>
			</form>

		</div>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach var="tempCustomer" items="${customers}">
				<spring:url var="updateLink" value="update-customer"  >
					<spring:param name="customerId" value="${tempCustomer.id}"></spring:param>
				</spring:url>
				<spring:url var="deleteLink" value="delete-customer">
				<spring:param name="customerId" value="${tempCustomer.id}"></spring:param>
				</spring:url>
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td> 
					<td>
						<button class = "in-table-btn" onclick = "window.location.href = '${updateLink}'">Update</button>
						<button class = "in-table-btn" onclick = "if (!(confirm('Are you sure you want to delete this customer'))){ return false;}else{ window.location.href='${deleteLink}';return false;}">Delete</button>
	
					</td>
				
				</tr>
			</c:forEach>
		</table>
	</body>
</html>