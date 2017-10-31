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
<h1>Aanvraag offerte</h1>
<h2>Stap 1</h2>
<form method='post' action="<c:url value='/offertes'/>">
    <div>Hier vraag je later de voornaam, familienaam en e-mail adres</div>
    <input type='submit' value='Volgende stap' name='volgende'>
</form>
</body>
</html>