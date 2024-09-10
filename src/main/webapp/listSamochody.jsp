<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista samochodów</title>
</head>
<body>
<h1>Lista samochodów</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID Samochodu</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Rok produkcji</th>
        <th>Numer rejestracyjny</th>
        <th>Przebieg</th>
        <th>Ilość paczek</th>
        <th>Dostępność</th>
        <th>Akcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="samochod" items="${samochody}">
        <tr>
            <td>${samochod.id_S}</td>
            <td>${samochod.marka}</td>
            <td>${samochod.model}</td>
            <td>${samochod.rok_produkcji}</td>
            <td>${samochod.numer_rej}</td>
            <td>${samochod.przebieg}</td>
            <td>${samochod.ilosc_paczek}</td>
            <td>${samochod.dostepnosc ? "Tak" : "Nie"}</td>
            <td>
                <a href="editSamochodForm?id_S=${samochod.id_S}">Edytuj</a>
                <a href="deleteSamochod?id_S=${samochod.id_S}" onclick="return confirm('Czy na pewno chcesz usunąć ten samochód?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="index.jsp">Wróć do strony głównej</a>
</body>
</html>
