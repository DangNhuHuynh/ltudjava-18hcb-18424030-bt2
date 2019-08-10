/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Lop;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gogojungle
 */
public class LopDAO {
    public static List<Lop> layDSLop(){
        List<Lop> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
            String str = "select lop from Lop lop";
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
    
    public static Lop layThongTinLop(String tenLop){
        Lop lop = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            lop = (Lop) session.get(Lop.class, tenLop);
        }catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return lop;
    }
    
    public static boolean themLop(Lop lop){
        Session session = new HibernateUtil().getSessionFactory().openSession();
        if(LopDAO.layThongTinLop(lop.getMaLop()) != null){
            return false;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(lop);
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
