<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies</title>
</head>
<body>
<h1>Add a movie</h1>
<form action = "addMovieServlet" method="post">
	Movie Title:<input type="text" name="title"><br>
	Date Released:<input type="text" name="year" placeholder="yyyy" size="4"><input type="text" name="month" placeholder="mm" size="4"><input type="text" name="day" placeholder="dd" size="4"><br>
	Director:
	<select name="directorToAdd">
	<c:forEach items="${requestScope.allDirectors }" var="currentdirector">
	<option value="${currentdirector.id }">${currentdirector.name }</option>
	</c:forEach>
	</select>
	<br><input type="submit" value="Add Movie">
</form>

<form action = "movieNavigationServlet" method = "post">
<h1>List of all movies</h1>
<table>
	<c:forEach items="${requestScope.allMovies }" var="currentmovie">
		<tr>
		<td><input type="radio" name="id" value="${currentmovie.id }"></td>
		<td>Title: ${currentmovie.title }</td>
		<td>Date Released: ${currentmovie.dateReleased }</td>
		<td>Director: ${currentmovie.director.getName()}</td>
		</tr>
	</c:forEach>
</table>
<!-- Buttons to edit and delete director -->
<input type ="submit" value ="edit" name="doThisToMovie">
<input type ="submit" value ="delete" name="doThisToMovie"><br/>
<a href="viewAllDirectorsServlet">View all directors</a>
</form>
</body>
</html>