package com.example.ASM.repository;

import com.example.ASM.config.HibernateConfig;
import com.example.ASM.entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    private List<HoaDon> list=new ArrayList<>();
    public List<HoaDon> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        list=session.createQuery("FROM HoaDon",HoaDon.class).getResultList();
        return list;
    }
    public HoaDon getOne(int id){
        Transaction transaction=null;
        HoaDon hoaDon=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            hoaDon=session.get(HoaDon.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return hoaDon;
    }

    public boolean add(HoaDon hoaDon){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(HoaDon hoaDon){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(hoaDon);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(HoaDon hoaDon){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
