/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

import java.util.Date;



/**
 *
 * @author Admin
 */
public class ThongKe {
    private Integer maMH;
    private String name;
    private Integer soluong;
    private String doanhthu;
    
    public ThongKe(){
        
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


    public String getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(String doanhthu) {
        this.doanhthu = doanhthu;
    }
    
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public ThongKe(Integer maMH, String name, Integer soluong, String doanhthu) {
        this.maMH = maMH;
        this.name = name;
        this.soluong=soluong;
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "maMH=" + maMH + ", name=" + name +", soluong="+soluong+", doanhthu=" + doanhthu + '}';
    }
    
}
