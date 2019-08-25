/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Gogojungle
 */
public class PhucKhao {
    private Integer id;
    private String mssv;
    private String hoTen;
    private String maMh;
    private String cotDiem;
    private Float diemSuggest;
    private String lyDo;
    private Integer idLichPhucKhao;
    private Integer status;

    public PhucKhao() {
    }

    public PhucKhao(String mssv, String hoTen, String maMh, String cotDiem, Float diemSuggest, String lyDo, Integer idLichPhucKhao, Integer status) {
       this.mssv = mssv;
       this.hoTen = hoTen;
       this.maMh = maMh;
       this.cotDiem = cotDiem;
       this.diemSuggest = diemSuggest;
       this.lyDo = lyDo;
       this.idLichPhucKhao = idLichPhucKhao;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public String getMaMh() {
        return this.maMh;
    }
    
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }
    public String getCotDiem() {
        return this.cotDiem;
    }
    
    public void setCotDiem(String cotDiemPhucKhao) {
        this.cotDiem = cotDiemPhucKhao;
    }
    public Float getDiemSuggest() {
        return this.diemSuggest;
    }
    
    public void setDiemSuggest(Float diemSuggest) {
        this.diemSuggest = diemSuggest;
    }
    public String getLyDo() {
        return this.lyDo;
    }
    
    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    public Integer getIdLichPhucKhao() {
        return this.idLichPhucKhao;
    }
    
    public void setIdLichPhucKhao(Integer idLichPhucKhao) {
        this.idLichPhucKhao = idLichPhucKhao;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
}
