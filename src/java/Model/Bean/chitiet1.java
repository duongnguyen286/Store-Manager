/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author Admin
 */
public class chitiet1 {
    private int idHd;
    private String ngay;
    private String name;
    private int idKH;
    private String tongtien;

    public chitiet1(int idHd, String ngay, String name, int idKH, String tongtien) {
        this.idHd = idHd;
        this.ngay = ngay;
        this.name = name;
        this.idKH = idKH;
        this.tongtien = tongtien;
    }

    public int getIdHd() {
        return idHd;
    }

    public void setIdHd(int idHd) {
        this.idHd = idHd;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "chitiet1{" + "idHd=" + idHd + ", ngay=" + ngay + ", name=" + name + ", idKH=" + idKH + ", tongtien=" + tongtien + '}';
    }
    
    
    
}
