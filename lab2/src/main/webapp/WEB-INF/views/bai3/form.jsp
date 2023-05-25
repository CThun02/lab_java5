<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bài 3 - Lab 2</title>
</head>
<body>
<form:form action="/product/save" method="post" modelAttribute="product">
    <label>Name</label>
    <form:input path="name"/><br>
    <label>Price</label>
    <form:input path="price"/><br>
    <button>Save</button>
</form:form>
<ul style="list-style: none">
    <li>Name: ${product.name}</li>
    <li>Price: ${product.price}</li>
</ul>
</body>
</html>