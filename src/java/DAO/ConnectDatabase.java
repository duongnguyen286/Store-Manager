package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectDatabase {

    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/manage_library?allowPublicKeyRetrieval=true&useSSL=false";
//		String dbURL = "jdbc:mysql://node238128-lemanhltm.j.layershift.co.uk/manage_library?characterEncoding=UTF-8";
        String username = "root";
        String password = "Tunham123456789";
//		String password = "KROmim21616";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(dbURL, username, password);
        if (conn != null) {
            System.out.println("Kết nối thành công");
            conn.setCharacterEncoding("utf-8");
            return conn;
        }
        return null;
    }
}
