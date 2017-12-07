<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Groene tenen</h1>

<c:choose>
    <c:when test='${empty fout}'>
        <h1>&euro; <fmt:formatNumber value='${euro}'/> is $
            <fmt:formatNumber value='${dollar}'/></h1>
    </c:when>
    <c:otherwise>
        <div class='fout'>${fout}</div>
    </c:otherwise>
</c:choose>

</body>
</html>