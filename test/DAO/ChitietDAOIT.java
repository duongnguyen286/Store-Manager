/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.Bean.ChiTiet;
import Model.Bean.chitiet1;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ChitietDAOIT {
    
    public ChitietDAOIT() {
    }

    /**
     * Test of ChiTiet method, of class ChitietDAO.
     */
    @Test
    public void testChiTiet() {
        String maMH = "74";
        int key=2;
        List<ChiTiet> result = ChitietDAO.ChiTiet(maMH);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        for(int i=0; i<result.size(); i++){
        Assert.assertTrue(result.get(i).getMaHD()==key);
    }
    }

    /**
     * Test of ChiTietNV method, of class ChitietDAO.
     */
    @Test
    public void testChiTietNV() {
        String maMH = "1";
        List<chitiet1> result = ChitietDAO.ChiTietNV(maMH);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }
    
}
