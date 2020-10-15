<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directors</title>
</head>
<body>

<h1>Add a director</h1>
<form action = "addDirectorServlet" method="post">
	Director Name:<input type="text" name="directorName">
	<input type="submit" value="Add Director">
</form>

<form action = "directorNavigationServlet" method = "post">
<h1>List of all directors</h1>
<table>
	<c:forEach items="${requestScope.allDirectors }" var="currentdirector">
		<tr>
		<td><input type="radio" name="id" value="${currentdirector.id }"></td>
		<td>Name: ${currentdirector.name }</td>
		</tr>
	</c:forEach>
</table>
<!-- Buttons to edit, delete, and add new director -->
<input type ="submit" value ="edit" name="doThisToDirector">
<input type ="submit" value ="delete" name="doThisToDirector"><br/>
<a href="viewAllMoviesServlet">View all movies</a><br/>
</form>
</body>
</html>