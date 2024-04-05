package com.example.ASM.controller;

import com.example.ASM.entity.HoaDon;
import com.example.ASM.entity.KhachHang;
import com.example.ASM.entity.NhanVien;
import com.example.ASM.request.HoaDonRequest;
import com.example.ASM.service.imp.HoaDonImp;
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

@WebServlet(name = "HoaDonController", value = {
        "/HienThiHoaDon",
        "/DetailHoaDon",
        "/viewAddHoaDon",
        "/viewUpdateHoaDon",
        "/DeleteHoaDon",
        "/AddHoaDon",
        "/UpdateHoaDon"
})
public class HoaDonController extends HttpServlet {
    HoaDonImp service = new HoaDonImp();
    List<HoaDon> listHD = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiHoaDon")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailHoaDon")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddHoaDon")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateHoaDon")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteHoaDon")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon = service.getOne(id);
        service.delete(hoaDon);
        response.sendRedirect("/HienThiHoaDon");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon = service.getOne(id);
        request.setAttribute("hd", hoaDon);
        request.getRequestDispatcher("/view/update-hoa-don.jsp").forward(request, response);
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
        request.getRequestDispatcher("/view/add-hoa-don.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon = service.getOne(id);
        request.setAttribute("hd", hoaDon);
        request.getRequestDispatcher("/view/update-hoa-don.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listHD = service.getAll();
        request.setAttribute("listHD", listHD);
        request.getRequestDispatcher("/view/list-hoa-don.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddHoaDon")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateHoaDon")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        HoaDonRequest HoaDonRequest = new HoaDonRequest();
        BeanUtils.populate(HoaDonRequest, request.getParameterMap());
        int id = Integer.parseInt(request.getParameter("id"));
        int KhachHangID = Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID = Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang = new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(NhanVienID);
        HoaDonRequest.setKhachHang(khachHang);
        HoaDonRequest.setNhanVien(nhanVien);
        service.updateHoaDonRequest(HoaDonRequest);
        response.sendRedirect("/HienThiHoaDon");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        HoaDonRequest HoaDonRequest = new HoaDonRequest();
        BeanUtils.populate(HoaDonRequest, request.getParameterMap());
        int KhachHangID = Integer.parseInt(request.getParameter("khachHang.id"));
        int NhanVienID = Integer.parseInt(request.getParameter("nhanVien.id"));
        KhachHang khachHang = new KhachHang();
        khachHang.setId(KhachHangID);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(NhanVienID);
        HoaDonRequest.setKhachHang(khachHang);
        HoaDonRequest.setNhanVien(nhanVien);
        service.addHoaDonRequest(HoaDonRequest);
        response.sendRedirect("/HienThiHoaDon");
    }
}
