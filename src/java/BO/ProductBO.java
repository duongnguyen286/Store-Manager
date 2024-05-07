package BO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import Model.Bean.Product;
import DAO.ProductDAO;

public class ProductBO {
	ProductDAO ProductDAO = new ProductDAO();

	public Product findProduct(String id) throws ClassNotFoundException, SQLException {

		return ProductDAO.findProduct(id);
	}

	public int insertProduct(Product product) throws SQLException, ClassNotFoundException {
		int result = 0;
		result = ProductDAO.insertProduct(product);
		String s ="ss";
		
		return result;
	}

	public ArrayList<Product> listProduct() throws ClassNotFoundException, SQLException {
		return ProductDAO.getAllProduct();
	}
	public ArrayList<Product> searchProduct(String name_search) throws ClassNotFoundException, SQLException {
		return ProductDAO.getSearchProduct(name_search);
	}

	public boolean deleteProduct(String id) throws ClassNotFoundException, SQLException {
		int result = ProductDAO.deleteProduct(id);
		if (result != 0)
			return true;
		return false;
	}
	public int deleteProductCategory(String category_id) throws ClassNotFoundException, SQLException {
		return ProductDAO.deleteProductCategory(category_id);
	}
	public boolean deleteAllProduct() throws ClassNotFoundException, SQLException {
		int result = ProductDAO.deleteAllProduct();
		if (result != 0)
			return true;
		return false;
	}

	public int updateProduct(Product Product) throws ClassNotFoundException, SQLException {
		return ProductDAO.updateProduct(Product);
	}

}
