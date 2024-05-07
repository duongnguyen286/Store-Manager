<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<script src="Resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script
src="Resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script
src="Resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script
src="Resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="Resources/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Resources/dist/js/demo.js"></script>
<style>
        body {
            
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
       
        }

        #container {

/*            max-width: 600px;*/
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            
/*            box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.3);
            border-radius: 5px;*/
        }

        label {
            font-weight: bold;
        }

        #labelThongKe {
            cursor: pointer;
/*            text-decoration: underline;*/
            text-align: center;
            background-color: red;
            color: white;
            border-radius: 0.25rem;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            line-height: 1.5;
            border: 1px solid transparent;
            font-weight: 400;
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            box-shadow: none;
          
        }

        select, input[type="date"], button {
            display: block;
            margin: 10px 0;
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        #ketqua {
            margin-top: 20px;
        }
        h1{
            font-size: 17px;
        }
        #type{
/*            padding-bottom: 5px;
            padding-top: 3px;
            font-size: 14px;*/
            color: #fff;
            background-color: #dc3545;
            border-color: #dc3545;
            box-shadow: none;
            cursor: pointer;
            line-height: 1.5;
            border-radius: 0.25rem;
            text-align: center;
            vertical-align: middle;
            display: inline-block;
            font-weight: 400;
            padding-left: 10px;
            padding-right: 10px;
            
        }
    </style>
    <div class="content-wrapper">
    <div id="container">
<!--        <label  for="thongke" id="labelThongKe" onclick="hienThiOption()">Xem báo cáo</label>-->
        <div id="optionThongKe">
            
             <form id="statisticForm" action="/StatisticServlet" method="post" >
                 <h1>Loại thống kê:</h1>
                    <select id="thongke" name="thongke1">
                        <option value="doanhthumh">Thống kê mặt hàng theo doanh thu</option>
                        <option value="doanhthunv">Thống kê nhân viên theo doanh thu</option>                      
                    </select>
                    Từ ngày: <input type="date" name="startDate" required>
                    Đến ngày: <input type="date" name="endDate" required>
                    <input id="type" type="submit" value="Xem">
                    
            </form>
        </div>

        <div id="ketqua">
            <!-- Kết quả thống kê sẽ được hiển thị ở đây -->
        </div>
    </div>
    </div>
    <script>
//        function hienThiOption() {
//            const optionThongKe = document.getElementById("optionThongKe");
//            optionThongKe.style.display = "block";
//        }
        document.getElementById("statisticForm").addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            event.preventDefault(); // Ngăn chặn hành động mặc định của phím Enter
            document.getElementById("type").click(); // Kích hoạt sự kiện click trên nút submit
        }
    });  
     document.getElementById("statisticForm").addEventListener("submit", function(event) {
        // Lấy giá trị của ngày bắt đầu và ngày kết thúc từ form
        var startDate = document.getElementsByName("startDate")[0].value;
        var endDate = document.getElementsByName("endDate")[0].value;

        // Chuyển đổi ngày từ chuỗi sang đối tượng Date để so sánh
        var startDateObj = new Date(startDate);
        var endDateObj = new Date(endDate);

        // Kiểm tra nếu startDate không trước endDate
        if (startDateObj >= endDateObj) {
            // Ngăn chặn form được submit
            event.preventDefault();
            // Hiển thị thông báo cho người dùng
            alert("Ngày bắt đầu phải trước ngày kết thúc!");
        }
    });
    </script>
<%@ include file="footer.jsp"%>