package Controller;
import DAO.ThongkeDAO;
import Model.Bean.ThongKe;
import Model.Bean.ThongKe1;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Statistic", urlPatterns={"/StatisticServlet"})
public class StatisticServlet extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {    
        processRequest(request, response);
        String thongKeOption = request.getParameter("thongke1");
        System.out.println("Thống kê option: " + thongKeOption);
        String ngayBD=request.getParameter("startDate");
        String ngayKT=request.getParameter("endDate");
        System.out.println("Thống kê option: " + ngayKT);
        if("doanhthumh".equals(thongKeOption)){
            List<ThongKe>thongKeList = ThongkeDAO.search(ngayBD,ngayKT);
            System.out.println(thongKeList);
            request.setAttribute("thongKeList", thongKeList);
            request.getRequestDispatcher("thongke.jsp").forward(request, response);
        }
        else{
            List<ThongKe1>thongKeNvList = ThongkeDAO.search1(ngayBD,ngayKT);
            System.out.println(thongKeNvList);
            request.setAttribute("thongKeNvList", thongKeNvList);
            request.getRequestDispatcher("thongkenv.jsp").forward(request, response);
        }
        
           
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
//    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
