package DAO;

import Model.Bean.Employee;
import org.junit.Assert;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

import static Model.Bean.Employee.EMPLOYEE_POSITION;
import static Model.Bean.Employee.EMPLOYEE_STATUS;

public class EmployeeDAOTest {

    @Test
    public void testFindEmployee() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* exception scenario */
        Employee employee = employeeDAO.findEmployee("1");
        Assert.assertNull(employee);

        /* standard scenario */
        employee = employeeDAO.findEmployee("57");
        Assert.assertNotNull(employee);
        Assert.assertEquals("Nguyễn Đăng Huy", employee.getName());
        Assert.assertEquals((int) EMPLOYEE_POSITION.get("SALES"), employee.getPosition());
        Assert.assertEquals("2024-03-02", employee.getContractStartAt());
        Assert.assertEquals("2024-03-31", employee.getContractEndAt());
        Assert.assertEquals((int) EMPLOYEE_STATUS.get("ACTIVE"), employee.getStatus());
    }

    @Test
    public void testInsertEmployee() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee newEmployee = new Employee(
                "Nguyễn Minh Tuân",
                EMPLOYEE_POSITION.get("WAREHOUSE"),
                "2025-11-02",
                "2027-11-02",
                EMPLOYEE_STATUS.get("ACTIVE"),
                (int) Instant.now().getEpochSecond()
        );
        Connection connection = employeeDAO.conn;

        try {
            connection.setAutoCommit(false);
            employeeDAO.insertEmployee(newEmployee);
            Assert.assertNotNull(newEmployee);
            Assert.assertTrue(57 < newEmployee.getId());
            Assert.assertEquals(4, employeeDAO.getAllEmployees().size());

            Employee employee = employeeDAO.findEmployee(Integer.toString(newEmployee.getId()));
            Assert.assertEquals(newEmployee.getName(), employee.getName());
            Assert.assertEquals(newEmployee.getPosition(), employee.getPosition());
            Assert.assertEquals(newEmployee.getStatus(), employee.getStatus());
            Assert.assertEquals(newEmployee.getContractStartAt(), employee.getContractStartAt());
            Assert.assertEquals(newEmployee.getContractEndAt(), employee.getContractEndAt());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetAllEmployees() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<Employee> employees = employeeDAO.getAllEmployees();
        Assert.assertNotNull(employees);
        Assert.assertEquals(3, employees.size());
    }

    @Test
    public void testSearchEmployees() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* exception scenario 1 */
        String keySearch = "qqwertyuiop";
        ArrayList<Employee> employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(0, employees.size());

        /* exception scenario 2 */
        keySearch = "zxcvbnm,kugfcxsdfgahsd";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(0, employees.size());

        /* exception scenario 3 */
        keySearch = "SALE100";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(0, employees.size());

        /* standard scenario 1 (search by employee name) */
        keySearch = "Nguyễn Quang Khải";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertNotEquals(0, employees.size());
        for (int i = 0; i < employees.size(); i++) {
            Assert.assertTrue(employees.get(i).getName().toLowerCase().contains(keySearch.toLowerCase()));
        }

        /* standard scenario 2 (search employees by name) */
        keySearch = "Khả";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(1, employees.size());
        for (int i = 0; i < employees.size(); i++) {
            Assert.assertTrue(employees.get(i).getName().toLowerCase().contains(keySearch.toLowerCase()));
        }

        /* standard scenario 3 (search employees by code in lowercase) */
        keySearch = "sale";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(2, employees.size());
        for (int i = 0; i < employees.size(); i++) {
            Assert.assertTrue(employees.get(i).getCode().toLowerCase().contains(keySearch.toLowerCase()));
        }

        /* standard scenario 3 (search employees by code in uppercase) */
        keySearch = "SALE";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(2, employees.size());

        /* standard scenario 4 (search employees by code in uppercase and lowercase) */
        keySearch = "SaLe";
        employees = employeeDAO.searchEmployees(keySearch);
        Assert.assertNotNull(employees);
        Assert.assertEquals(2, employees.size());
    }

    @Test
    public void testUpdateEmployee() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(
                "Nguyễn Minh Tuân cũ",
                EMPLOYEE_POSITION.get("CUSTOMER_CARE"),
                "2021-11-07",
                "2024-11-07",
                EMPLOYEE_STATUS.get("INACTIVE"),
                (int) Instant.now().getEpochSecond()
        );
        int oldPosition = employee.getPosition();
        Connection connection = employeeDAO.conn;

        try {
            connection.setAutoCommit(false);
            employeeDAO.insertEmployee(employee);

            String name = "Nguyễn Minh Tuân";
            int position = EMPLOYEE_POSITION.get("WAREHOUSE");
            String contractStartAt = "2025-11-02";
            String contractEndAt = "2027-11-02";
            int status = EMPLOYEE_STATUS.get("ACTIVE");

            employee.setName(name);
            employee.setPosition(position);
            employee.setContractEndAt(contractEndAt);
            employee.setContractStartAt(contractStartAt);
            employee.setStatus(status);
            employeeDAO.updateEmployee(employee, oldPosition);

            Employee updatedEmployee = employeeDAO.findEmployee(Integer.toString(employee.getId()));
            Assert.assertEquals(name, updatedEmployee.getName());
            Assert.assertEquals(contractStartAt, updatedEmployee.getContractStartAt());
            Assert.assertEquals(contractEndAt, updatedEmployee.getContractEndAt());
            Assert.assertEquals(status, updatedEmployee.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDeleteEmployee() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(
                "Nguyễn Minh Tuân cũ",
                EMPLOYEE_POSITION.get("CUSTOMER_CARE"),
                "2021-11-07",
                "2024-11-07",
                EMPLOYEE_STATUS.get("INACTIVE"),
                (int) Instant.now().getEpochSecond()
        );
        Connection connection = employeeDAO.conn;

        try {
            connection.setAutoCommit(false);
            employeeDAO.insertEmployee(employee);
            employeeDAO.deleteEmployee(Integer.toString(employee.getId()));
            Assert.assertEquals(3, employeeDAO.getAllEmployees().size());

            Employee deletedEmployee = employeeDAO.findEmployee(Integer.toString(employee.getId()));
            Assert.assertNull(deletedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGenerateCode() throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(
                "Nguyễn Minh Tuân",
                10,
                "2021-11-07",
                "2024-11-07",
                EMPLOYEE_STATUS.get("INACTIVE"),
                (int) Instant.now().getEpochSecond()
        );
        Connection connection = employeeDAO.conn;

        try {
            connection.setAutoCommit(false);

            /* exception scenario (unknown employee position) */
            String code = employeeDAO.generateCode(employee.getPosition(), (com.mysql.jdbc.Connection) connection);
            Assert.assertEquals("UNKNOWN", code);

            /* standard scenario */
            employee.setPosition(EMPLOYEE_POSITION.get("CUSTOMER_CARE"));
            code = employeeDAO.generateCode(employee.getPosition(), (com.mysql.jdbc.Connection) connection);
            Assert.assertEquals("CC2", code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}