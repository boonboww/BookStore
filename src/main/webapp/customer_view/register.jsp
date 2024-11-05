<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng Ký</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style type="text/css">
.red {
	color: red;
}
</style>
</head>

<body>
	<%
	String tenTaiKhoan = request.getAttribute("tenTaiKhoan") + "";
	String tenKhachHang = request.getAttribute("tenKhachHang") + "";
	String gioiTinh = request.getAttribute("gioiTinh") + "";
	String ngaySinh = request.getAttribute("ngaySinh") + "";
	String soDienThoai = request.getAttribute("soDienThoai") + "";
	String eMail = request.getAttribute("eMail") + "";
	String diaChi = request.getAttribute("diaChi") + "";
	String diaChiNhanHang = request.getAttribute("diaChiNhanHang") + "";
	String diaChiMuaHang = request.getAttribute("diaChiMuaHang") + "";

	// check null?
	tenTaiKhoan = (tenTaiKhoan.equals("null")) ? "" : tenTaiKhoan;
	tenKhachHang = (tenKhachHang.equals("null")) ? "" : tenKhachHang;
	
	ngaySinh = (ngaySinh.equals("null")) ? "" : ngaySinh;
	soDienThoai = (soDienThoai.equals("null")) ? "" : soDienThoai;
	eMail = (eMail.equals("null")) ? "" : eMail;
	diaChi = (diaChi.equals("null")) ? "" : diaChi;
	diaChiNhanHang = (diaChiNhanHang.equals("null")) ? "" : diaChiNhanHang;
	diaChiMuaHang =  (diaChiMuaHang.equals("null")) ? "" : diaChiMuaHang;
	
	String msg_error = ((request.getAttribute("msg_error")+"").equals("null") ? "" : (request.getAttribute("msg_error")+""));
	%>
	<!-- Form Register -->
	<div class="container mt-2">
		<div class="row">
			<!-- Col 1 -->
			<div class="text-success">
				<h1>Đăng Ký</h1>
			</div>
			<div class="col-5">
				<form class="row g-3" action="../customer-controller?event=Register" method="post">
					<div class="col-md-4">
						 <div class="red" >
						 <%= msg_error %>
						</div>
						<label for="inputAccount" class="form-label">Tên tài khoản<span
							class="red">*</span>
						</label> <input type="text" class="form-control" id="inputAccount"
							required="required" name="inputAccount" value="<%=tenTaiKhoan%>">
					</div>
					<div class="col-md-4">
						<label for="inputPassword" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="inputPassword" required="required" name="inputPassword">
					</div>
					<div class="col-md-4">
						<label for="inputPasswordCheck" class="form-label">Nhập
							lại mật khẩu<span id="msg" class="red">*</span>
						</label> <input type="password" class="form-control"
							id="inputPasswordCheck" name="inputPasswordCheck"
							required="required" onkeyup="checkPassword()">
					</div>
					<div class="col-12">
						<label for="inputName" class="form-label">Tên khách hàng<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="inputName" placeholder="FullName" name="inputName"
							required="required" value="<%=tenTaiKhoan%>">
					</div>
					<div class="col-md-4">
						<label for="inputGioiTinh" class="form-label">Giới Tính</label> <select
							id="inputGioiTinh" name="inputGioiTinh" class="form-select"
							value="<%=gioiTinh%>">
							<option></option>
							<option value="Nam" <%= (gioiTinh.equals("Nam")?"selected='selected'":"" ) %> >Nam</option>
							<option value="Nữ" <%= (gioiTinh.equals("Nữ")?"selected='selected'":"" ) %>>Nữ</option>
							<option value="LGBT" <%= (gioiTinh.equals("LGBT")?"selected='selected'":"" ) %>>LGBT</option>
						</select>
					</div>
					<div class="col-md-4">
						<label for="inputNgaySinh" class="form-label">Ngày Sinh</label> <input
							type="date" class="form-control" id="inputNgaySinh"
							name="inputNgaySinh" value="<%=ngaySinh%>">
					</div>

					<div class="col-md-4">
						<label for="inputSDT" class="form-label">Số điện thoại<span
							class="red">*</span></label> <input type="number" class="form-control"
							id="inputSDT" required="required" name="inputSDT"
							value="<%=soDienThoai%>">
					</div>
					<div class="col-12">
						<label for="inputEmail" class="form-label">Email<span
							class="red">*</span></label> <input type="email" class="form-control"
							id="inputEmail" required="required" name="inputEmail"
							value="<%=eMail%>">
					</div>

					<div class="col-12">
						<label for="inputDiaChi" class="form-label">Địa chỉ<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="inputDiaChi" name="inputDiaChi"
							placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
							required="required" value="<%= diaChi %>">
					</div>
					<div class="col-12">
						<label for="inputDiaChiNhanHang" class="form-label">Địa
							Chỉ Nhận Hàng<span class="red">*</span>
						</label> <input type="text" class="form-control" id="inputDiaChiNhanHang"
							placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
							name="inputDiaChiNhanHang" required="required" value="<%= diaChiNhanHang %>">
					</div>
					<div class="col-12">
						<label for="inputDiaChiMuaHang" class="form-label">Địa Chỉ
							Mua Hàng<span class="red">*</span>
						</label> <input type="text" class="form-control" id="inputDiaChiMuaHang"
							placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
							name="inputDiaChiMuaHang" required="required" value="<%= diaChiMuaHang %>">
					</div>

					<div>
						<a style="text-decoration: none" href="dieukhoan.jsp">Điều
							kiện đăng ký</a>
					</div>
					<div class="row">
						<div class="mb-3 form-check col-8">
							<input type="checkbox" class="form-check-input bg-success"
								id="checkDieuKhoan" required="required"
								onchange="xuLycheckDieuKhoan()"> <label
								class="form-check-label" for="checkDieuKhoan">Đồng ý với
								điều khoản</label>
						</div>
						<div class="col-4">
							<button type="submit" class="btn btn-primary" name="submit"
								id="submit" style="visibility: hidden;">Đăng Ký</button>
						</div>
					</div>


				</form>
			</div>


			<!-- Col 2 -->
			<div class="col-7">

				<div id="carouselExampleAutoplaying" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item">
							<img
								src="https://image.tienphong.vn/w890/uploads/2017/03/58d4fb4c3ebb6-ne4hf7g-600x450.jpg"
								class="rounded w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img
								src="https://c.wallhere.com/photos/2e/51/1024x768_px_Dragon_Ball_Dragon_Ball_GT-576428.jpg!s1"
								class="rounded w-100" alt="...">
						</div>
						<div class="carousel-item active">
							<img
								src="https://imagev3.vietnamplus.vn/w1000/Uploaded/2024/mzdic/2014_07_29/guardians_poster_via_marvel.jpg.webp"
								class="rounded w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>

		</div>
	</div>

</body>
<script type="text/javascript">
	function checkPassword() {
		var mk1 = document.getElementById("inputPassword").value;
		var mk2 = document.getElementById("inputPasswordCheck").value;
		if (mk1 != mk2) {
			document.getElementById("msg").innerHTML = (" Không trùng mật khẩu");
			return false;
		} else {
			document.getElementById("msg").innerHTML = ("");
			return true;
		}
	}

	function xuLycheckDieuKhoan() {
		dongYDieuKhoan = document.getElementById("checkDieuKhoan");
		if (dongYDieuKhoan.checked == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else {
			document.getElementById("submit").style.visibility = "hidden";

		}
	}
	
</script>
</html>