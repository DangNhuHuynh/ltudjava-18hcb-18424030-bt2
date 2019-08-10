package POJO;
// Generated Aug 10, 2019 3:04:01 PM by Hibernate Tools 4.3.1



/**
 * Sinhvien generated by hbm2java
 */
public class Sinhvien  implements java.io.Serializable {


     private String mssv;
     private String hoTen;
     private String gioiTinh;
     private String cmnd;
     private Lop lop;

    public Sinhvien() {
    }

	
    public Sinhvien(String mssv) {
        this.mssv = mssv;
    }
    public Sinhvien(String mssv, String hoTen, String gioiTinh, String cmnd, Lop maLop) {
       this.mssv = mssv;
       this.hoTen = hoTen;
       this.gioiTinh = gioiTinh;
       this.cmnd = cmnd;
       this.lop = maLop;
    }
   
    public String getMssv() {
        return this.mssv;
    }
    
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getCmnd() {
        return this.cmnd;
    }
    
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
    




}

