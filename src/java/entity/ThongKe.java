/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;



/**
 *
 * @author Admin
 */
public class ThongKe {
    private Integer maMH;
    private String name;

    private Integer doanhthu;
    
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


    public Integer getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Integer doanhthu) {
        this.doanhthu = doanhthu;
    }

    public ThongKe(Integer maMH, String name,  Integer doanhthu) {
        this.maMH = maMH;
        this.name = name;
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "maMH=" + maMH + ", name=" + name +", doanhthu=" + doanhthu + '}';
    }
    
}
