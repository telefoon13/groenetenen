<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen - Werknemers"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen - Werknemers</h1>

<table>
    <thead><tr>
        <th><c:url value="" var="url"><c:param name="sort" value="voornaam"/></c:url>
            <a href="${url}">Voornaam</a></th>
        <th><c:url value="" var="url"><c:param name="sort" value="familienaam"/></c:url>
            <a href="${url}">Familienaam</a></th>
        <th><c:url value="" var="url"><c:param name="sort" value="filiaal.naam"/></c:url>
            <a href="${url}">Filiaal</a></th></tr></thead>
    <tbody>
    <c:forEach items='${page.content}' var='werknemer'>
        <tr><td>${werknemer.voornaam}</td>
            <td>${werknemer.familienaam}</td>
            <td>${werknemer.filiaal.naam}</td></tr>
    </c:forEach>
    </tbody>
</table>
<p class='pagineren'>
    <c:forEach var="pageNr" begin="1" end="${page.totalPages}">
        <c:choose>
            <c:when test="${pageNr-1 == page.number}">
                ${pageNr}
            </c:when>
            <c:otherwise>
                <c:url value="" var="url">
                    <c:param name="page" value="${pageNr-1}"/>
                    <c:param name="sort" value="${param.sort}"/>
                </c:url>
                <a href="${url}">${pageNr}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</p>
</body>
</html>