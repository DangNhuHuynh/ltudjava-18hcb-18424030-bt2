/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Gogojungle
 */
public class SvMonhoc {

    private int id;    
    private String maSV;
    private String maMh;
    private String maLop; 
    private Set<Sinhvien> listSV = new HashSet<Sinhvien>(0);
    
    public SvMonhoc(){
        
    }
    
    public SvMonhoc(String maSV, String maMh, String maLop) {
       this.maSV = maSV;
       this.maMh = maMh;
       this.maLop = maLop;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Sinhvien getSinhvien() {
//        return sinhvien;
//    }
//
//    public void setSinhvien(Sinhvien sinhvien) {
//        this.sinhvien = sinhvien;
//    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Set<Sinhvien> getListSV() {
        return listSV;
    }

    public void setListSV(Set<Sinhvien> listSV) {
        this.listSV = listSV;
    }
    
    
    private static final SessionFactory sessionFactory;
    
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
