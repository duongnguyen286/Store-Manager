/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.Bean;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ProductTest {
    
    public ProductTest() {
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGettersAndSetters() {
        Product product = new Product();

        product.setId("P001");
        assertEquals("P001", product.getId());

        product.setName("Sample Product");
        assertEquals("Sample Product", product.getName());

        product.setImage("sample_image.jpg");
        assertEquals("sample_image.jpg", product.getImage());

        product.setAmount("10");
        assertEquals("10", product.getAmount());

        product.setDay("2024-05-09");
        assertEquals("2024-05-09", product.getDay());

        Category category = new Category();
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testConstructor() {
        Product product = new Product();
        assertNotNull(product);
    }
    
}
