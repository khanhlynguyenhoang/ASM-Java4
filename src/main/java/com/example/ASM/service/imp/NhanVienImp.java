package com.example.ASM.service.imp;

import com.example.ASM.entity.NhanVien;
import com.example.ASM.repository.NhanVienRepository;
import com.example.ASM.request.NhanVienRequest;
import com.example.ASM.service.BanHangService;

import java.util.List;

public class NhanVienImp implements BanHangService<NhanVien, Integer> {
    NhanVienRepository repo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return repo.getAll();
    }

    @Override
    public NhanVien getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        return repo.add(nhanVien);
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return repo.update(nhanVien);
    }

    @Override
    public boolean delete(NhanVien nhanVien) {
        return repo.delete(nhanVien);
    }

    public boolean addNhanVienRequest(NhanVienRequest nhanVienRequest){
        NhanVien nhanVien=new NhanVien();
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setTenDem(nhanVienRequest.getTenDem());
        nhanVien.setHo(nhanVienRequest.getHo());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setCuaHang(nhanVienRequest.getCuaHang());
        nhanVien.setChucVu(nhanVienRequest.getChucVu());
        nhanVien.setIdGuiBC(nhanVienRequest.getIdGuiBC());
        return repo.add(nhanVien);
    }

    public boolean updateNhanVienRequest(NhanVienRequest nhanVienRequest){
        NhanVien nhanVien=new NhanVien();
        nhanVien.setId(nhanVienRequest.getId());
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setTenDem(nhanVienRequest.getTenDem());
        nhanVien.setHo(nhanVienRequest.getHo());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setCuaHang(nhanVienRequest.getCuaHang());
        nhanVien.setChucVu(nhanVienRequest.getChucVu());
        nhanVien.setIdGuiBC(nhanVienRequest.getIdGuiBC());
        return repo.update(nhanVien);
    }
}
