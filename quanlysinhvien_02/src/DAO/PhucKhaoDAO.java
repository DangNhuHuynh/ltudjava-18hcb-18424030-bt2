/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.LichPhucKhao;
import POJO.PhucKhao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class PhucKhaoDAO {
    public static List<PhucKhao> getListPhucKhao(int idLichPhcKhao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;
        
        try {
            String hql = "select pk";
            hql += " from PhucKhao pk";
            hql += " where pk.idLichPhucKhao=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", idLichPhcKhao);
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return result;
    }
    
    public static PhucKhao layThongTinPhucKhao(PhucKhao target) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;
        
        try {
            String hql = "select pk";
            hql += " from PhucKhao pk";
            hql += " where pk.mssv=:mssv and pk.maMh=:maMH and pk.idLichPhucKhao=:id";
            Query query = session.createQuery(hql);
            query.setParameter("mssv", target.getMssv());
            query.setParameter("maMH", target.getMaMh());
//            query.setParameter("rowScore", re.getRowScore());
            query.setParameter("id", target.getIdLichPhucKhao());
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }
    
    public static PhucKhao getThongTin(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;
        
        try {
            String hql = "select pk";
            hql += " from PhucKhao pk";
            hql += " where pk.id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }
    
    public static PhucKhao layThongTinPhucKhaoById(int idPhucKhao){
        PhucKhao pk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            pk = (PhucKhao) session.get(PhucKhao.class, idPhucKhao);
        }catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return pk;
    }
    
    public static boolean taoPhucKhao(PhucKhao target) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(PhucKhaoDAO.layThongTinPhucKhao(target) != null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(target);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
    
    public static boolean capNhatPhucKhao(PhucKhao target) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(PhucKhaoDAO.layThongTinPhucKhaoById(target.getId()) == null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(target);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
}
