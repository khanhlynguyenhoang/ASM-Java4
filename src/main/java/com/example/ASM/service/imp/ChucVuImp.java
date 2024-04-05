package com.example.ASM.service.imp;

import com.example.ASM.entity.ChucVu;
import com.example.ASM.repository.ChucVuRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class ChucVuImp implements BanHangService<ChucVu, Integer> {

    ChucVuRepository repo = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return repo.getAll();
    }

    @Override
    public ChucVu getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(ChucVu chucVu) {
        return repo.add(chucVu);
    }

    @Override
    public boolean update(ChucVu chucVu) {
        return repo.update(chucVu);
    }

    @Override
    public boolean delete(ChucVu chucVu) {
        return repo.delete(chucVu);
    }
}
