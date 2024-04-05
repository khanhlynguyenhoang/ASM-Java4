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
                                <h4 class="card-title">Update Cửa hàng</h4>
                                <form class="forms-sample" action="/UpdateCuaHang?id=${ch.id}" method="post">
                                    <div class="form-group">
                                        <label>Ma</label>
                                        <input type="text" class="form-control" name="ma" value="${ch.ma}">
                                    </div>
                                    <div class="form-group">
                                        <label>Ten</label>
                                        <input type="text" class="form-control" name="ten" value="${ch.ten}">
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}">
                                    </div>
                                    <div class="form-group">
                                        <label>Thành Phố</label>
                                        <input type="text" class="form-control" name="thanhPho" value="${ch.thanhPho}">
                                    </div>
                                    <div class="form-group">
                                        <label>Quốc gia</label>
                                        <input type="text" class="form-control" name="quocGia" value="${ch.quocGia}">
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
