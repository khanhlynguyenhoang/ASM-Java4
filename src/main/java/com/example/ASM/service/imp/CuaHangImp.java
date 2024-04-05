package com.example.ASM.service.imp;

import com.example.ASM.entity.CuaHang;
import com.example.ASM.repository.CuaHangRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class CuaHangImp implements BanHangService<CuaHang, Integer> {
    CuaHangRepository repo = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return repo.getAll();
    }

    @Override
    public CuaHang getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(CuaHang cuaHang) {
        return repo.add(cuaHang);
    }

    @Override
    public boolean update(CuaHang cuaHang) {
        return repo.update(cuaHang);
    }

    @Override
    public boolean delete(CuaHang cuaHang) {
        return repo.delete(cuaHang);
    }

}
