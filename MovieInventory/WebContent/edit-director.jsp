<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Director</title>
</head>
<body>
<!-- Form to edit the pet -->
<form action ="editDirectorServlet" method="post">
<!-- Text inputs to update the records -->
Name: <input type ="text" name ="name" value="${directorToEdit.name}">
<input type ="hidden" name ="id"value="${directorToEdit.id}">
<input type ="submit" value="Save Edited Item">
</form>
</body>
</html>