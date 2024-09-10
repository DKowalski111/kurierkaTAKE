<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista klientów</title>
</head>
<body>
<h1>Lista klientów</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID Klienta</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data urodzenia</th>
        <th>Numer telefonu</th>
        <th>Adres</th>
        <th>Akcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="klient" items="${klienci}">
        <tr>
            <td>${klient.id_K}</td>
            <td>${klient.imie}</td>
            <td>${klient.nazwisko}</td>
            <td>${klient.data_ur}</td>
            <td>${klient.nr_tel}</td>
            <td>${klient.adres}</td>
            <td>
                <a href="editKlientForm?id_K=${klient.id_K}">Edytuj</a>
                <a href="deleteKlient?id_K=${klient.id_K}" onclick="return confirm('Czy na pewno chcesz usunąć tego klienta?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="index.jsp">Wróć do strony głównej</a>
</body>
</html>
