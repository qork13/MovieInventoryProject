<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Movie</title>
</head>
<body>
<form action = "editMovieServlet" method="post">
	<input type ="hidden" name ="id"value="${movieToEdit.id}">
	Movie Title:<input type="text" name="title" value="${movieToEdit.title}"><br>
	Date Released:<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"><input type="text" name="month" placeholder="mm" size="4"value="${month}" ><input type="text" name="day" placeholder="dd" size="4" value="${date}" ><br>
	Director:
	<select name="directorsToEdit">
	<c:forEach items="${requestScope.directorsToEdit }" var="currentdirector">
	<option value="${currentdirector.id}">${currentdirector.name}</option>
	</c:forEach>
	</select>
	<br><input type="submit" value="Edit Movie">
</form><br/>
<a href ="movie-list.jsp">Go add new movies instead.</a>
</body>
</html>