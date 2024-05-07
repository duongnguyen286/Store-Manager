/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.Bean.User;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class UserDAOIT {
    
    public UserDAOIT() {
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() throws Exception {
        String usname="admin";
        String pass="123456";
        UserDAO userDAO = new UserDAO();
	User user_find = userDAO.getUser(usname, pass);
        Assert.assertNotNull(user_find);
        assertEquals("1", user_find.getId());
        
    }

    /**
     * Test of findUser method, of class UserDAO.
     */
    @Test
    public void testFindUser() throws Exception {
        String usname="admin";
        UserDAO userDAO = new UserDAO();
	User user_find = userDAO.findUser(usname);
        Assert.assertNotNull(user_find);
        assertEquals("1", user_find.getId());
        
    }
    
}
