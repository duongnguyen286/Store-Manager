package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.BookBO;
import BO.EmployeeBO;
import Model.Bean.Book;
import Model.Bean.Employee;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/search-employees")
public class SearchEmployees extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeBO employeeBO = new EmployeeBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployees() throws SQLException, ClassNotFoundException {
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
            request.setCharacterEncoding("UTF-8");
            String searchText = request.getParameter("searchText");
            String errorString = null;
            ArrayList<Employee> list = null;

            try {
                list = employeeBO.searchEmployees(searchText);
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            errorString = "Kết quả tìm kiếm cho từ khóa '" + searchText + "'";
            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("errorString", errorString);
            request.setAttribute("employees", list);

            // Forward sang /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/employee.jsp");
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
        doGet(request, response);
    }

}
