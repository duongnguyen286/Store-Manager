/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import static Model.DAO.ChitietDAO.conn;
//import dao.*;
import Model.DAO.ConnectDatabase;
import entity.ThongKe;
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
        String query="SELECT product.idMatHang406 , product.name , \n" +
                          "SUM(product.gia*order_line.SoLuong) as 'Doanh thu'\n" +
                          "FROM hoadonmathang406 as order_line JOIN\n" +
                          "mathang406 as product ON order_line.MaMH = product.idMatHang406\n" +
                          "JOIN hoadon406 as sale_order ON order_line.MaHD = sale_order.idHoaDon406\n" +
                          "WHERE sale_order.ngay BETWEEN '"+ngaybd+"' AND '"+ngaykt+"'\n" +
                          "GROUP BY product.idMatHang406, product.name\n" +
                          "ORDER BY SUM(product.gia) DESC";
        try{
            conn = ConnectDatabase.getMySQLConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new ThongKe(rs.getInt(1), rs.getString(2), 
                                       rs.getInt(3)));
            }
            
        }catch(Exception e){
            
        }
        return list;
    }
}
