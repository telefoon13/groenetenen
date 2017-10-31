<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen - Toevoegen van filiaal"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen - Toevoegen van filiaal</h1>
<form method="post" action="<c:url value="/filialen"/> ">
    <input type="submit" value="Toevoegen">
</form>
</body>
</html>