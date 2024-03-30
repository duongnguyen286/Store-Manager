<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kết quả thống kê</title>       
        <style>
        body {      
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding-top: 30px;
            padding-left: 20px;
          
        }
        
        h1 {
            margin-top: 20px;
            color: #333;
            font-weight: 400;
            font-size: 1.1rem;
            line-height: 1.2;
            color: inherit;
            
        }

        table {
            margin-left: 250px;
            border-collapse: collapse;
            width: 95%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
/*            background-color: #333;*/
            color: #333;
        }
         td a:hover {
            color: red
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
    <div class="content-wrapper">

        <h1>Kết quả thống kê mặt hàng theo doanh thu</h1>
    <table style="text-align: center;" border="1">
        <tr>
            <th>Mã nhân viên</th>
            <th>Tên sản phẩm</th>
            <th>Doanh thu</th>
            <th>Chi tiết giao dịch</th>
        </tr>
        <c:forEach items="${thongKeNvList}" var="p">
            <tr>
                <td>${p.maNV}</td>
                <td>${p.name}</td>
                <td>${p.doanhthu}</td>
                <td><a href="chitiet1?sid=${p.maNV}">click</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
        
<%@ include file="footer.jsp"%>

