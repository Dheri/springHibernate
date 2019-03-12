<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Movies</title>
</head>
<body>

	<h1>My Movies</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>Genre</th>
			<th>Runtime</th>
			<th>Id</th>
		</tr>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.title}</td>
				<td>${movie.genre}</td>
				<td>${movie.runningTime}</td>
				<td>${movie.id}</td>
				<td><a href=" <c:url value="/Edit/${movie.id}" /> ">Edit</a></td>
				<td><a href=" <c:url value="/Delete/${movie.id}" /> ">Delete</a></td>
			</tr>
		</c:forEach>
	</table>











</body>
</html>