package POJO;
// Generated Aug 10, 2019 3:04:01 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;




/**
 * Lop generated by hbm2java
 */
public class Lop  implements java.io.Serializable {

     private String maLop;
     private Set<Sinhvien> listSV = new HashSet<Sinhvien>(0);

    public Lop() {
    }

    public Lop(String maLop) {
       this.maLop = maLop;
    }
   
    public String getMaLop() {
        return this.maLop;
    }
    
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public Set<Sinhvien> getListSV() {
        return listSV;
    }

    public void setListSV(Set<Sinhvien> listSV) {
        this.listSV = listSV;
    }




}

