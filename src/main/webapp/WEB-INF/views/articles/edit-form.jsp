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
    <title>Edytuj autora</title>


</head>
<body>
<c:import url="../header_foter/header.jsp"></c:import>
<div>
    <form:form method="post" modelAttribute="article">
        <label>Tytuł:
            <form:input path="title"/>
        </label><br/>
        <label>Treść:
            <form:input path="content" type="textfield" row="20" col="20"/>
        </label><br/>
        <label>Data utworzenia:
            <form:input path="updated" type="text"/>
        </label><br/>
        <label>Autorzy:
            <form:select path="author" items="${allAuthors}" itemLabel="fullName" itemValue="id" multiple="false"/>
        </label><br/>
        <label>Kategorie:
            <form:select path="categories" items="${allCategories}" itemLabel="name" itemValue="id" multiple="true"/>
        </label><br/>

        <form:hidden path="id"></form:hidden>
        <form:button type="submit">Dodaj</form:button>
    </form:form>
</div>

</body>
</body>
</html>
