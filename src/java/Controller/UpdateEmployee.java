package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import BO.BookBO;
import BO.CategoryBO;
import BO.EmployeeBO;
import Model.Bean.Book;
import Model.Bean.Category;
import Model.Bean.Employee;
import java.util.Date;
import java.util.Map;

/**
 * Servlet implementation class EditCategory
 */
@MultipartConfig
@WebServlet("/update-employee")
public class UpdateEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeBO employeeBO = new EmployeeBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() throws SQLException, ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if (request.getSession().getAttribute("User") == null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            String id = (String) request.getParameter("id");

            Map<String, Integer> positions = Employee.EMPLOYEE_POSITION;
            String errorString = null;

            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }

            Employee employee = new Employee();

            try {
                employee = employeeBO.findEmployee(id);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }

            request.setAttribute("employee", employee);
            request.setAttribute("positions", positions);

            request.getSession().setAttribute("Check", "Employee");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/update-employee.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String contractStartAt = request.getParameter("contract_start_at");
        String contractEndAt = request.getParameter("contract_end_at");
        int position = Integer.parseInt(request.getParameter("position"));
        String status = request.getParameter("status");
        String code = request.getParameter("code");
        int oldPosition = Integer.parseInt(request.getParameter("old_position"));

        if (id != null) {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(id));
            employee.setName(name);
            employee.setPosition(position);
            employee.setStatus((status != null && status.equals("on")) ? 1 : 0);
            employee.setContractStartAt(contractStartAt);
            employee.setContractEndAt(contractEndAt);
            employee.setCode(code);

            int result = 0;
            String errorString = null;
            try {
                result = employeeBO.updateEmployee(employee, oldPosition);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if (result == 0 && errorString == null) {
                errorString = "Chỉnh sửa thất bại";
            }
            if (result == 1) {
                errorString = "Chỉnh sửa thành công";
            }
            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("errorString", errorString);

            doGet(request, response);
        }

    }
}
