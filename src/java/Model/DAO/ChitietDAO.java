/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

//import dao.*;
import Model.DAO.ConnectDatabase;
import entity.ChiTiet;
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
        String query="SELECT \n" +
                     "    mathang406.idMatHang406 AS maMH,\n" +
                     "    mathang406.name AS name,\n" +
                     "    hoadon406.idHoaDon406 AS maHD,\n" +
                     "	hoadonmathang406.SoLuong AS SoLuong,\n" +
                     "    hoadon406.ngay AS Ngày,\n" +
                     "    hoadon406.idNVBH AS maNVBH,\n" +
                     "    hoadon406.idNVK AS maNVK,\n" +
                     "    hoadon406.idKH AS maKH\n" +
                     "FROM mathang406 JOIN hoadonmathang406 ON mathang406.idMatHang406 = hoadonmathang406.maMH\n" +
                     "JOIN hoadon406 ON hoadonmathang406.MaHD = hoadon406.idHoaDon406\n" +
                     "WHERE mathang406.idMatHang406 = '"+maMH+"' ";
        try {
            conn = ConnectDatabase.getMySQLConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new ChiTiet(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                                     rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8)));
            }
            System.out.println(query);   
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
