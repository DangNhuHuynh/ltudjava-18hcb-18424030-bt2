/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gogojungle
 */
public class Namhoc {
    private int namHoc;
     private Set<Lop> lops = new HashSet(0);
     

    public Namhoc() {
    }

	
    public Namhoc(int namHoc) {
        this.namHoc = namHoc;
    }
    public Namhoc(int namHoc, Set<Lop> lops) {
       this.namHoc = namHoc;
       this.lops = lops;
    }
   
    public int getNamHoc() {
        return this.namHoc;
    }
    
    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }
    public Set<Lop> getLops() {
        return this.lops;
    }
    
    public void setLops(Set<Lop> lops) {
        this.lops = lops;
    }
    
    
}
