<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/4/2024
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="header.jsp" %>
</head>

<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <%@ include file="navbar.jsp" %>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_settings-panel.html -->
        <%@include file="setting.jsp" %>
        <!-- partial -->
        <!-- partial:../../partials/_sidebar.html -->
        <%@include file="slide-bar.jsp" %>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Cửa hàng</h4>
                                <p class="card-description">
                                    <a href="/viewAddCuaHang"
                                       class="btn btn-inverse-success">Add</a>
                                </p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Ma</th>
                                            <th>Tên</th>
                                            <th>Địa chỉ</th>
                                            <th>Thành phố</th>
                                            <th>Quốc gia</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listCH}" var="ch">
                                            <tr>
                                                <td>${ch.id}</td>
                                                <td>${ch.ma}</td>
                                                <td>${ch.ten}</td>
                                                <td>${ch.diaChi}</td>
                                                <td>${ch.thanhPho}</td>
                                                <td>${ch.quocGia}</td>
                                                <td>
                                                    <a href="/DetailCuaHang?id=${ch.id}"
                                                       class="btn btn-inverse-info">Detail</a>
                                                    <a href="/viewUpdateCuaHang?id=${ch.id}"
                                                       class="btn btn-inverse-warning">Update</a>
                                                    <a href="/DeleteCuaHang?id=${ch.id}"
                                                       class="btn btn-inverse-danger">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- content-wrapper ends -->
<!-- partial:../../partials/_footer.html -->
<%@include file="footer.jsp" %>
</body>

</html>
