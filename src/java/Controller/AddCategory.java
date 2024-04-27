package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.CategoryBO;
import Model.Bean.Category;
import DAO.CategoryDAO;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBO categoryBO = new CategoryBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("User") == null) {
			String errorString = "Bạn cần đăng nhập trước";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add_category.jsp");
			dispatcher.forward(request, response);
		}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String name_category = request.getParameter("name_category");

	// Kiểm tra xem tên danh mục sản phẩm có bị để trống hay không
	if (name_category == null || name_category.trim().isEmpty()) {
		String errorString = "Tên danh mục sản phẩm không được để trống";
		request.setAttribute("errorString", errorString);
		
		// Chuyển hướng người dùng trở lại trang thêm danh mục sản phẩm và hiển thị thông báo lỗi
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add_category.jsp");
		dispatcher.forward(request, response);
	} else {
		Category category = new Category();
		category.setName(name_category);
		try {
			int result = categoryBO.insertCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ManageCategory");
	}
}

}
