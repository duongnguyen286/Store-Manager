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
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Đăng nhập</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form"
							action="${pageContext.request.contextPath}/Login" method="post">
							<div class="row justify-content-center card-body"
								style="margin-bottom: -34px;">
								<div style="color: red;">${errorString}</div>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Email đăng nhập</label> <input
										type="email" class="form-control" name="username"
										placeholder="Nhập email đăng nhập" required="required"
                                                                                pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"
                                                                                >
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Mật khẩu</label> <input
										type="password" class="form-control" name="password"
										id="exampleInputPassword1" placeholder="Nhập mật khẩu"
										required="required">
								</div>
								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1" name="rememberMe" value="Y"> <label
										class="form-check-label" for="exampleCheck1">Nhớ tài
										khoản</label>
								</div>
								<div style="margin-bottom: -14px; margin-top: 25px;">
									<h6>
										<b>Chú ý:</b> Email đăng nhập: <b>duongnguyen286@gmail.com</b>, mật khẩu: <b>duongnguyen286</b>
									</h6>
								</div>
							</div>
							<!-- /.card-body -->

							<div class="card-footer">
								<button id="login_button" type="submit" class="btn btn-primary">Login</button>
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