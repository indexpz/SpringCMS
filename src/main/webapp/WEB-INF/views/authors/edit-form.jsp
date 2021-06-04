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
    <c:import url="../header_foter/header.jsp"></c:import>

    <title>Edytuj autora</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <label>Imię:
        <form:input path="firstName"/>
    </label><br/>
    <label>Nazwisko:
        <form:input path="lastName"/>
    </label><br/>

    <form:hidden path="id"></form:hidden>
    <form:button type="submit">Dodaj</form:button>
</form:form>

</body>
</body>
</html>
