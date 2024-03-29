<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Chi tiết các giao dịch</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
    </head>
    <body>
        <h1>Chi tiết các giao dịch</h1>
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
    </body>
</html>
