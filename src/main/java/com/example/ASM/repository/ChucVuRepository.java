package com.example.ASM.repository;

import com.example.ASM.config.HibernateConfig;
import com.example.ASM.entity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    private List<ChucVu> list=new ArrayList<>();
    public List<ChucVu> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        list=session.createQuery("FROM ChucVu",ChucVu.class).getResultList();
        return list;
    }
    public ChucVu getOne(int id){
        Transaction transaction=null;
        ChucVu chucVu=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            chucVu=session.get(ChucVu.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return chucVu;
    }

    public boolean add(ChucVu chucVu){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(ChucVu chucVu){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(chucVu);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(ChucVu chucVu){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
