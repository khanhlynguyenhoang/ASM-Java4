package com.example.ASM.controller;

import com.example.ASM.entity.SanPham;
import com.example.ASM.service.imp.SanPhamImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamController", value = {
        "/HienThiSanPham",
        "/DetailSanPham",
        "/viewAddSanPham",
        "/viewUpdateSanPham",
        "/DeleteSanPham",
        "/AddSanPham",
        "/UpdateSanPham"
})
public class SanPhamController extends HttpServlet {
    SanPhamImp service = new SanPhamImp();
    List<SanPham> listSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThiSanPham")) {
            this.HienThi(request, response);
        } else if (uri.contains("DetailSanPham")) {
            this.detail(request, response);
        } else if (uri.contains("viewAddSanPham")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewUpdateSanPham")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("DeleteSanPham")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham sanPham=service.getOne(id);
        service.delete(sanPham);
        response.sendRedirect("/HienThiSanPham");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham SanPham=service.getOne(id);
        request.setAttribute("sp",SanPham);
        request.getRequestDispatcher("/view/update-san-pham.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-san-pham.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham sanPham=service.getOne(id);
        request.setAttribute("sp",sanPham);
        request.getRequestDispatcher("/view/update-san-pham.jsp").forward(request,response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = service.getAll();
        request.setAttribute("listSP", listSP);
        request.getRequestDispatcher("/view/list-san-pham.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddSanPham")) {
            this.Add(request, response);
        } else if (uri.contains("UpdateSanPham")) {
            this.Update(request, response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        SanPham sanPham=SanPham.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).build();
        service.update(sanPham);
        response.sendRedirect("/HienThiSanPham");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        SanPham sanPham=SanPham.builder().ma(ma).ten(ten).build();
        service.add(sanPham);
        response.sendRedirect("/HienThiSanPham");
    }
}
