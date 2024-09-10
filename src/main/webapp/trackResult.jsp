<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Szczegóły paczki</title>
</head>
<body>
<h1>Szczegóły paczki</h1>
<p><strong>ID paczki:</strong> ${paczka.id_P}</p>
<p><strong>Miejsce nadania:</strong> ${paczka.miejsce_nad}</p>
<p><strong>Miejsce dostarczenia:</strong> ${paczka.miejsce_dost}</p>
<p><strong>Data nadania:</strong> ${paczka.data_nad}</p>
<p><strong>Status:</strong> ${paczka.status}</p>
<p><strong>Rozmiar:</strong> ${paczka.rozmiar}</p>
<p><strong>Waga:</strong> ${paczka.waga}</p>
</body>

<a href="index.jsp">Wróć do strony głównej</a>

</html>
