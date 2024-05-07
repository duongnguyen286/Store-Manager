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
		<div class="row justify-content-center">
			<div style="color: red;">${errorString}</div>
		</div>
		<div class="container-fluid">

			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<!-- general form elements -->
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Chỉnh sửa tên danh mục sản phẩm</h3>
						</div>
                                            
                                            <script>
                            function validateForm() {
                                var name_category = document.getElementById("name_category").value;
                                if (!name_category || name_category.trim() === "") {
                                    alert("Tên danh mục sản phẩm không được để trống");
                                    return false;
                                }
                                return true;
                            }
                        </script>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" method="post"
							action="${pageContext.request.contextPath}/EditCategory" onsubmit="return validateForm()">
							<div class="card-body">
								<input type="hidden" name="id" value="${category.id}" />
								<div class="form-group">
									<label>Tên danh mục sản phẩm<span style="color: red">&nbsp;*</span></label> <input type="text"
										class="form-control" id="name_category" name="name_category"
										value="${category.name}">
								</div>
							</div>
							<div class="card-footer">
								<button type="submit" class="btn btn-primary ">Lưu</button>
								<input type="button" value="Hủy" class="btn btn-primary"
									onclick="location.href='${pageContext.request.contextPath}/ManageCategory'">
							</div>
						</form>
					</div>
					<!-- /.card -->

				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
	<%@ include file="footer.jsp"%>