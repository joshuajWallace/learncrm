<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Customer List</title>
	<link rel="stylesheet" href= "<spring:url value ='/resources/css/style.css'/>"/>
	</head>
	<body>
		<h1>
		CRM - Customer Relationship Manager
		<br>
		Customer 
		</h1>
		<button class="btn" type="button" onclick="window.location.href='list';return false;">Back</button>
		<div class="form">
			<form:form method="POST" action="save-customer" modelAttribute="customer">
				<table>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
				</table>
				<form:button class="submit-btn" type = "submit">Submit</form:button>
			</form:form>
		</div>
	</body>
</html>