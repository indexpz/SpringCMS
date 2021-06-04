<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 02/06/2021
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style><%@include file="../css/style.css"%></style>

</head>
<body style="padding: 0; margin: 0; border-box: 0;">
<div style="width: 100%; height: 30px; background-color: #010536; display: flex; align-items: center;" >
<a href="/forms/article/list"><button>Lista artykułów</button></a>
<a href="/forms/author/list"><button>Lista autorów</button></a>
<a href="/forms/category/list"><button>Lista kategorii</button></a>
</div>
</body>
</html>
