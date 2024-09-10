<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj Paczkę</title>
</head>
<body>
<h2>Edytuj Paczkę</h2>
<form action="updatePaczka" method="post">
    <input type="hidden" name="idP" value="${paczka.id_P}" />
    <label>Miejsce nadania:</label>
    <input type="text" name="miejsceNadania" value="${paczka.miejsce_nad}" /><br/>
    <label>Miejsce dostarczenia:</label>
    <input type="text" name="miejsceDostarczenia" value="${paczka.miejsce_dost}" /><br/>
    <label>Status:</label>
    <input type="text" name="status" value="${paczka.status}" /><br/>
    <label>Rozmiar:</label>
    <input type="text" name="rozmiar" value="${paczka.rozmiar}" /><br/>
    <label>Waga:</label>
    <input type="number" step="0.01" name="waga" value="${paczka.waga}" /><br/>
    <button type="submit">Zapisz zmiany</button>
</form>

<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
