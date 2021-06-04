<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 02/06/2021
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuwanie autora</title>
    <c:import url="../header_foter/header.jsp"></c:import>

</head>
<body>

<form method="post" action="">
    <p>Czy usunąć kategorię: ${author.fullName} o id = ${author.id}</p>
    <p>
        <input type="hidden" name="id" value="${author.id}">
        <a href="/forms/author/list">
            <button>Nie</button>
        </a>
        <button type="submit">Tak</button>
    </p>
</form>

</body>
</html>
