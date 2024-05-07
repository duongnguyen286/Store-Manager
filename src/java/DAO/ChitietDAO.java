/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Bean.ChiTiet;
import Model.Bean.chitiet1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChitietDAO {
    public ChitietDAO(){}
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;  
    
    public static List<ChiTiet> ChiTiet(String maMH){
        List<ChiTiet>list=new ArrayList<>();
        String query="SELECT hoadonmh.idMH, product.name, hoadonmh.idHD, hoadonmh.soluong, hoadon.ngay, hoadon.idNVBH, hoadon.idKH\n" +
"FROM hoadonmh\n" +
"INNER JOIN hoadon ON hoadonmh.idHD = hoadon.idhoadon\n" +
"INNER JOIN product ON hoadonmh.idMH = product.id\n" +
"WHERE hoadonmh.idMH = '"+maMH+"' ";
        try {
            conn = ConnectDatabase.getMySQLConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new ChiTiet(rs.getInt(1), rs.getString(2),
                                     rs.getInt(3), rs.getInt(4),
                                     rs.getString(5), rs.getInt(6),rs.getInt(7)));
            }
            System.out.println(query);   
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static List<chitiet1> ChiTietNV(String maNV){
        List<chitiet1>list=new ArrayList<>();
        String query="SELECT h.idHoaDon, h.ngay, e.name, h.idKH, FORMAT(h.TongTien, 'N0') AS TongTien\n" +
                        "FROM hoadon h\n" +
                        "JOIN employees e ON h.idNVBH = e.id\n" +
                        "WHERE h.idNVBH = '"+maNV+"';";
        try {
            conn = ConnectDatabase.getMySQLConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new chitiet1(rs.getInt(1), rs.getString(2),
                                     rs.getString(3), rs.getInt(4),
                                     rs.getString(5)));
            }
            System.out.println(query);   
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
