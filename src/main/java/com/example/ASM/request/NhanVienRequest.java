package com.example.ASM.request;


import com.example.ASM.entity.ChucVu;
import com.example.ASM.entity.CuaHang;
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
public class NhanVienRequest {

    private int id;

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private String matKhau;

    private CuaHang cuaHang;

    private ChucVu chucVu;

    private int idGuiBC;

    private int trangThai;

}
