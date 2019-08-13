/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Sinhvien;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class SinhVienDAO {
    public static List<Sinhvien> layDSSV(){
        List<Sinhvien> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
            String str = "select sv from Sinhvien sv";
            Query query = session.createQuery(str);
            list = query.list();
        try{
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<Sinhvien> layDSSVTheoLop(String maLop){
        List<Sinhvien> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
            String str = "select * from Sinhvien sv where sv.MaLop := maLop";
            Query query = session.createQuery(str);
            query.setString("maLop", maLop);
            list = query.list();
        try{
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static Sinhvien layThongTinSV(String mssv){
        Sinhvien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            sv = (Sinhvien) session.get(Sinhvien.class, mssv);
        }catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return sv;
    }
    
    public static void themSV(Sinhvien sv){
        Session session = new HibernateUtil().getSessionFactory().openSession();
        if(SinhVienDAO.layThongTinSV(sv.getMssv()) != null){
            return;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(sv);
            trans.commit();
        }catch (HibernateException ex){
            trans.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
//        return true;
    }
    
    public static boolean updateSV(Sinhvien sv) {
        Session session = new HibernateUtil().getSessionFactory().openSession();
        if(SinhVienDAO.layThongTinSV(sv.getMssv()) == null){
            return false;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(sv);
            trans.commit();
        }catch (HibernateException ex){
            trans.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
    public static boolean xoaSV(String mssv) {
        Session session = new HibernateUtil().getSessionFactory().openSession();
        Sinhvien sv = SinhVienDAO.layThongTinSV(mssv);
        if(sv == null){
            return false;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.delete(sv);
            trans.commit();
        }catch (HibernateException ex){
            trans.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
