<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 03/06/2021
  Time: 12:12
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

    <title>Lista autorów</title>
</head>
<body>
<div><a href="/forms/author/create"><button>Ddodaj kategorię</button></a> </div>

<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Opcje</th>
    </tr>

        <c:forEach items="${authors}" var="author">
    <tr>
        <td>${author.id}</td>
        <td>${author.firstName}</td>
        <td>${author.lastName}</td>
        <td><a href="/forms/category/edit?id=${author.id}"><button>Edytuj</button></a> </td>
        <td><a href="/forms/category/delete?id=${author.id}"><button>Usuń</button></a> </td>
    </tr>
        </c:forEach>


</table>
</body>
</html>
