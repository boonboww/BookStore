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
	String msg_e_email = ((request.getAttribute("msg_error_email_inSupport")+"").equals("null"))?"":(request.getAttribute("msg_error_email_inSupport")+""); 

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
		response.sendRedirect("signin.jsp");
	} else {
	%>

	<!-- Header -->
	<jsp:include page="../header/header-customer.jsp"></jsp:include>
	<!-- End Header -->

	<main class="container">  <div class="container my-5">
    <div class="bg-body-tertiary p-5 rounded">
      <div class="col-sm-8 py-5 mx-auto">
        <h1 class="display-5 fw-normal">Trung tâm Hỗ trợ</h1>
        <p class="fs-5">Hỗ trợ 24/7 - Giải quyết nhanh chóng mọi vấn đề liên hệ ngay để được hỗ trợ miễn phí!.</p>
        <p>Bạn đang gặp khó khăn trong việc sử dụng sản phẩm/dịch vụ của chúng tôi? Đừng lo lắng! Trung tâm Hỗ trợ <a class="text-black text- text-decoration-none" href="./home.jsp">BookStore </a> luôn sẵn sàng hỗ trợ bạn 24/7.</p>
		<div>
		<form action="<%=url %>/customer-controller?event=SendMailCustomerInSupport" method="post">
			<div class="d-flex flex-column flex-sm-row w-100 gap-2">
			<input class="form-control" id="input-CusMail" placeholder="Nhập email của bạn để được hỗ trợ" type="text" name="mailCustomerInSupport"/>
			<button class="btn btn-success" type="submit" value="Submit" id="button-1">Send</button>
			</div>
			<div class="text-danger"> <p><%= msg_e_email %></p> </div>
		</form>
		</div>
    </div>
    </div>
  </div>        </main>
	<!-- footer -->
		<%@include file="../footer/footer-customer.jsp" %>
	
	
	<!-- đóng if java -->
	<%
	}
	%>
</body>
</html>