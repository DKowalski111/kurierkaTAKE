<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj Przystanek</title>
</head>
<body>
<h1>Dodaj nowy przystanek</h1>
<form action="addPrzystanek" method="post">
    <label for="dystans">Dystans:</label>
    <input type="number" id="dystans" name="dystans" required/><br/><br/>

    <label for="czas">Czas (HH:MM:SS):</label>
    <input type="time" id="czas" name="czas" required/><br/><br/>

    <label for="adres_pocz">Adres początkowy:</label>
    <input type="text" id="adres_pocz" name="adres_pocz" required/><br/><br/>

    <label for="adres_kon">Adres końcowy:</label>
    <input type="text" id="adres_kon" name="adres_kon" required/><br/><br/>

    <input type="submit" value="Dodaj"/>
</form>
<br/>
<a href="listPrzystanki">Powrót do listy przystanków</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
