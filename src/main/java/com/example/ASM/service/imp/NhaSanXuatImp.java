package com.example.ASM.service.imp;

import com.example.ASM.entity.NSX;
import com.example.ASM.repository.NhaSanXuatRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class NhaSanXuatImp implements BanHangService<NSX, Integer> {
    NhaSanXuatRepository repo = new NhaSanXuatRepository();

    @Override
    public List<NSX> getAll() {
        return repo.getAll();
    }

    @Override
    public NSX getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(NSX nsx) {
        return repo.add(nsx);
    }

    @Override
    public boolean update(NSX nsx) {
        return repo.update(nsx);
    }

    @Override
    public boolean delete(NSX nsx) {
        return repo.delete(nsx);
    }

}
