package com.example.ASM.controller;

import com.example.ASM.entity.NSX;
import com.example.ASM.service.imp.NhaSanXuatImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NhaSanXuatController", value = {
        "/HienThiNSX",
        "/DetailNSX",
        "/viewAddNSX",
        "/viewUpdateNSX",
        "/DeleteNSX",
        "/AddNSX",
        "/UpdateNSX"
})
public class NhaSanXuatController extends HttpServlet {
    NhaSanXuatImp service = new NhaSanXuatImp();
    List<NSX> listNSX = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("HienThiNSX")){
            this.HienThi(request,response);
        }else if(uri.contains("DetailNSX")){
            this.detail(request,response);
        }else if(uri.contains("viewAddNSX")){
            this.viewAdd(request,response);
        }else if(uri.contains("viewUpdateNSX")){
            this.viewUpdate(request,response);
        }
        else if(uri.contains("DeleteNSX")){
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NSX nhaSanXuat =service.getOne(id);
        service.delete(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NSX nhaSanXuat =service.getOne(id);
        request.setAttribute("nsx", nhaSanXuat);
        request.getRequestDispatcher("/view/update-nsx.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-nsx.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        NSX nhaSanXuat =service.getOne(id);
        request.setAttribute("nsx", nhaSanXuat);
        request.getRequestDispatcher("/view/update-nsx.jsp").forward(request,response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNSX =service.getAll();
        request.setAttribute("listNSX",listNSX);
        request.getRequestDispatcher("/view/list-nsx.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("AddNSX")){
            this.Add(request,response);
        }else if(uri.contains("UpdateNSX")){
            this.Update(request,response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NSX nhaSanXuat = NSX.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        NSX nhaSanXuat = NSX.builder().ma(ma).ten(ten).build();
        service.add(nhaSanXuat);
        response.sendRedirect("/HienThiNSX");
    }
}
