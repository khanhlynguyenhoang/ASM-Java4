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
                                <h4 class="card-title">Add Chi Tiet San Pham</h4>
                                <form class="forms-sample" action="/AddChiTietSanPham" method="post">
                                    <div class="form-group">
                                        <label>Ten San Pham</label>
                                        <select class="form-control" class="js-example-basic-single w-100"
                                                name="sanPham.id">
                                            <c:forEach items="${listSP}" var="sp">
                                                <option value="${sp.id}">${sp.ten}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                    <label>Ten nhà sản xuất</label>
                                    <select class="form-control" class="js-example-basic-single w-100"
                                            name="nhaSanXuat.id">
                                        <c:forEach items="${listNSX}" var="nsx">
                                            <option value="${nsx.id}">${nsx.ten}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group">
                                    <label>Ten màu sắc</label>
                                    <select class="form-control" class="js-example-basic-single w-100"
                                            name="mauSac.id">
                                        <c:forEach items="${listMS}" var="ms">
                                            <option value="${ms.id}">${ms.ten}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group">
                                    <label>Ten dòng sản phẩm</label>
                                    <select class="form-control" class="js-example-basic-single w-100"
                                            name="dongSanPham.id">
                                        <c:forEach items="${listDSP}" var="dsp">
                                            <option value="${dsp.id}">${dsp.ten}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Năm bán hàng</label>
                                        <input type="text" class="form-control" name="namBH">
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả</label>
                                        <input type="text" class="form-control" name="moTa">
                                    </div>
                                    <div class="form-group">
                                        <label>Số lượng tồn</label>
                                        <input type="text" class="form-control" name="soLuongTon">
                                    </div>
                                    <div class="form-group">
                                        <label>Giá nhập</label>
                                        <input type="text" class="form-control" name="giaNhap">
                                    </div>
                                    <div class="form-group">
                                        <label>Giá bán</label>
                                        <input type="text" class="form-control" name="giaBan">
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
