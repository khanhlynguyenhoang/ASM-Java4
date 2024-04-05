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
                                <h4 class="card-title">Chi Tiet San Pham</h4>
                                <p class="card-description">
                                    <a href="/viewAddChiTietSanPham"
                                       class="btn btn-inverse-success">Add</a>
                                </p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <th>ID</th>
                                        <th>SanPham</th>
                                        <th>NhaSanXuat</th>
                                        <th>MauSac</th>
                                        <th>DongSanPham</th>
                                        <th>NamBanHang</th>
                                        <th>MoTa</th>
                                        <th>SoLuongTon</th>
                                        <th>GiaNhap</th>
                                        <th>GiaBan</th>
                                        <th>Action</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listCTSP}" var="ctsp">
                                            <tr>
                                                <td>${ctsp.id}</td>
                                                <td>${ctsp.sanPham.ten}</td>
                                                <td>${ctsp.nhaSanXuat.ten}</td>
                                                <td>${ctsp.mauSac.ten}</td>
                                                <td>${ctsp.dongSanPham.ten}</td>
                                                <td>${ctsp.namBH}</td>
                                                <td>${ctsp.moTa}</td>
                                                <td>${ctsp.soLuongTon}</td>
                                                <td>${ctsp.giaNhap}</td>
                                                <td>${ctsp.giaBan}</td>
                                                <td>
                                                    <a href="/DetailChiTietSanPham?id=${ctsp.id}"
                                                       class="btn btn-inverse-info">Detail</a>
                                                    <a href="/viewUpdateChiTietSanPham?id=${ctsp.id}"
                                                       class="btn btn-inverse-warning">Update</a>
                                                    <a href="/DeleteChiTietSanPham?id=${ctsp.id}"
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
