<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark"></h1>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <section class="content">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Cập nhật nhân viên <b>${employee.getName()} - ${employee.getCode()}</b></h3>
                        </div>
                        <div class="row justify-content-center"
                             style="margin-top: 15px; margin-bottom: -15px;">
                            <div style="color: red;">${errorString}</div>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form role="form" method="post" id="updateForm"
                              action="${pageContext.request.contextPath}/update-employee"
                              enctype="multipart/form-data">

                            <div class="card-body">
                                <input type="hidden" name="id" value="${employee.getId()}" />
                                <input type="hidden" name="old_position" value="${employee.getPosition()}" />
                                <input type="hidden" name="code" value="${employee.getCode()}" />
                                <div class="form-group">
                                    <label>Họ và tên <span style="color: red">&nbsp;*</span></label> 
                                    <input type="text" class="form-control" id="name" name="name" onclick="handleRemoveValidateName()"
                                           placeholder="Nhập tên nhân viên" value="${employee.getName()}">
                                    <div style="color: red" id="validateName"></div>
                                </div>
                                <div class="form-group">
                                    <label>Vị trí <span style="color: red">&nbsp;*</span></label> <select name="position" id="position"
                                                                                                          class="form-control" required>
                                        <option ${employee.getPosition() == Integer.toString(positions.get("SALES")) ? "selected" : ""} value="${Integer.toString(positions.get("SALES"))}">Nhân viên bán hàng</option>
                                        <option ${employee.getPosition() == Integer.toString(positions.get("CUSTOMER_CARE")) ? "selected" : ""} value="${Integer.toString(positions.get("CUSTOMER_CARE"))}">Chăm sóc khách hàng</option>
                                        <option ${employee.getPosition() == Integer.toString(positions.get("WAREHOUSE")) ? "selected" : ""} value="${Integer.toString(positions.get("WAREHOUSE"))}">Nhân viên kho</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Ngày ký hợp đồng <span style="color: red">&nbsp;*</span></label> 
                                    <input type="date" value="${employee.getContractStartAt()}" onchange="handleChangeContractStart()" class="form-control" id="contract_start_at" name="contract_start_at">
                                    <div style="color: red" id="validateStart"></div>
                                </div>
                                <div class="form-group">
                                    <label>Ngày kết thúc hợp đồng <span style="color: red">&nbsp;*</span></label> 
                                    <input type="date" value="${employee.getContractEndAt()}" onchange="handleChangeContractEnd()" class="form-control" id="contract_end_at" name="contract_end_at">
                                    <div style="color: red" id="validateEnd"></div>
                                </div>
                                <div class="form-group">
                                    <label>Trạng thái <span style="color: red">&nbsp;*</span></label> 
                                    <div>
                                        <label class="switch">
                                            <input class="status-input" type="checkbox" ${employee.getStatus() == 1 ? "checked" : ""} id="status" name="status" onchange="handleChangeTooltip()">
                                            <span class="slider round"></span>
                                            <span class="tooltiptext">${employee.getStatus() == 1 ? "Đang hoạt động" : "Không hoạt động"}</span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button type="button" id="submit_update_button" onclick="handleSubmitForm()" class="btn btn-primary ">Lưu</button>
                                <input type="button" id="update_back_button" value="Trở lại" class="btn btn-secondary"
                                       onclick="location.href = '${pageContext.request.contextPath}/employees'">
                            </div>
                        </form>
                    </div>


                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <%@ include file="footer.jsp"%>
    <!-- jQuery -->
    <script src="./Resources/plugins/jquery/jquery.min.js"></script>

    <script
    src="./Resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
    <!-- AdminLTE App -->
    <script src="./Resources/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="./Resources/js/demo.js"></script>
    <script type="text/javascript">
                                           $(document).ready(function () {
                                               bsCustomFileInput.init();
                                           });

                                           function handleChangeTooltip() {
                                               const tooltipText = document.getElementById("status")?.checked ? "Đang hoạt động" : "Không hoạt động"
                                               const slider = document.querySelector(".tooltiptext");
                                               slider.innerHTML = tooltipText;
                                           }

                                           function handleSubmitForm() {
                                               const name = document.getElementById("name").value
                                               const validateName = document.getElementById("validateName")
                                               const start = document.getElementById("contract_start_at").value
                                               const validateStart = document.getElementById("validateStart")
                                               const end = document.getElementById("contract_end_at").value
                                               const validateEnd = document.getElementById("validateEnd")
                                               let error = false;

                                               if (name === '') {
                                                   validateName.textContent = 'Họ tên không được bỏ trống!'
                                                   error = true;
                                               }
                                               if (start === '') {
                                                   validateStart.textContent = 'Ngày ký hợp đồng không được bỏ trống!'
                                                   error = true;
                                               }
                                               if (end === '') {
                                                   validateEnd.textContent = 'Ngày kết thúc hợp đồng không được bỏ trống!'
                                                   error = true;
                                               }
                                               if (end < start) {
                                                   validateEnd.textContent = 'Ngày kết thúc hợp đồng không được nhỏ hơn ngày ký hợp đồng!'
                                                   error = true;
                                               }

                                               if (!error) {
                                                   document.getElementById("updateForm").submit();
                                               }
                                           }

                                           function handleRemoveValidateName() {
                                               document.getElementById("validateName").textContent = ''
                                           }

                                           function handleChangeContractStart() {
                                               document.getElementById("validateStart").textContent = ''
                                           }

                                           function handleChangeContractEnd() {
                                               document.getElementById("validateEnd").textContent = ''
                                           }

    </script>
    <!-- /.card -->