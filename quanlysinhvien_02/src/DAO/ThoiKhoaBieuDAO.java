/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Thoikhoabieu;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Gogojungle
 */
public class ThoiKhoaBieuDAO {
    
    private static final SessionFactory sessionFactory;
    
    public static List<Thoikhoabieu> layDSTKB(){
        List<Thoikhoabieu> list = null;        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String str = "select tkb from Thoikhoabieu tkb";
            Query query = session.createQuery(str);
            list = query.list();
        }catch (HibernateException ex){
            System.err.println(ex);            
        } finally {
            session.close();
        }
        return list;
    }
    
    public static List<Thoikhoabieu> layTKBByLop(String maLop){
        List<Thoikhoabieu> list = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String str = "select tkb from Thoikhoabieu tkb where tkb.id.maLop =:idMaLop";
            Query query = session.createQuery(str);        
            query.setString("idMaLop", maLop);
            list = query.list();
        }catch (HibernateException ex){
            System.err.println(ex);            
        } finally {
            session.close();
        }
        return list;
    }
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
