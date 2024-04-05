package com.example.ASM.controller;

import com.example.ASM.entity.ChucVu;
import com.example.ASM.entity.CuaHang;
import com.example.ASM.entity.NhanVien;
import com.example.ASM.request.NhanVienRequest;
import com.example.ASM.service.imp.ChucVuImp;
import com.example.ASM.service.imp.CuaHangImp;
import com.example.ASM.service.imp.NhanVienImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NhanVienController", value = {
        "/HienThiNhanVien",
        "/DetailNhanVien",
        "/viewAddNhanVien",
        "/viewUpdateNhanVien",
        "/DeleteNhanVien",
        "/AddNhanVien",
        "/UpdateNhanVien",
        "/LoginNhanVien"
})
public class NhanVienController extends HttpServlet {
    NhanVienImp service = new NhanVienImp();
    List<NhanVien> listNV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiNhanVien")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailNhanVien")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddNhanVien")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateNhanVien")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteNhanVien")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = service.getOne(id);
        service.delete(NhanVien);
        response.sendRedirect("/HienThiNhanVien");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = service.getOne(id);
        request.setAttribute("nv", NhanVien);
        request.getRequestDispatcher("/view/update-nv.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHangImp cuaHangImp = new CuaHangImp();
        List<CuaHang> listCH = cuaHangImp.getAll();
        request.setAttribute("listCH",listCH);
        ChucVuImp chucVuImp = new ChucVuImp();
        List<ChucVu> listCV = chucVuImp.getAll();
        request.setAttribute("listCV",listCV);
        NhanVienImp nhanVienImp = new NhanVienImp();
        List<NhanVien> listNV1 = nhanVienImp.getAll();
        request.setAttribute("listNV1",listNV1);
        request.getRequestDispatcher("/view/add-nv.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien NhanVien = service.getOne(id);
        request.setAttribute("nv", NhanVien);
        request.getRequestDispatcher("/view/update-nv.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNV = service.getAll();
        request.setAttribute("listNV", listNV);
        request.getRequestDispatcher("/view/list-nv.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddNhanVien")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateNhanVien")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        NhanVienRequest nhanVienRequest = new NhanVienRequest();
        BeanUtils.populate(nhanVienRequest, request.getParameterMap());
        int id = Integer.parseInt(request.getParameter("id"));
        int CuaHangID = Integer.parseInt(request.getParameter("cuaHang.id"));
        int ChucVuID = Integer.parseInt(request.getParameter("chucVu.id"));
        CuaHang cuaHang = new CuaHang();
        cuaHang.setId(CuaHangID);
        ChucVu chucVu = new ChucVu();
        chucVu.setId(ChucVuID);
        nhanVienRequest.setChucVu(chucVu);
        nhanVienRequest.setCuaHang(cuaHang);
        service.updateNhanVienRequest(nhanVienRequest);
        response.sendRedirect("/HienThiNhanVien");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        NhanVienRequest nhanVienRequest = new NhanVienRequest();
        BeanUtils.populate(nhanVienRequest, request.getParameterMap());
        int CuaHangID = Integer.parseInt(request.getParameter("cuaHang.id"));
        int ChucVuID = Integer.parseInt(request.getParameter("chucVu.id"));
        CuaHang cuaHang = new CuaHang();
        cuaHang.setId(CuaHangID);
        ChucVu chucVu = new ChucVu();
        chucVu.setId(ChucVuID);
        nhanVienRequest.setChucVu(chucVu);
        nhanVienRequest.setCuaHang(cuaHang);
        service.addNhanVienRequest(nhanVienRequest);
        response.sendRedirect("/HienThiNhanVien");
    }
}
