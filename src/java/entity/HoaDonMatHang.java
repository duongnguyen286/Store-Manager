/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class HoaDonMatHang {
    private Integer id;
    private Integer MaMH;
    private Integer MaHD;

    public HoaDonMatHang(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaMH() {
        return MaMH;
    }

    public void setMaMH(Integer MaMH) {
        this.MaMH = MaMH;
    }

    public Integer getMaHD() {
        return MaHD;
    }

    public void setMaHD(Integer MaHD) {
        this.MaHD = MaHD;
    }

    public HoaDonMatHang(Integer id, Integer MaMH, Integer MaHD) {
        this.id = id;
        this.MaMH = MaMH;
        this.MaHD = MaHD;
    }

    @Override
    public String toString() {
        return "HoaDonMatHang{" + "id=" + id + ", MaMH=" + MaMH + ", MaHD=" + MaHD + '}';
    }
    
    
}
