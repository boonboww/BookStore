<%@page import="java.sql.Date"%>
<%@page
	import="org.apache.catalina.startup.ClassLoaderFactory.Repository"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	color:red;}
	</style>
</head>
<body>
	<%
	String urlFix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
	
	 String msg_error_changeInfoUser = ((request.getAttribute("msg_error_changeInfoUser")+"").equals("null"))?"":(request.getAttribute("msg_error_changeInfoUser")+"");
	String tenTaiKhoan = "";
	String tenKhachHang  = "";
	String gioiTinh  = "";
	Date ngaySinh  = null;
	String soDienThoai  = "";
	String email  = "";
	String diaChi  = "";
	String diaChiNhanHang = "";
	String diaChiMuaHang = "";

	Object obj = session.getAttribute("taiKhoan");
	Customer cs = null;
	if (obj != null) {
		cs = (Customer) obj;
		if(cs != null) {
		tenTaiKhoan = cs.getTaiKhoan();
		tenKhachHang = cs.getTenKhachHang();
		gioiTinh = cs.getGioiTinh();
		ngaySinh = cs.getNgaySinh();
		soDienThoai = cs.getSoDienThoai();
		email = cs.getEmail();
		diaChi = cs.getDiaChi();
		diaChiNhanHang = cs.getDiaChiNhanHang();
		diaChiMuaHang = cs.getDiaChiMuaHang();
		}
	}
	if (cs == null) {
		response.sendRedirect("signin.jsp");
	} else {
	%>


	<!-- Header -->
	<jsp:include page="../header/header-customer.jsp"></jsp:include> 
	<!-- End Header -->


	<!-- Content -->
	<!-- Form Change Info-User -->
	<div class="container mt-2">

		<!-- Col 1 -->
		<div class="text-success">
			<h1>Thông tin khách hàng</h1>
		</div>
		<div>
			<form class="row g-3" action="<%=urlFix %>/customer-controller?event=ChangeInfoUser" method="post">
				<div class="col-md-6">

					<label for="inputAccount" class="form-label">Tên tài khoản<span
						class="red">*</span>
					</label> <input type="text" class="form-control" id="inputAccount"
						required="required" name="inputAccount"
						value="<%=tenTaiKhoan%>">


				</div>
				<div class="col-md-6">
					<label for="inputName" class="form-label">Tên khách hàng<span
						class="red">*</span></label> <input type="text" class="form-control"
						id="inputName" placeholder="FullName" name="inputName"
						required="required" value="<%=  tenKhachHang %> ">
				</div>


				<div class="col-md-4">
					<label for="inputGioiTinh" class="form-label">Giới Tính</label> <select
						id="inputGioiTinh" name="inputGioiTinh" class="form-select"
						value=" <%= gioiTinh %> ">
						<option></option>
						<option value="Nam" <%= ( gioiTinh.equals("Nam")?"selected='selected'":""  ) %>  >Nam</option>
						<option value="Nữ" <%= ( gioiTinh.equals("Nữ")?"selected='selected'":""  ) %> >Nữ</option>
						<option value="LGBT" <%=   (gioiTinh.equals("LGBT")?"selected='selected'":"" ) %> >LGBT</option>
					</select>
				</div>
				<div class="col-md-4">
					<label for="inputNgaySinh" class="form-label">Ngày Sinh</label> <input
						type="date" class="form-control" id="inputNgaySinh"
						name="inputNgaySinh" value="<%= ngaySinh %>">
				</div>

				<div class="col-md-4">
					<label for="inputSDT" class="form-label">Số điện thoại<span id="msgErrorSDT"
						class="red">*</span></label> <input type="text" class="form-control"
						id="inputSDT" required="required" name="inputSDT"
						value="<%= soDienThoai%> " onkeyup="checkPhoneNumber()">
				</div>
				<div class="col-12">
					<label for="inputEmail" class="form-label">Email<span 
						class="red">*</span></label> <input type="email" class="form-control"
						id="inputEmail" required="required" name="inputEmail"
						value="<%= email %> ">
				</div>

				<!-- input địa chỉ -->
				<div class="col-12">
					<label for="inputDiaChi" class="form-label">Địa chỉ<span
						class="red">*</span></label> <input type="text" class="form-control"
						id="inputDiaChi" name="inputDiaChi"
						placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
						required="required" value=" <%=  diaChi  %> ">
				</div>

				<!-- input địa chỉ nhận hàng -->
				<div class="col-12">
					<label for="inputDiaChiNhanHang" class="form-label">Địa Chỉ
						Nhận Hàng<span class="red">*</span>
					</label> <input type="text" class="form-control" id="inputDiaChiNhanHang"
						placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
						name="inputDiaChiNhanHang" required="required"
						value=" <%= diaChiNhanHang %> ">
				</div>

				<!-- input địa chỉ mua hàng -->
				<div class="col-12">
					<label for="inputDiaChiMuaHang" class="form-label">Địa Chỉ
						Mua Hàng<span class="red">*</span>
					</label> <input type="text" class="form-control" id="inputDiaChiMuaHang"
						placeholder="98 Dũng Sỹ Thanh Khê , 70 Lê Đình Lý"
						name="inputDiaChiMuaHang" required="required"
						value="<%= diaChiMuaHang %> ">
				</div>

				<!-- button xác nhận -->
				<div class="col-4 d-flex mb-3">
					<button type="submit" class="btn btn-success" name="submit"
						id="submit">Xác Nhận</button> 
					<div class="m-auto"> <h4 class="text-danger"><%= msg_error_changeInfoUser %></h4> </div>
				</div>



			</form>
		</div>
	</div>
	<!-- End Content -->
	
	<!-- footer -->
		<%@include file="../footer/footer-customer.jsp" %>

	<%
	}
	%>






</body>
<script type="text/javascript">
	function checkPhoneNumber() {
		var phoneNumber = document.getElementById("inputSDT").value;
		if(phoneNumber <48 || phoneNumber >57) {
			document.getElementById("msgErrorSDT").innerHTML = "";
			return true;
			}
		else {
			document.getElementById("msgErrorSDT").innerHTML = "*Không nhập kí tự";
			return false;
			}
		
	}


</script>


</html>