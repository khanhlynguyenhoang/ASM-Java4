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
                                <h4 class="card-title">Update Nhân Viên</h4>
                                <form class="forms-sample" action="/UpdateNhanVien?id=${nv.id}" method="post">
                                    <div class="form-group">
                                        <label>Mã</label>
                                        <input type="text" class="form-control" name="ma" value="${nv.ma}">
                                    </div>
                                    <div class="form-group">
                                        <label>Tên</label>
                                        <input type="text" class="form-control" name="ten" value="${nv.ten}">
                                    </div>
                                    <div class="form-group">
                                        <label>Tên đệm</label>
                                        <input type="text" class="form-control" name="tenDem" value="${nv.tenDem}">
                                    </div>
                                    <div class="form-group">
                                        <label>Họ</label>
                                        <input type="text" class="form-control" name="ho" value="${nv.ho}">
                                    </div>
                                    <div class="form-group">
                                        <label>Giới tính</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="gioiTinh">
                                            <option value="${nv.gioiTinh}" hidden selected>${nv.gioiTinh}</option>
                                            <option value="Nam">Nam</option>
                                            <option value="Nữ">Nữ</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày sinh</label>
                                        <input type="date" class="form-control" name="ngaySinh" value="${nv.ngaySinh}">
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}">
                                    </div>
                                    <div class="form-group">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control" name="sdt" value="${nv.sdt}">
                                    </div>
                                    <div class="form-group">
                                        <label>Mật khẩu</label>
                                        <input type="text" class="form-control" name="matKhau" value="${nv.matKhau}">
                                    </div>
                                    <div class="form-group">
                                        <label>Tên Cửa Hàng</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="cuaHang.id">
                                            <option value="${nv.cuaHang.id}" selected>${nv.cuaHang.ten}</option>
                                            <c:forEach items="${listCH}" var="ch">
                                                <option value="${ch.id}">${ch.ten}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Chức Vụ</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="chucVu.id">
                                            <option value="${nv.chucVu.id}" selected>${nv.chucVu.ten}</option>
                                            <c:forEach items="${listCV}" var="cv">
                                                <option value="${cv.id}">${cv.ten}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>ID Gửi báo cáo</label>
                                        <input type="text" class="form-control" name="idGuiBC" value="${nv.idGuiBC}">
                                    </div>
                                    <div class="form-group">
                                        <label>Trạng thái</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="trangThai">
                                            <option value="${nv.trangThai}" hidden
                                                    selected>${nv.trangThai ==0?'Đã nghỉ':'Đang làm việc'}</option>
                                            <option value="0">Đã nghỉ</option>
                                            <option value="1">Đang làm việc</option>
                                        </select>
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
