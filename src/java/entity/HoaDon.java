/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class HoaDon {
    private Integer id;
    private Date ngay;
    private Integer idNVBH;
    private Integer idNVK;
    private Integer tongtien;
    private Integer idKH;

    public HoaDon(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Integer getIdNVBH() {
        return idNVBH;
    }

    public void setIdNVBH(Integer idNVBH) {
        this.idNVBH = idNVBH;
    }

    public Integer getIdNVK() {
        return idNVK;
    }

    public void setIdNVK(Integer idNVK) {
        this.idNVK = idNVK;
    }

    public Integer getTongtien() {
        return tongtien;
    }

    public void setTongtien(Integer tongtien) {
        this.tongtien = tongtien;
    }

    public Integer getIdKH() {
        return idKH;
    }

    public void setIdKH(Integer idKH) {
        this.idKH = idKH;
    }

    public HoaDon(Integer id, Date ngay, Integer idNVBH, Integer idNVK, Integer tongtien, Integer idKH) {
        this.id = id;
        this.ngay = ngay;
        this.idNVBH = idNVBH;
        this.idNVK = idNVK;
        this.tongtien = tongtien;
        this.idKH = idKH;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", ngay=" + ngay + ", idNVBH=" + idNVBH + ", idNVK=" + idNVK + ", tongtien=" + tongtien + ", idKH=" + idKH + '}';
    }
    
    
}
