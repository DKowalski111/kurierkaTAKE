<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj Klienta</title>
</head>
<body>
<h1>Dodaj nowego klienta</h1>
<form action="addKlient" method="post">
    <label for="imie">Imię:</label>
    <input type="text" id="imie" name="imie" required/><br/><br/>

    <label for="nazwisko">Nazwisko:</label>
    <input type="text" id="nazwisko" name="nazwisko" required/><br/><br/>

    <label for="data_ur">Data urodzenia:</label>
    <input type="date" id="data_ur" name="data_ur" required/><br/><br/>

    <label for="nr_tel">Numer telefonu:</label>
    <input type="text" id="nr_tel" name="nr_tel" required/><br/><br/>

    <label for="adres">Adres:</label>
    <input type="text" id="adres" name="adres" required/><br/><br/>

    <input type="submit" value="Dodaj klienta"/>
</form>
<br/>
<a href="index.jsp">Powrót do strony głównej</a>
</body>
</html>
