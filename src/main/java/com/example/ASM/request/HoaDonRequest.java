package com.example.ASM.request;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.entity.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonRequest {
    private int id;

    private KhachHang khachHang;

    private NhanVien nhanVien;

    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;

    private Date ngayShip;

    private Date ngayNhan;

    private int tinhTrang;

    private String tenNguoiNhan;

    private String diaChi;

    private String sdt;
}
