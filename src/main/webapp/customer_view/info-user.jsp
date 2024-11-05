<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Infomation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>

	<!-- java code -->
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
	String tenTaiKhoan = "";
	String tenKhachHang = "";

	Object obj = session.getAttribute("taiKhoan");
	Customer cs = null;
	if (obj != null) {
		cs = (Customer) obj;
		tenTaiKhoan = cs.getTaiKhoan();
		tenKhachHang = cs.getTenKhachHang();
	}
	if (cs == null) {
		response.sendRedirect(url + "/customer_view/signin.jsp");
	} else {
	%>

	<!-- Header -->
	<jsp:include page="../header/header-customer.jsp"></jsp:include>
	<!-- End Header -->

	<main class="container">
		<div
			class="d-flex align-items-center p-3 my-3 text-white bg-success rounded shadow-sm">
			<img class="me-3 rounded "
				src="../img/user.png"
				alt="" width="50" height="40">
			<div class="lh-1">
				<h1 class="h6 mb-0 text-white lh-1"><%=tenTaiKhoan%></h1>
				<small><%=tenKhachHang%></small>
			</div>
		</div>

		<div class="my-3 p-3 bg-secondary rounded shadow-sm">
			<h6 class="border-bottom pb-2 mb-0">Thông Tin</h6>
			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
				<a class="text-black text-decoration-none" href="changeInfoUser.jsp">
					<p class="pb-3 mb-0 small lh-sm border-bottom">
						<strong class="d-block text-gray-dark">Thông tin cá nhân</strong>
						Some representative placeholder content, with some information
						about this user. Imagine this being some sort of status update,
						perhaps?
					</p>
				</a>
			</div>

			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#e83e8c" />
					<text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>
				<a class="text-black" style="text-decoration: none;"
					href="changePassword.jsp">
					<p class="pb-3 mb-0 small lh-sm border-bottom">
						<strong class="d-block text-gray-dark">Đổi mật khẩu</strong> Some
						more representative placeholder content, related to this other
						user. Another status update, perhaps.
					</p>
				</a>
			</div>
			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#6f42c1" />
					<text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>
					<a class="text-black" style="text-decoration: none;"
					href="order.jsp">
				<p class="pb-3 mb-0 small lh-sm border-bottom">
					<strong class="d-block text-gray-dark">Đơn hàng của bạn</strong> This user
					also gets some representative placeholder content. Maybe they did
					something interesting, and you really want to highlight this in the
					recent updates.
				</p>
				</a>
			</div>
			<small class="d-block text-end mt-3"> <a href="#">All
					updates</a>
			</small>
		</div>

		<div class="my-3 p-3 bg-secondary rounded shadow-sm">
			<h6 class="border-bottom pb-2 mb-0">Cài đặt</h6>
			
			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						 <a class="text-black text-decoration-none" href="#"><strong class="text-gray-dark">Cài đặt chính</strong></a>
					</div>
					<span class="d-block">setting</span>
				</div>
			</div>
			
			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						 <a class="text-black text-decoration-none" href="#"><strong class="text-gray-dark">Xếp hạng</strong></a>
					</div>
					<span class="d-block">ranking</span>
				</div>
			</div>
			<div class="d-flex text-body-black pt-3">
				<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"
					width="32" height="32" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						 <a class="text-black text-decoration-none" href="support.jsp"><strong class="text-gray-dark">Tâm trung hỗ trợ</strong></a>
					</div>
					<span class="d-block">Support</span>
				</div>
			</div>
			<small class="d-block text-end mt-3"> <a href="#">All
					suggestions</a>
			</small>
		</div>
	</main>
	
	<!-- footer -->
		<%@include file="../footer/footer-customer.jsp" %>
	
	
	<!-- đóng if java -->
	<%
	}
	%>
</body>
</html>