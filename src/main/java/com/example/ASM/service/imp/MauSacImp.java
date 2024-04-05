package com.example.ASM.service.imp;

import com.example.ASM.entity.MauSac;
import com.example.ASM.repository.MauSacRepository;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class MauSacImp implements BanHangService<MauSac, Integer> {
    MauSacRepository repo = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return repo.getAll();
    }

    @Override
    public MauSac getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(MauSac mauSac) {
        return repo.add(mauSac);
    }

    @Override
    public boolean update(MauSac mauSac) {
        return repo.update(mauSac);
    }

    @Override
    public boolean delete(MauSac mauSac) {
        return repo.delete(mauSac);
    }

}
