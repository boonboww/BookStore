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
#border-icon {
	
	padding: 0px 5px 0px 5px;
}
</style>
</head>
<body>
	<%
	 String urlFix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	String msg_VerifyOTP = (request.getAttribute("msg_VerifyOTP")+"").equals("null")?"Gửi lại":(request.getAttribute("msg_VerifyOTP")+"");
	String msg_e_otp = (request.getAttribute("msg_e_otp")+"").equals("null")?"":(request.getAttribute("msg_e_otp")+"");
	Object obj = session.getAttribute("taiKhoan");
	Customer cs = null;
	if(obj!=null) {
		cs = (Customer)obj;
		
	}
	if(cs == null) {
		response.sendRedirect("signin.jsp");
	}
	
	
	else {
		
	
	%>
		
		<!-- Header -->
		<jsp:include page="../header/header-customer.jsp"></jsp:include>
		<!-- End header -->
		
		<main class="container">  <div class="container my-5">
    <div class="bg-body-tertiary p-5 rounded">
      <div class="col-sm-8 py-5 mx-auto">
        <h1 class="display-5 fw-normal">Hãy xác nhận tài khoản</h1>
        <p class="fs-5">Xác nhận tài khoản để tăng cường bảo mật</p>
        
		<div>
			<form action="<%= urlFix %>/customer-controller?event=SendVerifyOTP" method="post">
			<div class="d-flex flex-column flex-sm-row w-100 gap-2 mb-3 "> 
		<p>Kiểm tra email của bạn, nếu không tìm thấy hoặc mã hết hạn click vào nút</p> 
		<button style="height: 10%" class="btn btn-success" type="submit" value="Submit" id="button-2"><%= msg_VerifyOTP %></button> 
		</div>
			</form>
		
		<form action="<%= urlFix %>/customer-controller?event=CheckVerifyInfomation" method="post">
			<div class="d-flex flex-column flex-sm-row w-100 gap-2">
			<input class="form-control" id="input-OTP" placeholder="Nhập mã xác nhận" type="text" name="iOTP"/>
			<button class="btn btn-success" type="submit" value="Submit" id="button-1">Send</button>
			</div>
			<div class="text-danger"> <p><%= msg_e_otp %></p> </div>
		</form>
		</div>
    </div>
    </div>
  </div>        </main>
		
		
			<!-- footer -->
		<%@include file="../footer/footer.jsp" %>
		
		
		<% } %>
</body>
</html>