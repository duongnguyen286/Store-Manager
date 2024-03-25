package BO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.EmployeeDAO;
import Model.Bean.Employee;

public class EmployeeBO {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employee findEmployee(String id) throws ClassNotFoundException, SQLException {
        return employeeDAO.findEmployee(id);
    }

    public int insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int result = 0;
        result = employeeDAO.insertEmployee(employee);

        return result;
    }

    public ArrayList<Employee> listEmployees() throws ClassNotFoundException, SQLException {
        return employeeDAO.getAllEmployees();
    }

    public ArrayList<Employee> searchEmployees(String searchText) throws ClassNotFoundException, SQLException {
        return employeeDAO.searchEmployees(searchText);
    }

    public boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException {
        int result = employeeDAO.deleteEmployee(id);
        if (result != 0) {
            return true;
        }
        return false;
    }

    public int updateEmployee(Employee employee, int oldPosition) throws ClassNotFoundException, SQLException {
        return employeeDAO.updateEmployee(employee, oldPosition);
    }
}
