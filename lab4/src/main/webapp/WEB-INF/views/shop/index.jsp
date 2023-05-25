<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping now</title>
</head>
<body>
<header>
    <h4>Shop product</h4>
</header>
<section>
    <ul style="list-style: none">
        <c:forEach items="${products}" var="product">
            <li>
               <p>Name: ${product.name}</p>
               <p>price: ${product.price}</p>
                <a href="/cart/add?id=${product.id}">Add to cart</a>
                <hr/>
            </li>
        </c:forEach>
    </ul>
</section>
<footer>
    <h4>footer shop product</h4>
</footer>
</body>
</html>