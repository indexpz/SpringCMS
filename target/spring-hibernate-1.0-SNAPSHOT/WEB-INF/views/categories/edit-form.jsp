<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 02/06/2021
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edytuj kategorię</title>
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
    <form:hidden path="id"></form:hidden>
    <form:button type="submit">Dodaj</form:button>
</form:form>

</body>
</body>
</html>
