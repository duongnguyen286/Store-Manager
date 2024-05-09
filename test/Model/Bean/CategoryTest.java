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
public class CategoryTest {
    
    public CategoryTest() {
    }
     @Test
    public void testGettersAndSetters() {
        Category category = new Category();

        category.setId(1);
        assertEquals(1, category.getId());

        category.setName("Test Category");
        assertEquals("Test Category", category.getName());
    }

    @Test
    public void testConstructorWithParameters() {
        Category category = new Category(1, "Test Category");
        assertEquals(1, category.getId());
        assertEquals("Test Category", category.getName());
    }

    @Test
    public void testConstructorWithoutParameters() {
        Category category = new Category();
        assertNotNull(category);
    }
    
}
