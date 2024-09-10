<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista paczek</title>
</head>
<body>
<h1>Lista paczek</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID Paczki</th>
        <th>Miejsce nadania</th>
        <th>Miejsce dostarczenia</th>
        <th>Data nadania</th>
        <th>Status</th>
        <th>Rozmiar</th>
        <th>Waga</th>
        <th>Akcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="paczka" items="${paczki}">
        <tr>
            <td>${paczka.id_P}</td>
            <td>${paczka.miejsce_nad}</td>
            <td>${paczka.miejsce_dost}</td>
            <td>${paczka.data_nad}</td>
            <td>${paczka.status}</td>
            <td>${paczka.rozmiar}</td>
            <td>${paczka.waga}</td>
            <td>
                <a href="editPaczka?id_P=${paczka.id_P}">Edytuj</a>
                <a href="deletePaczka?id_P=${paczka.id_P}" onclick="return confirm('Czy na pewno chcesz usunąć tą paczkę?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="index.jsp">Wróć do strony głównej</a>
</body>
</html>
