<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen - Filialen"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen - Filialen</h1>
<c:forEach var="filiaal" items="${filialen}">
    <h2>${filiaal.naam}</h2>
    <p>${filiaal.adres.straat} ${filiaal.adres.huisNr} <br>
            ${filiaal.adres.postcode} ${filiaal.adres.gemeente}</p>
</c:forEach>
</body>
</html>