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
                                <h4 class="card-title">Update Hóa Đơn</h4>
                                <form class="forms-sample" action="/UpdateHoaDon?id=${hd.id}" method="post">
                                    <div class="form-group">
                                        <label>Mã Khách Hàng</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="khachHang.id">
                                            <option value="${hd.khachHang.id}" selected>${hd.khachHang.ma}</option>
                                            <c:forEach items="${listKH}" var="kh">
                                                <option value="${kh.id}">${kh.ma}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Mã Nhân Viên</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="nhanVien.id">
                                            <option value="${hd.nhanVien.id}" selected>${hd.nhanVien.ma}</option>
                                            <c:forEach items="${listNV}" var="nv">
                                                <option value="${nv.id}">${nv.ma}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Mã Hóa Đơn</label>
                                        <input type="text" class="form-control" name="ma" value="${hd.ma}">
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày tạo</label>
                                        <input type="date" class="form-control" name="ngayTao" value="${hd.ngayTao}">
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày thanh toán</label>
                                        <input type="date" class="form-control" name="ngayThanhToan" value="${hd.ngayThanhToan}">
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày ship</label>
                                        <input type="date" class="form-control" name="ngayShip" value="${hd.ngayShip}">
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày nhân</label>
                                        <input type="date" class="form-control" name="ngayNhan" value="${hd.ngayNhan}">
                                    </div>
                                    <div class="form-group">
                                        <label>Tình trạng</label>
                                        <input type="text" class="form-control" name="tinhTrang" value="${hd.tinhTrang}">
                                    </div>
                                    <div class="form-group">
                                        <label>Tên người nhận</label>
                                        <input type="text" class="form-control" name="tenNguoiNhan" value="${hd.tenNguoiNhan}">
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="diaChi" value="${hd.diaChi}">
                                    </div>
                                    <div class="form-group">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control" name="sdt" value="${hd.sdt}">
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
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
