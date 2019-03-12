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
<title>Insert title here</title>
</head>
<body>
	<h2>Add a Movie</h2>
	<c:url var="url" value="/AddMovie" />
	<form:form action="${url}" method="post" modelAttribute="movie">

		<br>
		<br> Title: <form:input path="title" />
		<br>
		<br>Genre: <form:select items="${movie.genreList}" path="genre" />
		<br>
		<br> Runtime: <form:input path="runningTime" />
		<br>

		<br>
		<input type="submit" value="Add Movie" />
	</form:form>

</body>
</html>