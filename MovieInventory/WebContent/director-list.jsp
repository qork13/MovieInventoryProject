<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Directors</title>
</head>
<body>
<form action = "addDirectorServlet" method="post">
	Director Name:<input type="text" name="directorName">
	<input type="submit" value="Add Director">
</form>

<table>
	<c:forEach items="${requestScope.allDirectors }" var="currentdirector">
		<tr>
		<td><input type="radio" name="id" value="${currentdirector.id }"></td>
		<td>Title: ${currentdirector.name }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>