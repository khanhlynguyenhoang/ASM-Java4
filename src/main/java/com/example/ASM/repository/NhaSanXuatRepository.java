package com.example.ASM.repository;

import com.example.ASM.config.HibernateConfig;
import com.example.ASM.entity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhaSanXuatRepository {
    private List<NSX> listNhaSanXuats = new ArrayList<>();

    public List<NSX> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        listNhaSanXuats = session.createQuery("FROM NSX", NSX.class).getResultList();
        return listNhaSanXuats;
    }

    public NSX getOne(int id) {
        Transaction transaction = null;
        NSX nhaSanXuat = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            nhaSanXuat = session.get(NSX.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return nhaSanXuat;
    }

    public boolean add(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhaSanXuat);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(nhaSanXuat);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhaSanXuat);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
