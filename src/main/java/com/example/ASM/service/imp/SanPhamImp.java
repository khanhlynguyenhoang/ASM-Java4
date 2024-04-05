package com.example.ASM.service.imp;

import com.example.ASM.entity.SanPham;
import com.example.ASM.repository.SanPhamRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class SanPhamImp implements BanHangService<SanPham, Integer> {

    SanPhamRepository repo = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repo.getAll();
    }

    @Override
    public SanPham getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(SanPham sanPham) {
        return repo.add(sanPham);
    }

    @Override
    public boolean update(SanPham sanPham) {
        return repo.update(sanPham);
    }

    @Override
    public boolean delete(SanPham sanPham) {
        return repo.delete(sanPham);
    }

}
