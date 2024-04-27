package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Model.Bean.Employee;
import java.time.Instant;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeDAO {

    Connection conn = null;
    Statement st = null;
    PreparedStatement preparedStatement = null;

    public Employee findEmployee(String id) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }
        String sql = "Select * from employees where id=?";

        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            int position = rs.getInt("position");
            int status = rs.getInt("status");
            String code = rs.getString("code");
            String contractStartAt = rs.getString("contract_start_at");
            String contractEndAt = rs.getString("contract_end_at");

            Employee employee = new Employee();
            employee.setId(Integer.parseInt(id));
            employee.setPosition(position);
            employee.setStatus(status);
            employee.setName(name);
            employee.setCode(code);
            employee.setContractEndAt(this.handleReverseDate(contractEndAt));
            employee.setContractStartAt(this.handleReverseDate(contractStartAt));

            return employee;
        }

        return null;
    }

    public int insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }

        try {
            st = (Statement) conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String code = this.generateCode(employee.getPosition(), conn);

        int result = 0;
        String insert = "INSERT INTO employees (code, name, status, position, "
                + "contract_start_at, contract_end_at, created_at, deleted_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) conn.prepareStatement(insert);
        preparedStatement.setString(1, code);
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setInt(3, employee.getStatus());
        preparedStatement.setInt(4, employee.getPosition());
        preparedStatement.setString(5, employee.getContractStartAt());
        preparedStatement.setString(6, employee.getContractEndAt());
        preparedStatement.setLong(7, employee.getCreatedAt());
        preparedStatement.setString(8, "");
        result = preparedStatement.executeUpdate();

        return result;
    }

    public ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }
        ArrayList<Employee> list = new ArrayList<Employee>();
        String sql = "Select * from employees WHERE deleted_at = '' ORDER BY created_at DESC";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int position = rs.getInt("position");
            int status = rs.getInt("status");
            String name = rs.getString("name");
            String code = rs.getString("code");
            String contractStartAt = rs.getString("contract_start_at");
            String contractEndAt = rs.getString("contract_end_at");

            Employee employee = new Employee();
            employee.setId(id);
            employee.setPosition(position);
            employee.setStatus(status);
            employee.setName(name);
            employee.setCode(code);
            employee.setContractEndAt(this.handleFormatDate(contractEndAt));
            employee.setContractStartAt(this.handleFormatDate(contractStartAt));

            list.add(employee);
        }

        return list;
    }

    public ArrayList<Employee> searchEmployees(String searchText) throws ClassNotFoundException, SQLException {
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }

        ArrayList<Employee> list = new ArrayList<Employee>();
        String sql = "Select * from employees where deleted_at = '' and (name like '%" + searchText + "%' "
                + "or code like '%" + searchText + "%')";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int position = rs.getInt("position");
            int status = rs.getInt("status");
            String name = rs.getString("name");
            String code = rs.getString("code");
            String contractStartAt = rs.getString("contract_start_at");
            String contractEndAt = rs.getString("contract_end_at");

            Employee employee = new Employee();
            employee.setId(id);
            employee.setPosition(position);
            employee.setStatus(status);
            employee.setName(name);
            employee.setCode(code);
            employee.setContractEndAt(this.handleFormatDate(contractEndAt));
            employee.setContractStartAt(this.handleFormatDate(contractStartAt));

            list.add(employee);
        }

        return list;
    }

    public int updateEmployee(Employee employee, int oldPosition) throws SQLException, ClassNotFoundException {

        int result = 0;
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }
        String sql = "Update employees set name=?,status=?, position=?, "
                + "contract_start_at=?, contract_end_at=?, code=? where id=? ";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, employee.getName());
        pstm.setInt(2, employee.getStatus());
        pstm.setInt(3, employee.getPosition());
        pstm.setString(4, employee.getContractStartAt());
        pstm.setString(5, employee.getContractEndAt());
        pstm.setString(6, oldPosition != employee.getPosition() ? 
                this.generateCode(employee.getPosition(), conn) : employee.getCode());
        pstm.setString(7, String.valueOf(employee.getId()));
        result = pstm.executeUpdate();

        return result;
    }

    public int deleteEmployee(String id) throws ClassNotFoundException, SQLException {
        int result = 0;
        if (conn == null) {
            conn = ConnectDatabase.getMySQLConnection();
        }
        System.out.println(id);
        String sql = "Update employees set deleted_at=? where id=?";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, String.valueOf(Instant.now().getEpochSecond()));
        pstm.setString(2, id);
        result = pstm.executeUpdate();

        return result;
    }

    public String generateCode(int position, Connection conn) throws SQLException {
        if (conn != null) {
            Map<String, Integer> positions = Employee.EMPLOYEE_POSITION;
            String sql = "";
            String code = "";

            if (position == positions.get("SALES")) {
                sql = "SELECT code FROM employees WHERE code LIKE '%SALE%' "
                        + "AND created_at = (SELECT MAX(created_at) FROM employees WHERE code LIKE '%SALE%')";
                code = "SALE";
            } else if (position == positions.get("CUSTOMER_CARE")) {
                sql = "SELECT code FROM employees WHERE code LIKE '%CC%' "
                        + "AND created_at = (SELECT MAX(created_at) FROM employees WHERE code LIKE '%CC%')";
                code = "CC";
            } else if (position == positions.get("WAREHOUSE")) {
                sql = "SELECT code FROM employees WHERE code LIKE '%WH%' "
                        + "AND created_at = (SELECT MAX(created_at) FROM employees WHERE code LIKE '%WH%')";
                code = "WH";
            }

            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            Matcher matcher = null;
            if (rs.next()) {
                Pattern pattern = Pattern.compile("\\d+"); // Biểu thức chính quy để tìm các số
                matcher = pattern.matcher(rs.getString("code"));
            }

            if (matcher != null && matcher.find()) {
                return code + String.valueOf(Integer.parseInt(matcher.group()) + 1);
            }
            return code + "1";
        }

        return "UNKNOWN";
    }

    public String handleFormatDate(String date) {
        if (date != "") {
            String[] dateParts = date.split("-");
            String day = dateParts[2];
            String month = dateParts[1];
            String year = dateParts[0];

            return day + "-" + month + "-" + year;
        }

        return "";
    }

    public String handleReverseDate(String date) {
        if (date != "") {
            String[] dateParts = date.split("-");
            String day = dateParts[2];
            String month = dateParts[1];
            String year = dateParts[0];

            return year + "-" + month + "-" + day;
        }

        return "";
    }
}
