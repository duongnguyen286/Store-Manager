package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.BookBO;
import BO.CategoryBO;
import BO.EmployeeBO;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/delete-employee")
public class DeleteEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeBO employeeBO = new EmployeeBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
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
        String id = (String) request.getParameter("id");

        if (id != null) {
            boolean result;
            try {
                result = employeeBO.deleteEmployee(id);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        request.setAttribute("errorString", "Đã xóa thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employees");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
