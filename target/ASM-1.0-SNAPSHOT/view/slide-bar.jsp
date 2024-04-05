<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/4/2024
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Quản lý sản phẩm</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="/HienThiSanPham">Sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiChiTietSanPham">Chi tiết sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiMauSac">Màu sắc</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiDongSP">Dòng sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiNSX">Nhà sản xuất</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/HienThiKhachHang">
                <i class="icon-head menu-icon"></i>
                <span class="menu-title">Quản lý khách hàng</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#cuahang" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Quản lý cửa hàng</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="cuahang">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="/HienThiCuaHang">Cửa hàng</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiNhanVien">Nhân viên</a></li>
                    <li class="nav-item"><a class="nav-link" href="/HienThiChucVu">Chức vụ</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#hoaDon" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Quản lý hóa đơn</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="hoaDon">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="/HienThiHoaDon">Hóa đơn</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/HienThiGioHang">
                <i class="icon-head menu-icon"></i>
                <span class="menu-title">Giỏ hàng</span>
            </a>
        </li>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">--%>
        <%--                <i class="icon-columns menu-icon"></i>--%>
        <%--                <span class="menu-title">Form elements</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="form-elements">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"><a class="nav-link" href="pages/forms/basic_elements.html">Basic Elements</a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">--%>
        <%--                <i class="icon-bar-graph menu-icon"></i>--%>
        <%--                <span class="menu-title">Charts</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="charts">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/charts/chartjs.html">ChartJs</a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#tables" aria-expanded="false" aria-controls="tables">--%>
        <%--                <i class="icon-grid-2 menu-icon"></i>--%>
        <%--                <span class="menu-title">Tables</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="tables">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/tables/basic-table.html">Basic table</a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">--%>
        <%--                <i class="icon-contract menu-icon"></i>--%>
        <%--                <span class="menu-title">Icons</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="icons">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/icons/mdi.html">Mdi icons</a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">--%>
        <%--                <i class="icon-head menu-icon"></i>--%>
        <%--                <span class="menu-title">User Pages</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="auth">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/samples/login.html"> Login </a></li>--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/samples/register.html"> Register </a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" data-toggle="collapse" href="#error" aria-expanded="false" aria-controls="error">--%>
        <%--                <i class="icon-ban menu-icon"></i>--%>
        <%--                <span class="menu-title">Error pages</span>--%>
        <%--                <i class="menu-arrow"></i>--%>
        <%--            </a>--%>
        <%--            <div class="collapse" id="error">--%>
        <%--                <ul class="nav flex-column sub-menu">--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/samples/error-404.html"> 404 </a></li>--%>
        <%--                    <li class="nav-item"> <a class="nav-link" href="pages/samples/error-500.html"> 500 </a></li>--%>
        <%--                </ul>--%>
        <%--            </div>--%>
        <%--        </li>--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" href="pages/documentation/documentation.html">--%>
        <%--                <i class="icon-paper menu-icon"></i>--%>
        <%--                <span class="menu-title">Documentation</span>--%>
        <%--            </a>--%>
        <%--        </li>--%>
    </ul>
</nav>
