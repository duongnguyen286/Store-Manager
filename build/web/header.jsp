<%@page import="Model.Bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <meta charset="utf-8">
        <style>
            .switch {
                position: relative;
                display: inline-block;
                width: 60px;
                height: 34px;
            }

            .switch input {
                opacity: 0;
                width: 0;
                height: 0;
            }

            .slider {
                position: absolute;
                cursor: pointer;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: #ccc;
                -webkit-transition: .4s;
                transition: .4s;
            }

            .slider:before {
                position: absolute;
                content: "";
                height: 26px;
                width: 26px;
                left: 4px;
                bottom: 4px;
                background-color: white;
                -webkit-transition: .4s;
                transition: .4s;
            }

            input:checked + .slider {
                background-color: #2196F3;
            }

            input:focus + .slider {
                box-shadow: 0 0 1px #2196F3;
            }

            input:checked + .slider:before {
                -webkit-transform: translateX(26px);
                -ms-transform: translateX(26px);
                transform: translateX(26px);
            }

            /* Rounded sliders */
            .slider.round {
                border-radius: 34px;
            }

            .slider.round:before {
                border-radius: 50%;
            }

            .switch {
                position: relative;
                display: inline-block;
            }

            /* Tooltip text */
            .switch .tooltiptext {
                visibility: hidden;
                width: 150px;
                height: 30px;
                background-color: black;
                color: white;
                text-align: center;
                padding: 5px 0;
                border-radius: 6px;

                /* Position the tooltip text - see examples below! */
                position: absolute;
                z-index: 1;
                left: 70px;
            }

            /* Show the tooltip text when you mouse over the tooltip container */
            .switch:hover .tooltiptext {
                color: white;
                visibility: visible;
            }
        </style>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Quản lý cửa hàng</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="./Resources/plugins/fontawesome-free/css/all.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet"
              href="./Resources/css/ionicons.min.css">
        <!-- Tempusdominus Bbootstrap 4 -->
        <link rel="stylesheet"
              href="./Resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
        <!-- iCheck -->
        <link rel="stylesheet"
              href="./Resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
        <!-- JQVMap -->
        <link rel="stylesheet" href="./Resources/plugins/jqvmap/jqvmap.min.css">

        <!-- overlayScrollbars -->
        <link rel="stylesheet"
              href="./Resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        <!-- Daterange picker -->
        <link rel="stylesheet"
              href="./Resources/plugins/daterangepicker/daterangepicker.css">
        <!-- summernote -->
        <link rel="stylesheet"
              href="./Resources/plugins/summernote/summernote-bs4.css">
        <!-- Google Font: Source Sans Pro -->
        <!-- daterange picker -->
        <link rel="stylesheet"
              href="Resources/plugins/daterangepicker/daterangepicker.css">
        <!-- Bootstrap Color Picker -->
        <link rel="stylesheet"
              href="Resources/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
        <!-- Select2 -->
        <link rel="stylesheet"
              href="Resources/plugins/select2/css/select2.min.css">
        <link rel="stylesheet"
              href="Resources/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
        <!-- Bootstrap4 Duallistbox -->
        <link rel="stylesheet"
              href="Resources/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="Resources/css/adminlte.min.css">
        <!-- Google Font: Source Sans Pro -->

        <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
            rel="stylesheet">
    </head>
    <body class="hold-transition sidebar-mini layout-fixed">
        <div class="wrapper">

            <!-- Navbar -->
            <nav
                class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" data-widget="pushmenu"
                                            href="#" role="button"><i class="fas fa-bars"></i></a></li>
                    <li class="nav-item d-none d-sm-inline-block"><a href="${pageContext.request.contextPath}/UserManual"
                                                                     class="nav-link">Hướng dẫn sử dụng</a></li>
                </ul>

            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <a href="${pageContext.request.contextPath}/UserManual" class="brand-link"> <img
                        src="Resources/img/AdminLTELogo.png" alt="AdminLTE Logo"
                        class="brand-image img-circle elevation-3" style="opacity: .8">
                    <span class="brand-text font-weight-light">Quản lý cửa hàng</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <%
                            if (request.getSession().getAttribute("User") != null) {
                        %>
                        <%
                            User user = (User) request.getSession().getAttribute("User");
                        %>
                        <div class="image">
                            <img src="Resources/img/avatar1.jpg" class="img-circle elevation-2"
                                 alt="User Image">
                        </div>
                        <div class="info">

                            <a href="#" class="d-block"><%=user.getEmail().split("@")[0]%></a>
                        </div>
                        <%
                        } else {
                        %>

                        <div class="info" style="margin-left: 60px;">
                            <a href="${pageContext.request.contextPath}/Login" class="d-block">Đăng
                                nhập</a>
                        </div>
                        <%
                            }
                        %>
                    </div>

                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column"
                            data-widget="treeview" role="menu" data-accordion="false">

                            <!--						<li class="nav-item "><a
                                                                                    href="${pageContext.request.contextPath}/UserManual"
                                                                                    class="nav-link <c:if test="${sessionScope.Check.toString().equals('Manual')}">active</c:if> ">
                                                                                            <i class="nav-icon fas fa-book"></i>
                                                                                            <p>Hướng dẫn</p>
                                                                            </a></li>-->

                                <li
                                    class="nav-item has-treeview <c:if test="${sessionScope.Check.toString().equals('ManageBook') || sessionScope.Check.toString().equals('AddBook')||sessionScope.Check.toString().equals('ManageCategory')}">menu-open</c:if>"><a
                                        href="#"
                                        class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageBook') || sessionScope.Check.toString().equals('AddBook')||sessionScope.Check.toString().equals('ManageCategory')}">active</c:if> ">
                                        <i class="nav-icon fas fa-book"></i>
                                        <p>
                                            Quản lý loại mặt hàng<i class="right fas fa-angle-left"></i>
                                        </p>
                                    </a>
                                    <ul class="nav nav-treeview">
                                        <li class="nav-item"><a
                                                href="${pageContext.request.contextPath}/ListProduct"
                                            class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageBook')}">active</c:if> ">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>Danh sách loại mặt hàng</p>
                                            </a></li>
                                        <li class="nav-item"><a
                                                href="${pageContext.request.contextPath}/AddProduct"
                                            class="nav-link <c:if test="${sessionScope.Check.toString().equals('AddBook')}">active</c:if>">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>Thêm loại mặt hàng</p>
                                            </a></li>
                                        <li class="nav-item"><a
                                                href="${pageContext.request.contextPath}/ManageCategory"
                                            class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageCategory')}">active</c:if>">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>Danh mục sản phẩm</p>
                                            </a></li>
                                    </ul></li>
                            <li class="nav-item has-treeview <c:if test="${sessionScope.Check.toString().equals('Viewreport')}">menu-open</c:if>">
                                <a href="${pageContext.request.contextPath}/ViewReport" class="nav-link">
                                    <i class="nav-icon fas fa-book"></i>
                                    <p>Báo cáo thống kê</p>
                                </a>
                            </li>
                            <li class="nav-item has-treeview <c:if test="${sessionScope.Check.toString().equals('Employee')}">menu-open</c:if>">
                                <a href="${pageContext.request.contextPath}/employees" class="nav-link">
                                    <i class="nav-icon fas fa-book"></i>
                                    <p>Quản lý nhân viên</p>
                                </a>
                            </li>

                            <!--                                            
                                                                                    
                                                                            <li
                                                                                    class="nav-item has-treeview  <c:if test="${sessionScope.Check.toString().equals('ManageReader_0') || sessionScope.Check.toString().equals('AddReader') || sessionScope.Check.toString().equals('ManageReader_1')}">menu-open</c:if>"><a
                                                                                    href="#"
                                                                                    class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageReader_0')|| sessionScope.Check.toString().equals('ManageReader_1') || sessionScope.Check.toString().equals('AddReader')}">active</c:if>">
                                                                                            <i class="nav-icon fas fa-book"></i>
                                                                                            <p>
                                                                                                    Quản lý mượn sách<i class="right fas fa-angle-left"></i>
                                                                                            </p>
                                                                            </a>
                                                                                    <ul class="nav nav-treeview">
                                                                                            <li class="nav-item"><a
                                                                                                    href="${pageContext.request.contextPath}/AddReader"
                                                                                                    class="nav-link <c:if test="${sessionScope.Check.toString().equals('AddReader')}">active</c:if>">
                                                                                                            <i class="far fa-circle nav-icon"></i>
                                                                                                            <p>Thêm người mượn sách</p>
                                                                                            </a></li>
                                                                                            <li class="nav-item"><a
                                                                                                    href="${pageContext.request.contextPath}/ManageReader"
                                                                                                    class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageReader_0')}">active</c:if>">
                                                                                                            <i class="far fa-circle nav-icon"></i>
                                                                                                            <p>Danh sách đang mượn sách</p>
                                                                                            </a></li>
                            
                                                                                            <li class="nav-item"><a
                                                                                                    href="${pageContext.request.contextPath}/ManageReader?status=1"
                                                                                                    class="nav-link <c:if test="${sessionScope.Check.toString().equals('ManageReader_1')}">active</c:if>">
                                                                                                            <i class="far fa-circle nav-icon"></i>
                                                                                                            <p>Lịch sử mượn sách</p>
                                                                                            </a></li>
                                                                                    </ul></li>
                                                                                    
                                -->
                            <%
                                if (request.getSession().getAttribute("User") != null) {
                            %>
                            <li class="nav-item"><a
                                    href="${pageContext.request.contextPath}/Logout" class="nav-link">
                                    <i class="fas fa-circle nav-icon"></i>
                                    <p>Đăng xuất</p>
                                </a></li>
                                <%
                                    }
                                %>

                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>