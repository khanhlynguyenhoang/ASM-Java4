package com.example.ASM.controller;

import com.example.ASM.entity.NhanVien;
import com.example.ASM.repository.NhanVienRepository;
import com.example.ASM.service.imp.NhanVienImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = "/dang-nhap")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVienRepository repo =new NhanVienRepository();
        // Check dang nhap => Dang nhap thanh cong => ket qua.jsp
        // Fail => quay lai man hinh dang nhap
        // PhongTT35, 123456
        //  B1: Lấy dữ liệu từ form
        String user = request.getParameter("uname");
        String pass = request.getParameter("psw");
        //check dang nhap
        if (repo.login(user,pass)) {
            //dang nhap thanh cong
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("uname", user);
            request.getRequestDispatcher("/view/trang-chu.jsp").forward(request, response);
        } else {
            //dang nhap that bat=>hien thi lai man hinh dang nhap
            request.setAttribute("loi", "Loi dang nhap");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}
