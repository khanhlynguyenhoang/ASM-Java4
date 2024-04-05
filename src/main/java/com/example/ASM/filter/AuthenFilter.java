package com.example.ASM.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenFilter")
public class AuthenFilter implements Filter {
    // Khoi tao => Chay 1 lan duy nhat khi chuong trinh bat dau restart
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Khi init");
    }
    // Khi chuong trinh ket thuc => Goi 1 lan duy nhat
    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy ");
    }
    // Moi request gui den deu chay vao do filter => xuat hien nhieu lan
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do Filter Before ");
        // B1: Ep kieu
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession httpSession = req.getSession();
        String name = (String) httpSession.getAttribute("uname");
        if (name == null) {
            // Khi filter that  bai
            res.sendRedirect("/dang-nhap");
        } else {
            // Khi filter thanh cong => Chuyen trang
            res.sendRedirect("/trang-chu");
            chain.doFilter(request, response);
            System.out.println("hihi");
        }
        System.out.println("Do Filter After ");    }
}
