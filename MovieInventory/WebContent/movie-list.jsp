<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Movies</title>
</head>
<body>

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
</body>
</html>