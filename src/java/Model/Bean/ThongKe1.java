/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author Admin
 */
public class ThongKe1 {
    private int maNV;
    private String name;
    private String doanhthu;

    public ThongKe1(int maNV, String name, String doanhthu) {
        this.maNV = maNV;
        this.name = name;
        this.doanhthu = doanhthu;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(String doanhthu) {
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        return "ThongKe1{" + "maNV=" + maNV + ", name=" + name + ", doanhthu=" + doanhthu + '}';
    }
    
}
