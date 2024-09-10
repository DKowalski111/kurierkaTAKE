<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj Nowy Samochód</title>
</head>
<body>
<h1>Dodaj nowy samochód</h1>
<form action="addSamochod" method="post">
    <label for="marka">Marka:</label>
    <input type="text" id="marka" name="marka" required/><br/><br/>

    <label for="model">Model:</label>
    <input type="text" id="model" name="model" required/><br/><br/>

    <label for="rok_produkcji">Rok produkcji:</label>
    <input type="number" id="rok_produkcji" name="rok_produkcji" required/><br/><br/>

    <label for="numer_rej">Numer rejestracyjny:</label>
    <input type="text" id="numer_rej" name="numer_rej" required/><br/><br/>

    <label for="przebieg">Przebieg:</label>
    <input type="number" id="przebieg" name="przebieg" required/><br/><br/>

    <label for="ilosc_paczek">Ilość paczek:</label>
    <input type="number" id="ilosc_paczek" name="ilosc_paczek" required/><br/><br/>

    <label for="dostepnosc">Dostępność:</label>
    <select id="dostepnosc" name="dostepnosc" required>
        <option value="true">Dostępny</option>
        <option value="false">Niedostępny</option>
    </select><br/><br/>

    <input type="submit" value="Dodaj samochód"/>
</form>
<br/>
<a href="listSamochody">Powrót do listy samochodów</a>
<a href="index.jsp">Wróć do strony głównej</a>

</body>
</html>
