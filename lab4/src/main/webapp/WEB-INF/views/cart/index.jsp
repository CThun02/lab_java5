<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping now</title>
</head>
<body>
<header>
    <h4>Your cart</h4>
</header>
<section>
    <table border="1" style="width:100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${cartitems}">
            <form action="/cart/update/${item.id}" method="post">
                <input type="hidden" name="id" value="${item.id}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><input name="quantity" value="${item.quantity}"
                               onblur="this.form.submit()" style="width:50px;"></td>
                    <td>${item.price * item.quantity}</td>
                    <td>
                        <a href="/cart/remove/${item.id}">Remove</a>
                    </td>
                </tr>
            </form>
            ${mess}
        </c:forEach>
    </table>
    <a href="/cart/clear">Clear Cart</a>
    <a href="/shop/shopping">Add more</a>
</section>
<footer>
    <h4>footer shop cart</h4>
</footer>
</body>
</html>