<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Śledź paczkę</title>
</head>
<body>
<h1>Śledź paczkę</h1>
<form action="trackPaczka" method="post">
    <label for="idPaczki">Wprowadź ID paczki:</label>
    <input type="number" id="idPaczki" name="idPaczki" required><br><br>
    <button type="submit">Śledź paczkę</button>
</form>

<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
