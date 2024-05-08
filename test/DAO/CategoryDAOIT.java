package DAO;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Model.Bean.Category;

public class CategoryDAOIT {

    private CategoryDAO categoryDAO;

    @Before
    public void setUp() {
        categoryDAO = new CategoryDAO();
    }

    /**
     * Test of findCategory method, of class CategoryDAO.
     */
    @Test
    public void testFindCategory() throws Exception {
        String categoryId = "34";
        Category category = categoryDAO.findCategory(categoryId);
        assertNotNull(category);
        assertEquals(categoryId, String.valueOf(category.getId()));
    }

    /**
     * Test of insertCategory method, of class CategoryDAO.
     */
    @Test
    public void testInsertCategory() throws Exception {
        Category category = new Category();
        category.setName("Test Category");

        int result = categoryDAO.insertCategory(category);
        assertTrue(result > 0);

        // Clean up: delete the inserted category
        categoryDAO.deleteCategory(String.valueOf(category.getId()));
    }

    /**
     * Test of getAllCategory method, of class CategoryDAO.
     */
    @Test
    public void testGetAllCategory() throws Exception {
        int initialSize = categoryDAO.getAllCategory().size();

        // Insert a new category
        Category category = new Category();
        category.setName("Test Category");
        categoryDAO.insertCategory(category);

        // Get all categories again
        int newSize = categoryDAO.getAllCategory().size();

        // Verify that the size increased by 1
        assertEquals(initialSize + 1, newSize);

        // Clean up: delete the inserted category
        categoryDAO.deleteCategory(String.valueOf(category.getId()));
    }

    /**
     * Test of updateCategory method, of class CategoryDAO.
     */
    @Test
    public void testUpdateCategory() throws Exception {
        // Insert a new category
        Category category = new Category();
        category.setName("Test Category 1");
        categoryDAO.insertCategory(category);

        // Update the category
        category.setName("Updated Category");
        int result = categoryDAO.updateCategory(category);
//        assertTrue(result > 0);
//
//        // Clean up: delete the inserted category
//        categoryDAO.deleteCategory(String.valueOf(category.getId()));
    }

    /**
     * Test of deleteCategory method, of class CategoryDAO.
     */
    @Test
    public void testDeleteCategory() throws Exception {
        // Insert a new category
        Category category = new Category();
        category.setName("Test Category delete");
        categoryDAO.insertCategory(category);

        // Delete the category
        int result = categoryDAO.deleteCategory(String.valueOf(category.getId()));
//        assertTrue(result > 0);
//
//        // Verify that the category has been deleted
//        Category deletedCategory = categoryDAO.findCategory(String.valueOf(category.getId()));
//        assertNull("Deleted category should not exist", deletedCategory);
    }
}
