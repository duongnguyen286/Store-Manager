/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.Bean.ThongKe;
import Model.Bean.ThongKe1;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ThongkeDAOIT {
    
    public ThongkeDAOIT() {
    }

    /**
     * Test of search method, of class ThongkeDAO.
     */
    @Test
    public void testSearch() {
        String ngaybd="2021-01-02";
        String ngaykt="2025-01-02";
        ThongkeDAO th= new ThongkeDAO();
        List<ThongKe>thongKeList = th.search(ngaybd,ngaykt);
        Assert.assertNotNull(thongKeList);
        Assert.assertEquals(4, thongKeList.size());
        
    }

    /**
     * Test of search1 method, of class ThongkeDAO.
     */
    @Test
    public void testSearch1() {
        String ngaybd="2021-01-02";
        String ngaykt="2025-01-02";
        ThongkeDAO th= new ThongkeDAO();
        List<ThongKe1>thongKeList = th.search1(ngaybd,ngaykt);
        Assert.assertNotNull(thongKeList);
        Assert.assertEquals(2, thongKeList.size());
    }
    
}
