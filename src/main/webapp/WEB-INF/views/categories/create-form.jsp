<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Utwórz kategorię</title>
    <c:import url="../header_foter/header.jsp"></c:import>

</head>
<body>


<form:form method="post" modelAttribute="category">
    <label>Nazwa:
        <form:input path="name"/>
    </label><br/>

    <label>Opis:
        <form:textarea path="description"/>
    </label>

    <form:button type="submit">Dodaj</form:button>
</form:form>
</body>
</html>