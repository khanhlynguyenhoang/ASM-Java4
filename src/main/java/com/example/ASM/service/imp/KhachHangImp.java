package com.example.ASM.service.imp;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.repository.KhachHangRepository;
import com.example.ASM.request.KhachHangRequest;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class KhachHangImp implements BanHangService<KhachHang, Integer> {
    KhachHangRepository repo = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return repo.getAll();
    }

    @Override
    public KhachHang getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(KhachHang khachHang) {
        return repo.add(khachHang);
    }

    @Override
    public boolean update(KhachHang khachHang) {
        return repo.update(khachHang);
    }

    @Override
    public boolean delete(KhachHang khachHang) {
        return repo.delete(khachHang);
    }

    public boolean addKhachHangRequest(KhachHangRequest khachHangRequest){
        KhachHang khachHang=new KhachHang();
        khachHang.setMa(khachHangRequest.getMa());
        khachHang.setTen(khachHangRequest.getTen());
        khachHang.setTenDem(khachHangRequest.getTenDem());
        khachHang.setHo(khachHangRequest.getHo());
        khachHang.setNgaySinh(khachHangRequest.getNgaySinh());
        khachHang.setDiaChi(khachHangRequest.getDiaChi());
        khachHang.setSdt(khachHangRequest.getSdt());
        khachHang.setMatKhau(khachHangRequest.getMatKhau());
        khachHang.setThanhPho(khachHangRequest.getThanhPho());
        khachHang.setQuocGia(khachHangRequest.getQuocGia());
        return repo.add(khachHang);
    }

    public boolean updateKhachHangRequest(KhachHangRequest khachHangRequest){
        KhachHang khachHang=new KhachHang();
        khachHang.setId(khachHangRequest.getId());
        khachHang.setMa(khachHangRequest.getMa());
        khachHang.setTen(khachHangRequest.getTen());
        khachHang.setTenDem(khachHangRequest.getTenDem());
        khachHang.setHo(khachHangRequest.getHo());
        khachHang.setNgaySinh(khachHangRequest.getNgaySinh());
        khachHang.setDiaChi(khachHangRequest.getDiaChi());
        khachHang.setSdt(khachHangRequest.getSdt());
        khachHang.setMatKhau(khachHangRequest.getMatKhau());
        khachHang.setThanhPho(khachHangRequest.getThanhPho());
        khachHang.setQuocGia(khachHangRequest.getQuocGia());
        return repo.update(khachHang);
    }
}
