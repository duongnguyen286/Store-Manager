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
         <title>Chi tiết các giao dịch</title>
    <style>
        body {      
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding-top: 30px;
            padding-left: 20px;
          
        }
        table {
            border-collapse: collapse;
            width: 95%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 6px;
            text-align: left;
            
        }
        th {
/*            background-color: #333;*/
            color: #333;
        }
        h1 {
            margin-top: 20px;
            color: #333;
            font-weight: 400;
            font-size: 1.1rem;
            line-height: 1.2;
            color: inherit;
            
        }
    </style>
<div class="content-wrapper">
        <h1 >Chi tiết các giao dịch</h1>
    <table>
        <tr>
            <th>Mã mặt hàng</th>
            <th>Tên mặt hàng</th>
            <th>Mã hóa đơn</th>           
            <th>Số lượng</th>
            <th>Ngày bán</th>
            <th>Mã nhân viên bán hàng</th>
            <th>Mã khách hàng</th>
        </tr>    
        <c:forEach items="${chiTietList}" var="c">
            <tr>
                <td>${c.maMH}</td>
                <td>${c.name}</td>
                <td>${c.maHD}</td>
                <td>${c.soLuong}</td>
                <td>${c.ngay}</td>
                <td>${c.maNVBH}</td>          
                <td>${c.maKH}</td>
            </tr>
        </c:forEach>
    </table>
</div>
        <%@ include file="footer.jsp"%>

