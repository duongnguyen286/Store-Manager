<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
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
        <h1 style="margin-left: 250px;">Kết quả thống kê mặt hàng theo doanh thu</h1>
    <table style="margin-left: 250px; text-align: center;" border="1">
        <tr>
            <th>Mã mặt hàng</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng đã bán</th>
            <th>Doanh thu</th>
            <th>Chi tiết giao dịch</th>
        </tr>
        <c:forEach items="${thongKeList}" var="p">
            <tr>
                <td>${p.maMH}</td>
                <td>${p.name}</td>
                <td>${p.soluong}</td>
                <td>${p.doanhthu}</td>
                <td><a href="chitiet?sid=${p.maMH}">click</a></td>
            </tr>
        </c:forEach>
    </table>
<%--<%@ include file="footer.jsp"%>--%>

