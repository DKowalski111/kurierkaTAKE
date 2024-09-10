<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj Przystanek</title>
</head>
<body>
<h1>Edytuj przystanek</h1>
<form action="updatePrzystanek" method="post">
    <input type="hidden" name="id_PR" value="${przystanek.id_PR}"/>

    <label for="dystans">Dystans:</label>
    <input type="number" id="dystans" name="dystans" value="${przystanek.dystans}" required/><br/><br/>

    <label for="czas">Czas (HH:MM:SS):</label>
    <input type="time" id="czas" name="czas" value="${przystanek.czas}" required/><br/><br/>

    <label for="adres_pocz">Adres początkowy:</label>
    <input type="text" id="adres_pocz" name="adres_pocz" value="${przystanek.adres_pocz}" required/><br/><br/>

    <label for="adres_kon">Adres końcowy:</label>
    <input type="text" id="adres_kon" name="adres_kon" value="${przystanek.adres_kon}" required/><br/><br/>

    <input type="submit" value="Zaktualizuj"/>
</form>
<br/>
<a href="listPrzystanki">Powrót do listy przystanków</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
