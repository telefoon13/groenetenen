<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen - Login</h1>
<form method='post'>
    <label>Gebruikersnaam:<input name='username' autofocus required></label>
    <label>Paswoord:<input name='password' type='password' required></label>
    <security:csrfInput/>
    <input type='submit' value='Aanmelden'>
    <c:if test='${param.error != null}'>
        <div class='fout'>Verkeerde gebruikersnaam of paswoord.</div>
    </c:if>
</form>
</body>
</html>