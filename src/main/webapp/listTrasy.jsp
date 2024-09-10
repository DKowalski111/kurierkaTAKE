<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista Tras</title>
</head>
<body>
<h1>Lista tras</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Przystanki</th>
        <th>Akcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="trasa" items="${trasy}">
        <tr>
            <td>${trasa.id_T}</td>
            <td>${trasa.dystans}</td>
            <td>${trasa.czas}</td>
            <td>
                <c:forEach var="przystanek" items="${trasa.lista_przystankow}">
                    ${przystanek.adres_pocz} - ${przystanek.adres_kon}<br/>
                </c:forEach>
            </td>
            <td>
                <a href="editTrasaForm.jsp?id=${trasa.id_T}">Edytuj</a> |
                <a href="deleteTrasa?id=${trasa.id_T}" onclick="return confirm('Czy na pewno chcesz usunąć tę trasę?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href="addTrasa.jsp">Dodaj nową trasę</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
