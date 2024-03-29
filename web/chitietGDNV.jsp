<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Chi tiết các giao dịch</title>
    <style>
        table {
            border-collapse: collapse;
            width: 75%;
            margin: 20px auto;
            margin-left: 270px;
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
        <h1 style="margin-left: 270px">Chi tiết các giao dịch</h1>
    <table>
        <tr>
            <th>Mã hóa đơn</th>
            <th>Ngày</th>
            <th>Tên nhân viên</th>           
            <th>Mã khách hàng</th>
            <th>Tổng tiền</th>
        </tr>    
        <c:forEach items="${chiTietNVList}" var="c">
            <tr>
                <td>${c.idHd}</td>
                <td>${c.ngay}</td>
                <td>${c.name}</td>
                <td>${c.idKH}</td>
                <td>${c.tongtien}</td>          
            </tr>
        </c:forEach>
    </table>

