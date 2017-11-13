<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen - Filialen"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen - Filialen</h1>
<c:forEach var="filiaal" items="${filialen}">
    <spring:url var='url' value='/filialen/{id}'>
        <spring:param name='id' value='${filiaal.id}'/>
    </spring:url>
    <h2><a href="${url}">${filiaal.naam}</a> </h2>
    <p>${filiaal.adres.straat} ${filiaal.adres.huisNr} <br>
            ${filiaal.adres.postcode} ${filiaal.adres.gemeente}</p>
</c:forEach>
</body>
</html>