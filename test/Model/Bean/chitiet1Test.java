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
public class chitiet1Test {
    
    public chitiet1Test() {
    }
    @Test
    public void testConstructorAndGetters() {
        chitiet1 item = new chitiet1(1, "2024-05-09", "Test Item", 123, "100");
        
        assertEquals(1, item.getIdHd());
        assertEquals("2024-05-09", item.getNgay());
        assertEquals("Test Item", item.getName());
        assertEquals(123, item.getIdKH());
        assertEquals("100", item.getTongtien());
    }

    @Test
    public void testSetters() {
        chitiet1 item = new chitiet1(0, "", "", 0, "");
        
        item.setIdHd(2);
        assertEquals(2, item.getIdHd());
        
        item.setNgay("2024-05-10");
        assertEquals("2024-05-10", item.getNgay());
        
        item.setName("New Test Item");
        assertEquals("New Test Item", item.getName());
        
        item.setIdKH(456);
        assertEquals(456, item.getIdKH());
        
        item.setTongtien("200");
        assertEquals("200", item.getTongtien());
    }

    @Test
    public void testToString() {
        chitiet1 item = new chitiet1(1, "2024-05-09", "Test Item", 123, "100");
        
        String expected = "chitiet1{idHd=1, ngay=2024-05-09, name=Test Item, idKH=123, tongtien=100}";
        assertEquals(expected, item.toString());
    }
    
}
