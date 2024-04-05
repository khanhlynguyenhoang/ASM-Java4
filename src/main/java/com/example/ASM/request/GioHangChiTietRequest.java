package com.example.ASM.request;

import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.entity.GioHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GioHangChiTietRequest {

    private GioHang gioHang;

    private ChiTietSP chiTietSanPham;

    private int soLuong;

    private long donGia;

    private long donGiaKhiGiam;

}
