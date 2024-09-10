<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista Przystanków</title>
</head>
<body>
<h1>Lista przystanków</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Adres początkowy</th>
        <th>Adres końcowy</th>
        <th>Akcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="przystanek" items="${przystanki}">
        <tr>
            <td>${przystanek.id_PR}</td>
            <td>${przystanek.dystans}</td>
            <td>${przystanek.czas}</td>
            <td>${przystanek.adres_pocz}</td>
            <td>${przystanek.adres_kon}</td>
            <td>
                <a href="editPrzystanekForm.jsp?id=${przystanek.id_PR}">Edytuj</a> |
                <a href="deletePrzystanek?id=${przystanek.id_PR}" onclick="return confirm('Czy na pewno chcesz usunąć ten przystanek?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href="addPrzystanek.jsp">Dodaj nowy przystanek</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
