<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Utwórz autora</title>
    <meta charset="UTF-8">

    <c:import url="../header_foter/header.jsp"></c:import>

</head>
<body>


<form:form method="post" modelAttribute="article">
    <label>Imię:
        <form:input path="firstName"/>
    </label><br/>
    <label>Nazwisko:
        <form:input path="lastName"/>
    </label><br/>

    <form:button type="submit">Dodaj</form:button>
</form:form>
</body>
</html>