<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bài 4 - Lab 2</title>
</head>
<body>
<form:form action="/bai4/save" method="post" modelAttribute="product">
    <label>Name</label>
    <form:input path="name"/><br>
    <label>Price</label>
    <form:input path="price"/><br>
    <button>Save</button>
</form:form>
<ul style="list-style: none">
    <li>Name: ${productDef.name}</li>
    <li>Price: ${productDef.price}</li>
</ul>
<ul style="list-style: none">
    <li>Name: ${product.name}</li>
    <li>Price: ${product.price}</li>
</ul>
<ul style="list-style: none">
    <c:forEach var="pro" items="${products}">
    <li>${pro.name}</li>
    <li>${pro.price}</li>
    </c:forEach>
</ul>
</body>
</html>