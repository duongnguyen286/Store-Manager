/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.Bean;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
//    @BeforeClass
//    public static void setUp() {
//        Employee.initializeStaffStatus(); // Ensure static initialization
//    }

    @Test
    public void testConstructorWithParameters() {
        Employee employee = new Employee(1, "E001", "John Doe", 0, "2024-01-01", "2025-01-01", 1, 123456789);
        assertEquals(1, employee.getId());
        assertEquals("E001", employee.getCode());
        assertEquals("John Doe", employee.getName());
        assertEquals(0, employee.getPosition());
        assertEquals("2024-01-01", employee.getContractStartAt());
        assertEquals("2025-01-01", employee.getContractEndAt());
        assertEquals(1, employee.getStatus());
        assertEquals(123456789, employee.getCreatedAt());
    }

    @Test
    public void testConstructorWithoutParameters() {
        Employee employee = new Employee();
        assertNotNull(employee);
    }

    @Test
    public void testSettersAndGetters() {
        Employee employee = new Employee();

        employee.setId(1);
        assertEquals(1, employee.getId());

        employee.setCode("E001");
        assertEquals("E001", employee.getCode());

        employee.setName("John Doe");
        assertEquals("John Doe", employee.getName());

        employee.setPosition(0);
        assertEquals(0, employee.getPosition());

        employee.setContractStartAt("2024-01-01");
        assertEquals("2024-01-01", employee.getContractStartAt());

        employee.setContractEndAt("2025-01-01");
        assertEquals("2025-01-01", employee.getContractEndAt());

        employee.setStatus(1);
        assertEquals(1, employee.getStatus());

        employee.setCreatedAt(123456789);
        assertEquals(123456789, employee.getCreatedAt());

        employee.setDeletedAt("2023-12-31");
        assertEquals("2023-12-31", employee.getDeletedAt());
    }

    @Test
    public void testStaticInitialization() {
        Map<String, Integer> employeeStatus = Employee.EMPLOYEE_STATUS;
        Map<String, Integer> employeePosition = Employee.EMPLOYEE_POSITION;

        assertNotNull(employeeStatus);
        assertNotNull(employeePosition);

        assertEquals(0, (int) employeeStatus.get("INACTIVE"));
        assertEquals(1, (int) employeeStatus.get("ACTIVE"));

        assertEquals(0, (int) employeePosition.get("SALES"));
        assertEquals(1, (int) employeePosition.get("CUSTOMER_CARE"));
        assertEquals(2, (int) employeePosition.get("WAREHOUSE"));
    }
    
}
