package com.example.ASM.controller;

import com.example.ASM.entity.DongSP;
import com.example.ASM.service.imp.DongSanPhamImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DongSPController", value = {
        "/HienThiDongSP",
        "/DetailDongSP",
        "/viewAddDongSP",
        "/viewUpdateDongSP",
        "/DeleteDongSP",
        "/AddDongSP",
        "/UpdateDongSP"
})
public class DongSPController extends HttpServlet {
    List<DongSP> listDSP = new ArrayList<>();
    DongSanPhamImp service = new DongSanPhamImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("HienThiDongSP")){
            this.HienThi(request,response);
        }else if(uri.contains("DetailDongSP")){
            this.detail(request,response);
        }else if(uri.contains("viewAddDongSP")){
            this.viewAdd(request,response);
        }else if(uri.contains("viewUpdateDongSP")){
            this.viewUpdate(request,response);
        }else if(uri.contains("DeleteDongSP")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        DongSP dongSanPham =service.getOne(id);
        service.delete(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        DongSP dongSanPham =service.getOne(id);
        request.setAttribute("dsp", dongSanPham);
        request.getRequestDispatcher("/view/update-dsp.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-dsp.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        DongSP dongSanPham =service.getOne(id);
        request.setAttribute("dsp", dongSanPham);
        request.getRequestDispatcher("/view/update-dsp.jsp").forward(request,response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDSP =service.getAll();
        request.setAttribute("listDSP",listDSP);
        request.getRequestDispatcher("/view/list-dsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("AddDongSP")){
            this.Add(request,response);
        }else if(uri.contains("UpdateDongSP")){
            this.Update(request,response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        DongSP dongSanPham = DongSP.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        DongSP dongSanPham = DongSP.builder().ma(ma).ten(ten).build();
        service.add(dongSanPham);
        response.sendRedirect("/HienThiDongSP");
    }
}
