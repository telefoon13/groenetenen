<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen</h1>
<form:form commandName='afschrijvenForm'>
    <form:label path='filialen'>Filiaal:<form:errors path='filialen'/></form:label>
    <%--
    Enkele Selectie
    List box
    <form:select items='${filialen}' itemLabel='naam' itemValue='id' path='filiaal' size='5'/>
    RadioButtens
    <form:radiobuttons items='${filialen}' itemLabel='naam' itemValue='id' path='filiaal' element='div'/>

    Dubbele Selectie
    listbox
    <form:select items='${filialen}' itemLabel='naam' itemValue='id' path='filialen' size='5' multiple='multiple'/>
    Checkboxes
    --%>
    <form:checkboxes items='${filialen}' itemLabel='naam' itemValue='id' path='filialen' element='div'/>
    <input type='submit' value='Afschrijven'/>
</form:form>
</body>
</html>