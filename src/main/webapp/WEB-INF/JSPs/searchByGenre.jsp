<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SBG</title>
</head>
<body>
	<h2>Search By Genre</h2>
	<c:url var="url" value="/SearchGenre" />
	<form:form action="${url}" method="post" modelAttribute="movie">

		<br>Genre: <form:select items="${movie.genreList}" path="genre" />

		<br>
		<input type="submit" value="Search Movie" />
	</form:form>

	<hr>
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
			</tr>
		</c:forEach>
	</table>

</body>
</html>