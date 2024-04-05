package com.example.ASM.service.imp;

import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.repository.ChiTietSanPhamRepository;
import com.example.ASM.request.ChiTietSanPhamRequest;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class ChiTietSanPhamImp implements BanHangService<ChiTietSP, Integer> {

    ChiTietSanPhamRepository repo = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return repo.getAll();
    }

    @Override
    public ChiTietSP getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(ChiTietSP chiTietSP) {
        return repo.add(chiTietSP);
    }

    @Override
    public boolean update(ChiTietSP chiTietSP) {
        return repo.update(chiTietSP);
    }

    @Override
    public boolean delete(ChiTietSP chiTietSP) {
        return repo.delete(chiTietSP);
    }

    public boolean addChiTietSanPhamRequest(ChiTietSanPhamRequest chiTietSanPhamRequest) {
        ChiTietSP chiTietSanPham = new ChiTietSP();
        chiTietSanPham.setSanPham(chiTietSanPhamRequest.getSanPham());
        chiTietSanPham.setDongSanPham(chiTietSanPhamRequest.getDongSanPham());
        chiTietSanPham.setNhaSanXuat(chiTietSanPhamRequest.getNhaSanXuat());
        chiTietSanPham.setMauSac(chiTietSanPhamRequest.getMauSac());
        chiTietSanPham.setNamBH(chiTietSanPhamRequest.getNamBH());
        chiTietSanPham.setMoTa(chiTietSanPhamRequest.getMoTa());
        chiTietSanPham.setSoLuongTon(chiTietSanPhamRequest.getSoLuongTon());
        chiTietSanPham.setGiaNhap(chiTietSanPhamRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(chiTietSanPhamRequest.getGiaBan());
        return repo.add(chiTietSanPham);
    }

    public boolean updateChiTietSanPhamRequest(ChiTietSanPhamRequest chiTietSanPhamRequest) {
        ChiTietSP chiTietSanPham = new ChiTietSP();
        chiTietSanPham.setId(chiTietSanPhamRequest.getId());
        chiTietSanPham.setSanPham(chiTietSanPhamRequest.getSanPham());
        chiTietSanPham.setDongSanPham(chiTietSanPhamRequest.getDongSanPham());
        chiTietSanPham.setNhaSanXuat(chiTietSanPhamRequest.getNhaSanXuat());
        chiTietSanPham.setMauSac(chiTietSanPhamRequest.getMauSac());
        chiTietSanPham.setNamBH(chiTietSanPhamRequest.getNamBH());
        chiTietSanPham.setMoTa(chiTietSanPhamRequest.getMoTa());
        chiTietSanPham.setSoLuongTon(chiTietSanPhamRequest.getSoLuongTon());
        chiTietSanPham.setGiaNhap(chiTietSanPhamRequest.getGiaNhap());
        chiTietSanPham.setGiaBan(chiTietSanPhamRequest.getGiaBan());
        return repo.update(chiTietSanPham);
    }

}
