/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Monhoc;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gogojungle
 */
public class MonHocDAO {
    public static Monhoc laỵThongTinMonHoc(String maMon){
        Monhoc monHoc = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            monHoc = (Monhoc) session.get(Monhoc.class, maMon);
        }catch (HibernateException ex){
            System.err.println(ex);            
        } finally {
            session.close();
        }
        return monHoc;
    }
    
}
