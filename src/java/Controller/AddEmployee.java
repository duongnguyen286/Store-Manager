/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BO.EmployeeBO;
import Model.Bean.Employee;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@MultipartConfig
@WebServlet("/add-employee")
public class AddEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeBO employeeBO = new EmployeeBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() throws SQLException, ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("User") == null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            Map<String, Integer> positions = Employee.EMPLOYEE_POSITION;
            String errorString = null;

            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("errorString", errorString);
            request.setAttribute("positions", positions);
            request.getSession().setAttribute("Check", "Employee");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add-employee.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String contractStartAt = request.getParameter("contract_start_at");
        String contractEndAt = request.getParameter("contract_end_at");
        int position = Integer.parseInt(request.getParameter("position"));
        String status = request.getParameter("status");
        
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setStatus((status != null && status.equals("on")) ? 1 : 0);
        employee.setContractStartAt(contractStartAt);
        employee.setContractEndAt(contractEndAt);
        employee.setCreatedAt((int) Instant.now().getEpochSecond());

        try {
            employeeBO.insertEmployee(employee);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("errorString", "Tạo mới nhân viên thành công");
        doGet(request, response);
    }

}
