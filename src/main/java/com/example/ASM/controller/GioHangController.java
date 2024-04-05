package com.example.ASM.controller;

import com.example.ASM.entity.GioHang;
import com.example.ASM.entity.KhachHang;
import com.example.ASM.entity.NhanVien;
import com.example.ASM.request.GioHangRequest;
import com.example.ASM.service.imp.GioHangChiTietImp;
import com.example.ASM.service.imp.GioHangImp;
import com.example.ASM.service.imp.KhachHangImp;
import com.example.ASM.service.imp.NhanVienImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GioHangController", value = {
        "/HienThiGioHang",
        "/DetailGioHang",
        "/viewAddGioHang",
        "/viewUpdateGioHang",
        "/DeleteGioHang",
        "/AddGioHang",
        "/UpdateGioHang"
})
public class GioHangController extends HttpServlet {
    GioHangImp service = new GioHangImp();
    List<GioHang> listGH = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiGioHang")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailGioHang")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddGioHang")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateGioHang")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteGioHang")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GioHang GioHang = service.getOne(id);
        service.delete(GioHang);
        response.sendRedirect("/HienThiGioHang");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHangImp khachHangImp = new KhachHangImp();
        List<KhachHang> listKH = new ArrayList<>();
        listKH = khachHangImp.getAll();
        request.setAttribute("listKH",listKH);
        NhanVienImp nhanVienImp = new NhanVienImp();
        List<NhanVien> listNV = new ArrayList<>();
        listNV = nhanVienImp.getAll();
        request.setAttribute("listNV",listNV);
        int id = Integer.parseInt(request.getParameter("id"));
        GioHang GioHang = service.getOne(id);
        request.setAttribute("gh", GioHang);
        request.getRequestDispatcher("/view/update-gio-hang.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHangImp khachHangImp = new KhachHangImp();
        List<KhachHang> listKH = new ArrayList<>();
        listKH = khachHangImp.getAll();
        request.setAttribute("listKH",listKH);
        NhanVienImp nhanVienImp = new NhanVienImp();
        List<NhanVien> listNV = new ArrayList<>();
        listNV = nhanVienImp.getAll();
        request.setAttribute("listNV",listNV);
        request.getRequestDispatcher("/view/add-gio-hang.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GioHang GioHang = service.getOne(id);
        request.setAttribute("gh", GioHang);
        request.getRequestDispatcher("/view/update-gio-hang.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGH = service.getAll();
        request.setAttribute("listGH", listGH);
        request.getRequestDispatcher("/view/list-gio-hang.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddGioHang")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateGioHang")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        GioHangRequest gioHangRequest = new GioHangRequest();
        BeanUtils.populate(gioHangRequest, request.getParameterMap());
        int id = Integer.parseInt(request.getParameter("id"));
        int KhachHangID = Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID = Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang = new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(NhanVienID);
        gioHangRequest.setKhachHang(khachHang);
        gioHangRequest.setNhanVien(nhanVien);
        service.updateGioHangRequest(gioHangRequest);
        response.sendRedirect("/HienThiGioHang");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        GioHangRequest gioHangRequest = new GioHangRequest();
        BeanUtils.populate(gioHangRequest, request.getParameterMap());
        int KhachHangID = Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID = Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang = new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(NhanVienID);
        gioHangRequest.setKhachHang(khachHang);
        gioHangRequest.setNhanVien(nhanVien);
        service.addGioHangRequest(gioHangRequest);
        response.sendRedirect("/HienThiGioHang");
    }
}
