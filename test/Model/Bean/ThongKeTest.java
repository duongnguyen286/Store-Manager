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
public class ThongKeTest {
    
    public ThongKeTest() {
    }
     @Test
    public void testConstructorAndGetters() {
        ThongKe thongKe = new ThongKe(123, "Product A", 10, "1000");
        
        assertEquals(Integer.valueOf(123), thongKe.getMaMH());
        assertEquals("Product A", thongKe.getName());
        assertEquals(Integer.valueOf(10), thongKe.getSoluong());
        assertEquals("1000", thongKe.getDoanhthu());
    }

    @Test
    public void testSetters() {
        ThongKe thongKe = new ThongKe();
        
        thongKe.setMaMH(456);
        assertEquals(Integer.valueOf(456), thongKe.getMaMH());
        
        thongKe.setName("Product B");
        assertEquals("Product B", thongKe.getName());
        
        thongKe.setSoluong(20);
        assertEquals(Integer.valueOf(20), thongKe.getSoluong());
        
        thongKe.setDoanhthu("2000");
        assertEquals("2000", thongKe.getDoanhthu());
    }

    @Test
    public void testToString() {
        ThongKe thongKe = new ThongKe(123, "Product A", 10, "1000");
        
        String expected = "ThongKe{maMH=123, name=Product A, soluong=10, doanhthu=1000}";
        assertEquals(expected, thongKe.toString());
    }
    
}
