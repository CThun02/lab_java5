<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
    <header>
        <h5 class="text-center mt-5 mb-5">Header Lab 3 from FPT Polytechnic</h5>
    </header>
    <section class="container">
        <div class="col-4 offset-md-4">
            <form:form action="/student/save" method="post" modelAttribute="st">
                <label>Tên</label>
                <form:input  class="form-control" path="name"/>
                <form:errors path="name" delimiter=";" element="div" cssClass="text-danger"/>
                <label>Email</label>
                <form:input  class="form-control" path="email"/>
                <form:errors path="email" delimiter=";" element="div" cssClass="text-danger"/>
                <label>Điểm</label>
                <form:input  class="form-control" path="marks"/>
                <form:errors path="marks" delimiter=";" element="div" cssClass="text-danger"/>
                <label>Giới tính</label>
                <div class="form-check">
                    <form:radiobutton path="gender" class="form-check-input" name="nam" value="true" id="nam" checked="checked"></form:radiobutton>
                    <label class="form-check-label" for="nam">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <form:radiobutton path="gender" class="form-check-input" name="nu" value="true" id="nu"></form:radiobutton>
                    <label class="form-check-label" for="nu">
                        Nữ
                    </label>
                </div>
                <form:errors path="gender" delimiter=";" element="div" cssClass="text-danger"/>
                <label class="d-block">Ngành học</label>
                <form:select  class="form-select" path="faculty">
                    <form:options items="${faculties}"></form:options>
                </form:select>
                <form:errors path="faculty" delimiter=";" element="div" cssClass="text-danger"/>
                <label class="d-block">Sở thích</label>
                <form:checkboxes path="hobbies" items="${hobbies}"></form:checkboxes>
                <form:errors path="hobbies" delimiter=";" element="div" cssClass="text-danger"/>
                <button type="submit" class="btn btn-success col-4 offset-md-4 mt-3">Save</button>
            </form:form>
        </div>
    </section>
    <footer>
        <h5 class="text-center mt-5">Footer Lab 3 from FPT Polytechnic</h5>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>