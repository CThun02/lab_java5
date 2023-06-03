<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>product data</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
    <h4 class="text-center">Header of lab56 java5</h4>
</header>
<section class="container">
    <h5 class="text-center mt-5">Form product</h5>
    <div class="col-6 offset-md-3">
        <form:form action="${cateurl}" method="post" modelAttribute="category">
            <label>Tên</label>
            <form:input type="text" class="form-control"  id="" path="ten"/>
            <button type="submit" class="btn btn-primary col-6 offset-md-3 mt-3">${nameFunction}</button>
        </form:form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TÊN</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="item">
            <tr>
                <th scope="row">${item.ID}</th>
                <td>${item.ten}</td>
                <td>
                    <a href="/category/update?id=${item.ID}" class="btn btn-success">UPDATE</a>
                    <a href="/category/delete?id=${item.ID}" class="btn btn-danger">DELETE</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</section>
<footer>
    <h4 class="text-center">Footer of lab56 java5</h4>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>