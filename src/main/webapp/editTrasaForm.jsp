<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj Trasę</title>
</head>
<body>
<h1>Edytuj trasę</h1>
<form action="updateTrasa" method="post">
    <input type="hidden" name="id_T" value="${trasa.id_T}"/>

    <label for="dystans">Dystans:</label>
    <input type="number" id="dystans" name="dystans" value="${trasa.dystans}" required/><br/><br/>

    <label for="czas">Czas (HH:MM:SS):</label>
    <input type="time" id="czas" name="czas" value="${trasa.czas}" required/><br/><br/>

    <label for="przystanki">Przystanki (ID, oddzielone przecinkami):</label>
    <input type="text" id="przystanki" name="przystanki" value="${trasa.przystankiIds}"/><br/><br/>

    <input type="submit" value="Zaktualizuj"/>
</form>
<br/>
<a href="listTrasy">Powrót do listy tras</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
