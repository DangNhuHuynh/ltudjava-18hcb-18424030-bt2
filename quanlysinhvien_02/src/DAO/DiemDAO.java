/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Diem;
import POJO.Sinhvien;
import POJO.SvMonhoc;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class DiemDAO {
    public static List<Diem> layDSDiem(){
        List<Diem> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select diem from Diem diem";
            Query query = session.createQuery(str);
            list = query.list();
        
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<Diem> layDSDiemById(int id){
        List<Diem> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select d from Diem d where d.idSvmh =:id";
            Query query = session.createQuery(str);
            query.setInteger("id", id);
            list = query.list();
        
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<SvMonhoc> layDSDiemSVMH(int id){
        List<SvMonhoc> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select d, svmh from Diem d, SvMonhoc svmh where d.idSvmh = svmh.id and d.idSvmh =:id";
            Query query = session.createQuery(str);
            query.setParameter("id", id);
            list = query.list();
        
        }catch (HibernateException ex){
            System.err.println(ex);           
        } finally {
            session.close();
        }
        return list;
    }
    
    public static Diem layDSDiemSV(int idSVMH, Sinhvien sv){
        List<Diem> diemSV = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            String str = "select d from Diem d where d.idSvmh =:idSVMH and d.sv =:sv";
            Query query = session.createQuery(str);
            query.setParameter("id", idSVMH);
            query.setParameter("sv", sv);
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
        
        if(diemSV.size() > 0) {
            return diemSV.get(0);
        }
        return null;
    }
    
    public static boolean themTableDiem(Diem diem){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(DiemDAO.layDSDiemSVById(diem.getId()) != null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(diem);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
    public static Diem layDSDiemSVById(int idSVMH){
        Diem diemSV = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try{
            diemSV = (Diem) session.get(Diem.class, idSVMH);
            
        }catch (HibernateException ex){
            System.err.println(ex);            
            
        } finally {
            session.close();
        }
               
        return diemSV;
    }
}
