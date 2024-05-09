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
public class ThongKe1Test {
    
    public ThongKe1Test() {
    }
     @Test
    public void testConstructorAndGetters() {
        ThongKe1 thongKe = new ThongKe1(123, "John Doe", "1000");
        
        assertEquals(123, thongKe.getMaNV());
        assertEquals("John Doe", thongKe.getName());
        assertEquals("1000", thongKe.getDoanhthu());
    }

    @Test
    public void testSetters() {
        ThongKe1 thongKe = new ThongKe1(0, "", "");
        
        thongKe.setMaNV(456);
        assertEquals(456, thongKe.getMaNV());
        
        thongKe.setName("Jane Doe");
        assertEquals("Jane Doe", thongKe.getName());
        
        thongKe.setDoanhthu("2000");
        assertEquals("2000", thongKe.getDoanhthu());
    }

    @Test
    public void testToString() {
        ThongKe1 thongKe = new ThongKe1(123, "John Doe", "1000");
        
        String expected = "ThongKe1{maNV=123, name=John Doe, doanhthu=1000}";
        assertEquals(expected, thongKe.toString());
    }
    
}
