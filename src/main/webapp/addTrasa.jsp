<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Dodaj Trasę</title>
</head>
<body>
<h1>Dodaj nową trasę</h1>
<form action="addTrasa" method="post">
  <label for="dystans">Dystans:</label>
  <input type="number" id="dystans" name="dystans" required/><br/><br/>

  <label for="czas">Czas (HH:MM:SS):</label>
  <input type="time" id="czas" name="czas" required/><br/><br/>

  <label for="przystanki">Przystanki (ID, oddzielone przecinkami):</label>
  <input type="text" id="przystanki" name="przystanki"/><br/><br/>

  <input type="submit" value="Dodaj"/>
</form>
<br/>
<a href="listTrasy">Powrót do listy tras</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
