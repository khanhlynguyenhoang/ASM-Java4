package com.example.ASM.controller;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.request.KhachHangRequest;
import com.example.ASM.service.imp.KhachHangImp;
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

@WebServlet(name = "KhachHangController", value = {
        "/HienThiKhachHang",
        "/DetailKhachHang",
        "/viewAddKhachHang",
        "/viewUpdateKhachHang",
        "/DeleteKhachHang",
        "/AddKhachHang",
        "/UpdateKhachHang"
})
public class KhachHangController extends HttpServlet {
    KhachHangImp service = new KhachHangImp();
    List<KhachHang> listKH = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiKhachHang")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailKhachHang")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddKhachHang")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateKhachHang")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteKhachHang")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = service.getOne(id);
        service.delete(KhachHang);
        response.sendRedirect("/HienThiKhachHang");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = service.getOne(id);
        request.setAttribute("kh", KhachHang);
        request.getRequestDispatcher("/view/update-kh.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-kh.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = service.getOne(id);
        request.setAttribute("kh", KhachHang);
        request.getRequestDispatcher("/view/update-kh.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKH = service.getAll();
        request.setAttribute("listKH", listKH);
        request.getRequestDispatcher("/view/list-kh.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddKhachHang")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateKhachHang")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        KhachHangRequest khachHangRequest = new KhachHangRequest();
        BeanUtils.populate(khachHangRequest, request.getParameterMap());
        int id = Integer.parseInt(request.getParameter("id"));
        service.updateKhachHangRequest(khachHangRequest);
        response.sendRedirect("/HienThiKhachHang");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        KhachHangRequest KhachHangRequest = new KhachHangRequest();
        BeanUtils.populate(KhachHangRequest, request.getParameterMap());
        service.addKhachHangRequest(KhachHangRequest);
        response.sendRedirect("/HienThiKhachHang");
    }
}
