package DAO;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import Model.Bean.Category;
import Model.Bean.Product;

public class ProductDAOIT {
    
    public ProductDAOIT() {
    }

    /**
     * Test of findProduct method, of class ProductDAO.
     */
    @Test
    public void testFindProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Test with an existing product
        String existingProductId = "77";
        Product foundProduct = productDAO.findProduct(existingProductId);
        assertNotNull("Product should not be null", foundProduct);
        assertEquals("77", foundProduct.getId());
        
        // Test with a non-existing product
        String nonExistingProductId = "999";
        Product notFoundProduct = productDAO.findProduct(nonExistingProductId);
        assertNull("Product should be null", notFoundProduct);
    }

    /**
     * Test of insertProduct method, of class ProductDAO.
     */
    @Test
    public void testInsertProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Create a new product
        Product product = new Product();
        product.setName("Test Product");
        product.setCategory(new Category(34, "Test Category"));
        product.setAmount("100");
        product.setImage("test.jpg");

        // Insert the product
        int result = productDAO.insertProduct(product);
        
        // Verify that product is inserted successfully
        assertEquals(1, result);
    }

    /**
     * Test of getAllProduct method, of class ProductDAO.
     */
    @Test
    public void testGetAllProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Get all products
        List<Product> productList = productDAO.getAllProduct();
        
        // Verify that productList is not null
        assertNotNull(productList);
        // Add more assertions as needed...
    }

    /**
     * Test of getSearchProduct method, of class ProductDAO.
     */
    @Test
    public void testGetSearchProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Search for products
        String searchTerm = "Test";
        List<Product> productList = productDAO.getSearchProduct(searchTerm);
        
        // Verify that productList is not null
        assertNotNull(productList);
        // Add more assertions as needed...
    }

    /**
     * Test of updateProduct method, of class ProductDAO.
     */
    @Test
    public void testUpdateProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Create a new product
        Product product = new Product();
        product.setId("77");
        product.setName("Updated Product");
        product.setCategory(new Category(34, "Updated Category"));
        product.setAmount("50");
        product.setImage("updated.jpg");

        // Update the product
        int result = productDAO.updateProduct(product);
        
        // Verify that product is updated successfully
        assertEquals(1, result);
    }

    

    /**
     * Test of deleteProduct method, of class ProductDAO.
     */
    @Test
    public void testDeleteProduct() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Delete a specific product
        String productId = "1";
        int result = productDAO.deleteProduct(productId);
        
        // Verify that the product is deleted
        // Add more assertions as needed...
    }

    /**
     * Test of deleteProductCategory method, of class ProductDAO.
     */
    @Test
    public void testDeleteProductCategory() throws Exception {
        // Initialize ProductDAO and mock objects
        ProductDAO productDAO = new ProductDAO();
        
        // Delete all products in a specific category
        String categoryId = "1";
        int result = productDAO.deleteProductCategory(categoryId);
        
        // Verify that all products in the category are deleted
        // Add more assertions as needed...
    }
    
}
