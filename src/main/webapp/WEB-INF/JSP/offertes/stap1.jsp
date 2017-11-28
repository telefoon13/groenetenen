<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Aanvraag offerte</h1>
<h2>Stap 1</h2>
<c:url value='/offertes' var='url'/>
<form:form action='${url}' commandName='offerte'>
<form:label path='voornaam'>Voornaam:<form:errors path='voornaam'/></form:label>
<form:input path='voornaam' autofocus='true' required='required'/>
<form:label path='familienaam'>Familienaam:<form:errors path='familienaam'/></form:label>
<form:input path='familienaam' required='required'/>
<form:label path='emailAdres'>E-mail adres:<form:errors path='emailAdres'/></form:label>
    <form:input path='emailAdres' required='required' type='email'/>
    <div>Telefoon nummers :</div>
    <c:forEach items='${offerte.telefoonNrs}' varStatus='status'>
        <div class='rij'><form:input path='telefoonNrs[${status.index}]' type='tel'/>
            <form:errors path='telefoonNrs[${status.index}]' cssClass='fout'/></div>
    </c:forEach>
    <input type='submit' value='Nog een telefoonnummer' name='nogeennummer' formnovalidate>
<input type='submit' value='Volgende stap' name='volgende'>
</form:form>
</body>
</html>