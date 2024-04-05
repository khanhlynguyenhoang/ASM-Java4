package com.example.ASM.repository;

import com.example.ASM.config.HibernateConfig;
import com.example.ASM.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private List<SanPham> list = new ArrayList<>();

    public List<SanPham> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        list = session.createQuery("FROM SanPham", SanPham.class).getResultList();
        return list;
    }

    public SanPham getOne(int id) {
        Transaction transaction = null;
        SanPham sanPham = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            sanPham = session.get(SanPham.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sanPham;
    }

    public boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
