<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: aqua;
}
</style>
<meta charset="ISO-8859-1">
<title>Edit movie</title>
</head>
<body>
	<h2>Edit a Movie</h2>
	<c:url var="url" value="/EditMovie" />
	<form:form action="${url}" method="post" modelAttribute="movie">

		<input type="hidden" name="id" value="${movie.id}">
		<br>
		<br> Title: <form:input path="title" />
		<br>
		<br>Genre: <form:select items="${movie.genreList}" path="genre" />
		<br>
		<br> Runtime: <form:input path="runningTime" />
		<br>

		<br>
		<input type="submit" value="Edit Movie" />
	</form:form>

</body>
</html>