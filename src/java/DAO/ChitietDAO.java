/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Bean.ChiTiet;
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
        String query="SELECT hoadonmh.idMH, book.name, hoadonmh.idHD, hoadonmh.soluong, hoadon.ngay, hoadon.idNVBH, hoadon.idKH\n" +
"FROM hoadonmh\n" +
"INNER JOIN hoadon ON hoadonmh.idHD = hoadon.idhoadon\n" +
"INNER JOIN book ON hoadonmh.idMH = book.id\n" +
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
}
