<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h2>Stap 2</h2>
<form method='post'>
    <div> Hier vraag je later de oppervlakte van het gazon</div>
    <input type='submit' value='Vorige stap' name='vorige'>
    <input type='submit' value='Bevestigen' name='bevestigen'>
</form>
</body>
</html>