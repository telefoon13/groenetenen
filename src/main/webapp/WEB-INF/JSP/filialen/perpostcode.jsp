<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Filialen per postcode</h1>
<c:url value='/filialen' var='url'/>
<form:form action='${url}' commandName='postcodeReeks' method='get'>
    <form:label path='vanpostcode'>Van:<form:errors path="vanpostcode"/></form:label>
    <form:input path='vanpostcode' autofocus='autofocus'/>
    <form:label path='totpostcode'>Tot:<form:errors path="totpostcode"/></form:label>
    <form:input path='totpostcode'/>
    <input type='submit' value='Zoeken'>
    <form:errors cssClass="fout"/>
</form:form>
<c:forEach items='${filialen}' var='filiaal'>
    <spring:url var='url' value='/filialen/{id}'>
        <spring:param name='id' value='${filiaal.id}'/>
    </spring:url>
    <h2><a href='${url}'>${filiaal.naam}</a></h2>
    <p>${filiaal.adres.straat} ${filiaal.adres.huisNr}<br>
            ${filiaal.adres.postcode} ${filiaal.adres.gemeente}</p>
</c:forEach>
</body>
</html>