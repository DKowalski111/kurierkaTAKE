<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edytuj Samochód</title>
</head>
<body>
<h1>Edytuj samochód</h1>
<form action="updateSamochod" method="post">
  <input type="hidden" name="id_S" value="${samochod.id_S}"/>

  <label for="marka">Marka:</label>
  <input type="text" id="marka" name="marka" value="${samochod.marka}" required/><br/><br/>

  <label for="model">Model:</label>
  <input type="text" id="model" name="model" value="${samochod.model}" required/><br/><br/>

  <label for="rok_produkcji">Rok produkcji:</label>
  <input type="number" id="rok_produkcji" name="rok_produkcji" value="${samochod.rok_produkcji}" required/><br/><br/>

  <label for="numer_rej">Numer rejestracyjny:</label>
  <input type="text" id="numer_rej" name="numer_rej" value="${samochod.numer_rej}" required/><br/><br/>

  <label for="przebieg">Przebieg:</label>
  <input type="number" id="przebieg" name="przebieg" value="${samochod.przebieg}" required/><br/><br/>

  <label for="ilosc_paczek">Ilość paczek:</label>
  <input type="number" id="ilosc_paczek" name="ilosc_paczek" value="${samochod.ilosc_paczek}" required/><br/><br/>

  <label for="dostepnosc">Dostępność:</label>
  <select id="dostepnosc" name="dostepnosc" required>
    <option value="true" ${samochod.dostepnosc ? "selected" : ""}>Dostępny</option>
    <option value="false" ${!samochod.dostepnosc ? "selected" : ""}>Niedostępny</option>
  </select><br/><br/>

  <input type="submit" value="Zaktualizuj"/>
</form>
<br/>
<a href="listSamochody">Powrót do listy samochodów</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
