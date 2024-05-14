<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">

        <div class="container-fluid">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <form role="form" method="post"
                              action="${pageContext.request.contextPath}/search-employees">
                            <div class="card-header">
                                <h3 class="card-title">Quản lý nhân viên</h3>

                                <div class="card-tools" style="margin-right: 1px;">
                                    <div class="input-group input-group-sm" style="width: 350px;">
                                        <input type="text" name="searchText" id="searchText"
                                               class="form-control float-right"
                                               placeholder="Tìm kiếm theo tên hoặc mã nhân viên">

                                        <div class="input-group-append">
                                            <button id="searchButton" type="submit" class="btn btn-primary">
                                                <i class="fas fa-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </form>
                        <div class="row justify-content-center">
                            <div style="margin-top: 20px; color: red;">${errorString}</div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <div class="card-header" style="margin-left: -20px; margin-top: -40px;">
                                <input id="addButton" type="button" value="Tạo mới"
                                       class="btn btn-primary"
                                       onclick="location.href = '${pageContext.request.contextPath}/add-employee'">
                            </div>
                            <table class="table table-bordered table-hover" id="example2">
                                <thead>
                                    <tr>
                                        <th style="width: 10px; text-align: center">STT</th>
                                        <th style="width: 120px">Mã nhân viên</th>
                                        <th style="width: 190px;">Tên nhân viên</th>
                                        <th style="width: 155px;">Vị trí</th>
                                        <th style="width: 160px; text-align: center">Ngày ký hợp đồng</th>
                                        <th style="width: 195px; text-align: center">Ngày kết thúc hợp đồng</th>
                                        <th style="width: 115px; text-align: center">Trạng thái</th>
                                        <th style="width: 155px; text-align: center">Hành động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${employees}" var="employee" varStatus="loop">
                                        <tr>
                                            <td>${loop.index+1}</td>
                                            <td>${employee.getCode()}</td>
                                            <td>${employee.getName()}</td>
                                            <td>
                                                <c:if test="${employee.getPosition() == 0}">
                                                    Nhân viên bán hàng
                                                </c:if>
                                                <c:if test="${employee.getPosition() == 1}">
                                                    Nhân viên chăm sóc khách hàng
                                                </c:if>
                                                <c:if test="${employee.getPosition() == 2}">
                                                    Nhân viên kho
                                                </c:if>
                                            </td>
                                            <td style="text-align: center;" id="start_${employee.getId()}">${employee.getContractStartAt()}</td>
                                            <td style="text-align: center;" id="end_${employee.getId()}">${employee.getContractEndAt()}</td>
                                            <td style="text-align: center;">
                                                <c:if test="${employee.getStatus() == 1}">
                                                    <span class="badge badge-primary"
                                                          style="height: 20px">Đang hoạt động</span>
                                                </c:if>
                                                <c:if test="${employee.getStatus() == 0}">
                                                    <span class="badge badge-danger"
                                                          style="height: 20px">Không hoạt động</span>
                                                </c:if>
                                            </td>
                                            <td style="display: flex !important; justify-content: center; align-items: center; width: 120px">
                                                <a id="update_button"
                                                    href="${pageContext.request.contextPath}/update-employee?id=${employee.getId()}"
                                                    class="btn btn-sm btn-info">Chỉnh sửa
                                                </a>
                                                <button id="delete_button"
                                                    type="button" class="btn btn-primary btn-danger"
                                                    data-toggle="modal"
                                                    data-target="#staticBackdrop-${employee.getId()}"
                                                    style="margin-left:10px; padding-bottom: 5px; padding-top: 3px; font-size: 14px">
                                                    Xóa
                                                </button>
                                            </td>
                                        </tr>

                                    <div class="modal fade"
                                         id="staticBackdrop-${Integer.toString(employee.getId())}"
                                         data-backdrop="static" data-keyboard="false" tabindex="-1"
                                         aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel1">Chú
                                                        ý</h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <span class="text-danger"> Bạn có chắc chắn muốn xóa
                                                        nhân viên '${employee.getName()}' không?</span>
                                                    <div style="display: none" id="employeeId">${employee.getId()}</div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button"
                                                            class="btn btn-warning  btn-secondary"
                                                            data-dismiss="modal">Hủy
                                                    </button>
                                                    <form
                                                            id="delete-form"
                                                        action="${pageContext.request.contextPath}/delete-employee?id=${employee.getId()}"
                                                        method="POST">
                                                        <button id="submit_delete_button" type="submit" class="btn btn-danger">Xóa</button>
                                                    </form>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>
                                </tbody>
                            </table>

                        </div>

                    </div>
                    <!-- /.card -->
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
    </section>
</div>

<%@ include file="footer.jsp" %>
<!-- DataTables -->
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
<!-- page script -->
<script>
                                                            $(function () {
                                                                $("#example1").DataTable({
                                                                    "responsive": true,
                                                                    "autoWidth": false,
                                                                });
                                                                $('#example2').DataTable({
                                                                    "paging": true,
                                                                    "lengthChange": false,
                                                                    "searching": false,
                                                                    "ordering": true,
                                                                    "info": true,
                                                                    "autoWidth": false,
                                                                    "responsive": true,
                                                                });
                                                            });


    <%--const a = "${employee.getContractStartAt()}";--%>
    <%--const b = "${employee.getContractEndAt()}";--%>
    <%--const start = moment.unix(a).format('dd-mm-yyyy');--%>
    <%--const end = moment.unix(b).format('dd-mm-yyyy');--%>
    <%--document.getElementById("start_${employee.getId()}").innerText = start;--%>
    <%--document.getElementById("end_${employee.getId()}").innerText = end;--%>
</script>