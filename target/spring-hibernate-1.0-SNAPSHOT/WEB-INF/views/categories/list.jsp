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
    <title>Lista kategorii</title>
    <c:import url="../header_foter/header.jsp"></c:import>

<%--    <link rel="stylesheet" type="text/css" href="../css/style.css"/>--%>
<%--    <link href="../css/style.css" rel="stylesheet" type="text/css">--%>
</head>

<body>
<div><a href="/forms/category/create"><button>Ddodaj kategorię</button></a> </div>
<div>
<table>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Opcje</th>
    </tr>

        <c:forEach items="${categories}" var="category">
    <tr>
        <td>${category.id}</td>
        <td>${category.name}</td>
        <td>${category.description}</td>
        <td><a href="/forms/category/edit?id=${category.id}"><button>Edytuj</button></a> </td>
        <td><a href="/forms/category/delete?id=${category.id}"><button>Usuń</button></a> </td>
    </tr>
        </c:forEach>
</div>
<div style="width: 100%;  height: auto; object-position: center"> <img src='<c:url value="../img/Zrzut%20ekranu%202021-06-1%20o%2012.22.56.png" ></c:url>' />
</div>
</table>
</body>
</html>
