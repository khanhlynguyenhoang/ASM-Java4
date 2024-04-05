package com.example.ASM.request;

import com.example.ASM.entity.DongSP;
import com.example.ASM.entity.MauSac;
import com.example.ASM.entity.NSX;
import com.example.ASM.entity.SanPham;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChiTietSanPhamRequest {
    private int id;

    private SanPham sanPham;

    private NSX nhaSanXuat;

    private MauSac mauSac;

    private DongSP dongSanPham;

    private int namBH;

    private String moTa;

    private int soLuongTon;

    private double giaNhap;

    private double giaBan;
}
