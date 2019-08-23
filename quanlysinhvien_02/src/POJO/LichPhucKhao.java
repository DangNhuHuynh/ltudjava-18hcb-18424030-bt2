/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author Gogojungle
 */
public class LichPhucKhao {
    private Integer id;
    private String hocKi;
    private String namHoc;
    private Integer tinhTrang;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String svPhucKhao;

    public LichPhucKhao() {
    }

	
    public LichPhucKhao(Date ngayBatDau, Date ngayKetThuc) {
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    public LichPhucKhao(String hocKi, String namHoc, Integer tinhTrang, Date ngayBatDau, Date ngayKetThuc, String svPhucKhao) {
       this.hocKi = hocKi;
       this.namHoc = namHoc;
       this.tinhTrang = tinhTrang;
       this.ngayBatDau = ngayBatDau;
       this.ngayKetThuc = ngayKetThuc;
       this.svPhucKhao = svPhucKhao;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHocKi() {
        return this.hocKi;
    }
    
    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }
    public String getNamHoc() {
        return this.namHoc;
    }
    
    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }
    
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public String getSvPhucKhao() {
        return this.svPhucKhao;
    }
    
    public void setSvPhucKhao(String svPhucKhao) {
        this.svPhucKhao = svPhucKhao;
    }
}
