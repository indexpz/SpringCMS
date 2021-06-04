<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Utwórz autora</title>
    <meta charset="UTF-8">



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
        <form:input path="created" type="text"/>
    </label><br/>
    <label>Autorzy:
        <form:select path="author" items="${allAuthors}" itemLabel="fullName" itemValue="id" multiple="false"/>
    </label><br/>
    <label>Kategorie:
        <form:select path="categories" items="${allCategories}" itemLabel="name" itemValue="id" multiple="true"/>
    </label><br/>

    <form:button type="submit">Dodaj</form:button>
</form:form>
</div>
</body>
</html>