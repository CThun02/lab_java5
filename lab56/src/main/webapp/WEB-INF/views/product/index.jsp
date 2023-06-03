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
    <div class="col-6 float-start pe-5">
        <form:form action="${url}" method="post" modelAttribute="product" enctype="multipart/form-data">
            <label>Mã</label>
            <form:input type="text" class="form-control"  id="" path="ma"/>
            <label>Tên</label>
            <form:input type="text" class="form-control"  id="" path="ten"/>
            <label>Giá</label>
            <form:input type="number" class="form-control"  id="" path="gia"/>
            <label>Ngày Tạo</label>
            <form:input type="Date" class="form-control" id="" path="ngayTao" value="${product.getNgayTao()}"/>
            <label>Số lương tồn</label>
            <form:input type="number" class="form-control"  id="" path="soLuongTon"/>
            <label>IMG</label><br>
            <img src="${img}" width="240" alt="" srcset="">
            <input type="file" class="form-control"  id="" name="imgUpload"/>
            <label>Loại</label>
            <form:select class="form-select" id="" path="category">
                <form:options items="${categories}" itemLabel="ten"></form:options>
            </form:select>
            <button type="submit" class="btn btn-primary col-6 offset-md-3 mt-3">${nameFunction}</button>
        </form:form>
    </div>
    <div class="col-6 float-end">
        <form action="/product/searchbyprice" method="get">
            <h6>Search by price</h6>
            <label>Giá trị min</label>
            <input type="number" class="form-control mb-3" name="pricemin">
            <label>Giá trị max</label>
            <input type="number" class="form-control mb-3" name="pricemax">
            <button type="submit" class="btn btn-success">Search</button>
        </form>
        <form action="/product/searchbyname" method="get">
            <h6>Search by name</h6>
            <label>Tên sản phẩm</label>
            <input type="text" class="form-control mb-3" name="pricemin">
            <button type="submit" class="btn btn-success">Search</button>
        </form>
        <select class="form-select">
            <option value="">Chọn để lọc sản phẩm theo loại</option>
            <c:forEach items="${categories}" var="item">
                <option value="${item.ID}">${item.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">MÃ</th>
                <th scope="col">TÊN</th>
                <th scope="col">GIÁ</th>
                <th scope="col">NGÀY TẠO</th>
                <th scope="col">SỐ LƯỢNG</th>
                <th scope="col">Loại</th>
                <th scope="col">ACTION</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="item">
            <tr>
                <th scope="row">${item.ma}</th>
                <td>${item.ten}</td>
                <td>${item.gia}</td>
                <td>${item.ngayTao}</td>
                <td>${item.soLuongTon}</td>
                <td>${item.category.ten}</td>
                <td>
                    <a href="/product/update?id=${item.ID}" class="btn btn-success">UPDATE</a>
                    <a href="/product/delete?id=${item.ID}" class="btn btn-danger">DELETE</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-2 offset-md-5">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/product/previous">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">${pagenumber}</a></li>
                <li class="page-item"><a class="page-link" href="/product/next">Next</a></li>
            </ul>
        </nav>
    </div>
</section>
<footer>
    <h4 class="text-center">Footer of lab56 java5</h4>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>