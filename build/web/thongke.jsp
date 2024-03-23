<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
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
    </head>
    <body>
        <h1>Kết quả thống kê mặt hàng theo doanh thu</h1>
    <table border="1">
        <tr>
            <th>Mã mặt hàng</th>
            <th>Tên sản phẩm</th>
            <th>Doanh thu</th>
             <th>Chi tiết giao dịch</th>
        </tr>
        <c:forEach items="${thongKeList}" var="p">
            <tr>
                <td>${p.maMH}</td>
                <td>${p.name}</td>
                <td>${p.doanhthu}</td>
                <td><a href="chitiet?sid=${p.maMH}">click</a></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
