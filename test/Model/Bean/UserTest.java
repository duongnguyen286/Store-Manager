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
public class UserTest {
    
    public UserTest() {
    }
     @Test
    public void testConstructorAndGetters() {
        User user = new User();
        
        assertNull(user.getId());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        
        user.setId("123");
        assertEquals("123", user.getId());
        
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
        
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testSetters() {
        User user = new User();
        
        user.setId("456");
        assertEquals("456", user.getId());
        
        user.setEmail("user@example.com");
        assertEquals("user@example.com", user.getEmail());
        
        user.setPassword("123password");
        assertEquals("123password", user.getPassword());
    }
    
}
