/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.LichPhucKhao;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class LichPhucKhaoDAO {
    public static List<LichPhucKhao> listLichPhucKhao(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LichPhucKhao> list = null;
        String hql = "select lpk from LichPhucKhao lpk";
        try{
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return list;
    }
    
    public static LichPhucKhao isExists(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LichPhucKhao result = null;

        try {
            result = (LichPhucKhao) session.get(LichPhucKhao.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }
    
    public static LichPhucKhao kiemTraLichTonTai(LichPhucKhao target) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LichPhucKhao> result = null;

        try {
            String hql = "select lpk";
            hql += " from LichPhucKhao lpk";
            hql += " where lpk.hocKi=:hocKi and lpk.namHoc=:namHoc";
            Query query = session.createQuery(hql);
            query.setParameter("hocKi", target.getHocKi());
            query.setParameter("namHoc", target.getNamHoc());
            result = (List<LichPhucKhao>) query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }
    
    public static boolean taoLichPhucKhao(LichPhucKhao item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LichPhucKhaoDAO.kiemTraLichTonTai(item) != null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }
    
    public static boolean capNhatLichPhucKhao(LichPhucKhao item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LichPhucKhaoDAO.isExists(item.getId()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
}
