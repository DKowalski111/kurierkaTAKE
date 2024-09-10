<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dodaj paczkę</title>
</head>
<body>
<h1>Dodaj nową paczkę</h1>
<form action="addPaczka" method="post">
  <label for="miejsceNadania">Miejsce nadania:</label>
  <input type="text" id="miejsceNadania" name="miejsceNadania" required><br><br>

  <label for="miejsceDostarczenia">Miejsce dostarczenia:</label>
  <input type="text" id="miejsceDostarczenia" name="miejsceDostarczenia" required><br><br>

  <label for="dataNadania">Data nadania:</label>
  <input type="text" id="dataNadania" name="dataNadania" required><br><br>

  <label for="status">Status paczki:</label>
  <input type="text" id="status" name="status" required><br><br>

  <label for="rozmiar">Rozmiar paczki:</label>
  <input type="text" id="rozmiar" name="rozmiar" required><br><br>

  <label for="waga">Waga paczki:</label>
  <input type="number" step="0.01" id="waga" name="waga" required><br><br>

  <button type="submit">Dodaj paczkę</button>
</form>

<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
