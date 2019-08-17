/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Sinhvien;
import POJO.SvMonhoc;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class SvMonHocDAO {
    public static List<Sinhvien> layThongTinSVMH(String maLop, String hocKi, String maMH) {
        List<Sinhvien> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select sv from SvMonhoc svmh, Sinhvien sv, Thoikhoabieu tkb"
                    + " where svmh.maLop =:maLop and svmh.maSV = sv.mssv"
                    + " and tkb.hocKi =:hk and svmh.maMh =:maMH "
                    + "and svmh.maMh = tkb.id.maMh and svmh.maLop = tkb.id.maLop";
            Query query = session.createQuery(str);
//            query.setParameter("id", idTable);
            query.setParameter("maLop", maLop); 
            query.setParameter("hk", hocKi);
            query.setParameter("maMH", maMH); 
            list = (List<Sinhvien>) query.list();
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<Sinhvien> layThongTinById(int id) {
        List<Sinhvien> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select sv from SvMonhoc svmh, Sinhvien sv"
                    + " where svmh.maSV = sv.mssv and svmh.id =:id";
            Query query = session.createQuery(str);
            query.setParameter("id", id);
            list = (List<Sinhvien>) query.list();
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<SvMonhoc> getList(){
        List<SvMonhoc> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select sv from SvMonhoc sv";
            Query query = session.createQuery(str);
            list = query.list();
        
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        
        return list;
    }
    
    public static SvMonhoc layThongTin(int id) {
        SvMonhoc svmh = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            svmh = (SvMonhoc) session.get(SvMonhoc.class, id);
        }catch (HibernateException ex){
            System.err.println(ex);            
        } finally {
            session.close();
        }
        return svmh;
    }
    
    public static boolean themSV(Sinhvien sv){
        Session session = new HibernateUtil().getSessionFactory().openSession();
//        if(SinhVienDAO.layThongTinSV(sv.getMssv()) == null){
//            return false;
//        } 
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
        return true;
    }
    
}
