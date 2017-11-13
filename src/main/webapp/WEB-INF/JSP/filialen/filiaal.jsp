<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<c:choose>
<c:when test="${not empty filiaal}">
<h1>${filiaal.naam}</h1>
<dl><dt>Straat</dt><dd>${filiaal.adres.straat}</dd>
    <dt>Huisnr.</dt><dd>${filiaal.adres.huisNr}</dd>
    <dt>Postcode</dt><dd>${filiaal.adres.postcode}</dd>
    <dt>Gemeente</dt><dd>${filiaal.adres.gemeente}</dd>
    <dt>Type</dt><dd>${filiaal.hoofdFiliaal ? "Hoofdfiliaal" : "Bijfiliaal"}</dd>
    <dt>Waarde gebouw</dt>
    <dd>&euro; <fmt:formatNumber value='${filiaal.waardeGebouw}'/></dd>
    <dt>Ingebruikname</dt>
    <fmt:parseDate value="${filiaal.inGebruikName}" pattern="yyyy-MM-dd" var="inGebruikNameAlsDate" type="date"/>
    <dd><fmt:formatDate value='${inGebruikNameAlsDate}' type="date" dateStyle="short"/></dd></dl>
</c:when>
    <c:otherwise>
        <div class='fout'>Filiaal niet gevonden</div>
    </c:otherwise>
</c:choose>
</body>
</html>