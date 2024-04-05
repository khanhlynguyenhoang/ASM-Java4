package com.example.ASM.service;

import java.util.List;

public interface BanHangService<E, K> {
    public List<E> getAll();

    public E getOne(int id);

    public boolean add(E e);

    public boolean update(E e);

    public boolean delete(E e);
}
