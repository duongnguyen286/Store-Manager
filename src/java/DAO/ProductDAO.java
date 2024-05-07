package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import BO.CategoryBO;
import Model.Bean.Product;
import Model.Bean.Category;

public class ProductDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;
	CategoryBO categoryBO = new CategoryBO();

	public Product findProduct(String id) throws SQLException, ClassNotFoundException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from Product where id=?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			String category_id = rs.getString("category_id");
			Date date = rs.getDate("create_day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(date);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(category_id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setCategory(category);
			product.setAmount(amount);
			product.setImage(image);
			product.setDay(strDate);
			return product;
		}
		return null;
	}

	public int insertProduct(Product product) throws SQLException, ClassNotFoundException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		try {
			st = (Statement) conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = 0;
		String insert = "INSERT INTO Product (name, category_id, amount, image) VALUES (?,?, ?, ?)";
		preSt = (PreparedStatement) conn.prepareStatement(insert);
		preSt.setString(1, product.getName());
		preSt.setString(2, Integer.toString(product.getCategory().getId()));
		preSt.setString(3, product.getAmount());
		preSt.setString(4, product.getImage());
		result = preSt.executeUpdate();
		System.out.println("Ketqua" + result);
		return result;
	}

	public ArrayList<Product> getAllProduct() throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Product> list = new ArrayList<Product>();
		String sql = "Select * from Product ORDER BY create_day DESC";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String category_id = rs.getString("category_id");
			Date date = rs.getDate("create_day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(date);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(category_id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setCategory(category);
			product.setAmount(amount);
			product.setImage(image);
			product.setDay(strDate);
			list.add(product);
		}
		return list;
	}
	public ArrayList<Product> getSearchProduct(String name_search) throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		System.out.println("Day"+name_search);
		ArrayList<Product> list = new ArrayList<Product>();
		String sql = "Select * from Product where name like '%"+name_search+"%';";
//		String sql = "Select * from Product where name like '%l';";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String category_id = rs.getString("category_id");
			Date date = rs.getDate("create_day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(date);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(category_id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setCategory(category);
			product.setAmount(amount);
			product.setImage(image);
			product.setDay(strDate);
			list.add(product);
		}
		System.out.println(list);
		return list;
	}

	public int updateProduct(Product product) throws SQLException, ClassNotFoundException {
		
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Update Product set name =?,category_id =?,amount =?,image =?  where id=? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1, product.getName());
		pstm.setString(2, Integer.toString(product.getCategory().getId()));
		pstm.setString(3, product.getAmount());
		pstm.setString(4, product.getImage());
		pstm.setString(5, product.getId());
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteAllProduct() throws ClassNotFoundException, SQLException {
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Delete From Product";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteProduct(String id) throws ClassNotFoundException, SQLException {
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Delete From Product where id= ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, id);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteProductCategory(String category_id) throws ClassNotFoundException, SQLException {
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
//		String sql = "DELETE  Reader, Product FROM Reader INNER JOIN Product ON Reader.product_id = Product.id WHERE Product.category_id=?;";
		String sql = "Delete From Product where category_id= ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, category_id);
		result = pstm.executeUpdate();
		return result;
	}
}
