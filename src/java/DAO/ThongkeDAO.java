/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Bean.ThongKe;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class ThongkeDAO {
    public ThongkeDAO(){}
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;  
    
    public static List<ThongKe> search(String ngaybd, String ngaykt){
        List<ThongKe>list=new ArrayList<>();
        String query="SELECT h.idMH, b.name, SUM(b.price * h.soluong) AS doanhthu\n" +
                        "FROM Book b\n" +
                        "INNER JOIN hoadonmh h ON b.id = h.idMH\n" +
                        "INNER JOIN hoadon ON h.idHD = hoadon.idHoaDon\n" +
                        "WHERE hoadon.ngay BETWEEN '"+ngaybd+"' AND '"+ngaykt+"'\n" +
                        "GROUP BY h.idMH, b.name;";
        try{
            conn = ConnectDatabase.getMySQLConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new ThongKe(rs.getInt(1), rs.getString(2), 
                                       rs.getInt(3)));
            }
            System.out.println(list);
            
        }catch(Exception e){
            
        }
        return list;
    }
}
