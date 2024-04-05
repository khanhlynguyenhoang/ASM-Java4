package com.example.ASM.repository;

import com.example.ASM.config.HibernateConfig;
import com.example.ASM.entity.ChiTietSP;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepository {
    private List<ChiTietSP> list=new ArrayList<>();
    public List<ChiTietSP> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        list=session.createQuery("FROM ChiTietSP", ChiTietSP.class).getResultList();
        return list;
    }

    public ChiTietSP getOne(int id){
        Transaction transaction=null;
        ChiTietSP chiTietSanPham =null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            chiTietSanPham =session.get(ChiTietSP.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return chiTietSanPham;
    }

    public boolean add(ChiTietSP chiTietSanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chiTietSanPham);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(ChiTietSP chiTietSanPham){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(chiTietSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(ChiTietSP chiTietSanPham){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(chiTietSanPham);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
