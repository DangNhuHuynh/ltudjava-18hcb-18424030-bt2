/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Account;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Gogojungle
 */
public class AccountDAO {
    
    public static List<Account> layDSTaiKhoan(){
        List<Account> listAccount = null;        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Query query = session.createQuery("Select acc from Account acc");
            listAccount = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }        
        return listAccount;               
    }
    
    public static Account layThongTinTaiKhoan(String username){
        Account acc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            acc = (Account) session.get(Account.class, username);
        }catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return acc;
    }
    
    public static boolean updatePassword(Account acc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinTaiKhoan(acc.getUsername()) == null){
            return false;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(acc);
            trans.commit();
        }catch (HibernateException ex){
            trans.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static boolean themAccount(Account acc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layThongTinTaiKhoan(acc.getUsername()) != null){
            return false;
        } 
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(acc);
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
