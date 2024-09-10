<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj Klienta</title>
</head>
<body>
<h1>Edytuj klienta</h1>
<form action="editKlient" method="post">
    <input type="hidden" name="id_K" value="${klient.id_K}"/>

    <label for="imie">Imię:</label>
    <input type="text" id="imie" name="imie" value="${klient.imie}" required/><br/><br/>

    <label for="nazwisko">Nazwisko:</label>
    <input type="text" id="nazwisko" name="nazwisko" value="${klient.nazwisko}" required/><br/><br/>

    <label for="data_ur">Data urodzenia:</label>
    <input type="date" id="data_ur" name="data_ur" value="${klient.data_ur}" required/><br/><br/>

    <label for="nr_tel">Numer telefonu:</label>
    <input type="text" id="nr_tel" name="nr_tel" value="${klient.nr_tel}" required/><br/><br/>

    <label for="adres">Adres:</label>
    <input type="text" id="adres" name="adres" value="${klient.adres}" required/><br/><br/>

    <input type="submit" value="Zapisz zmiany"/>
</form>
<br/>
<a href="listKlienci">Powrót do listy klientów</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
