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
    <title>Lista artykułów</title>


</head>
<body>
<c:import url="../header_foter/header.jsp"></c:import>
<div><a href="/forms/article/create"><button>Dodaj artykuł</button></a> </div>
<div>
<table>
    <tr>
        <th>Id</th>
        <th>Tytuł</th>
        <th>Kontent</th>
        <th>Data utworzenia</th>
        <th>Data modyfikacji</th>
        <th>Autor</th>
        <th>Kategorie</th>
        <th>Opcje</th>
    </tr>

        <c:forEach items="${articles}" var="article">
    <tr>
        <td>${article.id}</td>
        <td>${article.title}</td>
        <td>${article.content}</td>
        <td>${article.created}</td>
        <td>${article.updated}</td>
        <td>${article.author.fullName}</td>
        <td><ul><c:forEach items="${category}" var="category">
            <li>${category.name}</li>
        </c:forEach></ul> </td>
        <td><a href="/forms/article/edit?id=${article.id}"><button>Edytuj</button></a> </td>
        <td><a href="/forms/article/delete?id=${article.id}"><button>Usuń</button></a> </td>
    </tr>
        </c:forEach>
</div>
<div>
    <img src="<%=request.getContextPath()%>../img/1.png" width="200" height="150">
    <img src="../img/1.png" alt="Pasja informatyki" width="200" height="150">
</div>

</table>
</body>
</html>
