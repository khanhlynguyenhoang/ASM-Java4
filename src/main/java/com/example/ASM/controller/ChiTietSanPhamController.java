package com.example.ASM.controller;

import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.entity.DongSP;
import com.example.ASM.entity.MauSac;
import com.example.ASM.entity.NSX;
import com.example.ASM.entity.SanPham;
import com.example.ASM.request.ChiTietSanPhamRequest;
import com.example.ASM.service.imp.ChiTietSanPhamImp;
import com.example.ASM.service.imp.DongSanPhamImp;
import com.example.ASM.service.imp.MauSacImp;
import com.example.ASM.service.imp.NhaSanXuatImp;
import com.example.ASM.service.imp.SanPhamImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChiTietSanPhamController", value = {
        "/HienThiChiTietSanPham",
        "/DetailChiTietSanPham",
        "/viewAddChiTietSanPham",
        "/viewUpdateChiTietSanPham",
        "/DeleteChiTietSanPham",
        "/AddChiTietSanPham",
        "/UpdateChiTietSanPham"
})
public class ChiTietSanPhamController extends HttpServlet {
    ChiTietSanPhamImp service = new ChiTietSanPhamImp();
    List<ChiTietSP> listCTSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiChiTietSanPham")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailChiTietSanPham")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddChiTietSanPham")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateChiTietSanPham")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteChiTietSanPham")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP chiTietSP = service.getOne(id);
        service.delete(chiTietSP);
        response.sendRedirect("/HienThiChiTietSanPham");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP chiTietSP = service.getOne(id);
        request.setAttribute("ctsp", chiTietSP);
        SanPhamImp sanPhamService = new SanPhamImp();
        List<SanPham> listSanPham = new ArrayList<>();
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);

        NhaSanXuatImp nhaSanXuatImp = new NhaSanXuatImp();
        List<NSX> listNSX = new ArrayList<>();
        listNSX = nhaSanXuatImp.getAll();
        request.setAttribute("listNSX",listNSX);

        MauSacImp mauSacImp = new MauSacImp();
        List<MauSac> listMS = new ArrayList<>();
        listMS = mauSacImp.getAll();
        request.setAttribute("listMS",listMS);

        DongSanPhamImp dongSanPhamImp = new DongSanPhamImp();
        List<DongSP> listDSP = new ArrayList<>();
        listDSP = dongSanPhamImp.getAll();
        request.setAttribute("listDSP",listDSP);
        request.getRequestDispatcher("/view/update-ctsp.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPhamImp sanPhamService = new SanPhamImp();
        List<SanPham> listSanPham = new ArrayList<>();
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);

        NhaSanXuatImp nhaSanXuatImp = new NhaSanXuatImp();
        List<NSX> listNSX = new ArrayList<>();
        listNSX = nhaSanXuatImp.getAll();
        request.setAttribute("listNSX",listNSX);

        MauSacImp mauSacImp = new MauSacImp();
        List<MauSac> listMS = new ArrayList<>();
        listMS = mauSacImp.getAll();
        request.setAttribute("listMS",listMS);

        DongSanPhamImp dongSanPhamImp = new DongSanPhamImp();
        List<DongSP> listDSP = new ArrayList<>();
        listDSP = dongSanPhamImp.getAll();
        request.setAttribute("listDSP",listDSP);

        request.getRequestDispatcher("/view/add-ctsp.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ChiTietSP chiTietSP = service.getOne(id);
        request.setAttribute("ctsp", chiTietSP);
        request.getRequestDispatcher("/view/update-ctsp.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCTSP = service.getAll();
        request.setAttribute("listCTSP", listCTSP);
        request.getRequestDispatcher("/view/list-ctsp.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddChiTietSanPham")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateChiTietSanPham")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ChiTietSanPhamRequest chiTietSanPhamRequest = new ChiTietSanPhamRequest();
        BeanUtils.populate(chiTietSanPhamRequest, request.getParameterMap());
        int sanPhamId = Integer.parseInt(request.getParameter("sanPham.id"));
        int nhaSanXuatId = Integer.parseInt(request.getParameter("nhaSanXuat.id"));
        int mauSacId = Integer.parseInt(request.getParameter("mauSac.id"));
        int dongSanPhamId = Integer.parseInt(request.getParameter("dongSanPham.id"));
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = new SanPham();
        sanPham.setId(sanPhamId);

        NSX nhaSanXuat = new NSX();
        nhaSanXuat.setId(nhaSanXuatId);

        MauSac mauSac = new MauSac();
        mauSac.setId(mauSacId);

        DongSP dongSanPham = new DongSP();
        dongSanPham.setId(dongSanPhamId);
        chiTietSanPhamRequest.setSanPham(sanPham);
        chiTietSanPhamRequest.setNhaSanXuat(nhaSanXuat);
        chiTietSanPhamRequest.setMauSac(mauSac);
        chiTietSanPhamRequest.setDongSanPham(dongSanPham);

        service.updateChiTietSanPhamRequest(chiTietSanPhamRequest);

        response.sendRedirect("/HienThiChiTietSanPham");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ChiTietSanPhamRequest chiTietSanPhamRequest = new ChiTietSanPhamRequest();
        BeanUtils.populate(chiTietSanPhamRequest, request.getParameterMap());
        int sanPhamId = Integer.parseInt(request.getParameter("sanPham.id"));
        int nhaSanXuatId = Integer.parseInt(request.getParameter("nhaSanXuat.id"));
        int mauSacId = Integer.parseInt(request.getParameter("mauSac.id"));
        int dongSanPhamId = Integer.parseInt(request.getParameter("dongSanPham.id"));

        SanPham sanPham = new SanPham();
        sanPham.setId(sanPhamId);

        NSX nhaSanXuat = new NSX();
        nhaSanXuat.setId(nhaSanXuatId);

        MauSac mauSac = new MauSac();
        mauSac.setId(mauSacId);

        DongSP dongSanPham = new DongSP();
        dongSanPham.setId(dongSanPhamId);
        chiTietSanPhamRequest.setSanPham(sanPham);
        chiTietSanPhamRequest.setNhaSanXuat(nhaSanXuat);
        chiTietSanPhamRequest.setMauSac(mauSac);
        chiTietSanPhamRequest.setDongSanPham(dongSanPham);

        service.addChiTietSanPhamRequest(chiTietSanPhamRequest);


        response.sendRedirect("/HienThiChiTietSanPham");
    }
}
