/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author Admin
 */
public class ChiTiet {
    private int maMH;
    private String name;
    private int maHD;
    private int soLuong;
    private String ngay;
    private int maNVBH;
    private int maKH;
    
    public ChiTiet(){
        
    }

    public Integer getMaMH() {
        return maMH;
    }

    public void setMaMH(Integer maMH) {
        this.maMH = maMH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getsoLuong() {
        return soLuong;
    }

    public void setsoLuong(Integer Soluong) {
        this.soLuong = Soluong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Integer getMaNVBH() {
        return maNVBH;
    }

    public void setMaNVBH(Integer maNVBH) {
        this.maNVBH = maNVBH;
    }


    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public ChiTiet(Integer maMH, String name, Integer maHD, Integer soLuong, String ngay, Integer maNVBH, Integer maKH) {
        this.maMH = maMH;
        this.name = name;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.ngay = ngay;
        this.maNVBH = maNVBH;
        this.maKH = maKH;
    }

    @Override
    public String toString() {
        return "ChiTiet{" + "maMH=" + maMH + ", name=" + name + ", maHD=" + maHD + ", Soluong=" + soLuong + ", ngay=" + ngay + ", maNVBH=" + maNVBH +  ", maKH=" + maKH + '}';
    }
    
    
    
}
