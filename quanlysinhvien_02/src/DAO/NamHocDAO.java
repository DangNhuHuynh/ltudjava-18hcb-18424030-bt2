/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Namhoc;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gogojungle
 */
public class NamHocDAO {
    
    public static List<Namhoc> layDSNamHoc(){
        List<Namhoc> list = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
            String str = "select nh from Namhoc nh";
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
    
    public static Namhoc layThongTinNamHoc(int nam){
        Namhoc namHoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            namHoc = (Namhoc) session.get(Namhoc.class, nam);
        }catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return namHoc;
    }
    
}
