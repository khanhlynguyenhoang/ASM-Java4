package com.example.ASM.service.imp;

import com.example.ASM.entity.DongSP;
import com.example.ASM.repository.DongSanPhamRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class DongSanPhamImp implements BanHangService<DongSP, Integer> {
    DongSanPhamRepository repo = new DongSanPhamRepository();

    @Override
    public List<DongSP> getAll() {
        return repo.getAll();
    }

    @Override
    public DongSP getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(DongSP dongSP) {
        return repo.add(dongSP);
    }

    @Override
    public boolean update(DongSP dongSP) {
        return repo.update(dongSP);
    }

    @Override
    public boolean delete(DongSP dongSP) {
        return repo.delete(dongSP);
    }

}
