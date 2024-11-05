<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng Nhập</title>
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
.bg-logo {
	

	border-radius: 10px;
	}
.bg-logo h1 {
	color: black;
}
.block-logo {
	margin: 5px 0;
	display: flex;
	justify-content: center;
}

}
</style>
</head>

<body>
	<%
		//fix ỦRL
	 String urlfix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	
	
	String msg_error = ((request.getAttribute("msg_error")+"").equals("null") ? "" : (request.getAttribute("msg_error")+""));
	String tenTaiKhoan = ((request.getAttribute("tenTaiKhoan")+"").equals("null") ? "" :(request.getAttribute("tenTaiKhoan") +""));

	
	%>
	<div class="block-logo">
	<div class="bg-logo p-1 fs-2" > <img class="rounded" id="image-logoBookStore-signin" alt="" src= "<%=urlfix %>/img/BookStore.png"/></h1> </div>
	</div>
	<!-- Form Register -->
	<div class="container">
		<div class="row">
			<!-- Col 1 -->
			<div class="text-success mt-2">
				<h1>Đăng Nhập</h1>
			</div>
			<div class="col-5">
				<form class="row g-3" action="<%=urlfix %>/customer-controller" method="POST">
				<input type="hidden" name="event" value="Signin"/> 
					<div class="col-md-12">
						 
						<label for="inputAccount" class="form-label">Tên tài khoản<span
							class="red">*</span>
						</label> <input type="text" class="form-control" id="inputAccount"
							required="required" name="inputAccount" placeholder="name@gmail.com" value="<%= tenTaiKhoan %>">
					</div>
					<div class="col-md-12" >
						<label for="inputPassword" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="inputPassword" required="required" name="inputPassword" >
					</div>
					<div class="red" style="text-align: right;" >
						 <%= msg_error %>
						</div>
					<div>
					<input id="inputCBSaveAccount" placeholder="Text" type="checkbox"/>
						<label for="inputCBSaveAccount">Ghi nhớ tài khoản</label>
						
					</div>
						<div class="col-4">
							<button type="submit" class="btn btn-primary" name="submit"
								id="submit" >Đăng Nhập</button>
						</div>
				</form>
				<div class="mt-3">
						<a class="text-success" style="text-decoration: none;" href="quenMatKhau.jsp"> Quên mật khẩu </a>
						|
						<a class="text-success" style="text-decoration: none;" href="register.jsp"> Đăng Ký </a>
						 <p class="mt-3 mb-3 text-muted">&copy; 2017–2021</p>
									
				</div>
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
								src="https://fc05.deviantart.com/fs20/i/2007/248/c/e/Dragon_Ball_Gt_World_by_scream2007.jpg"
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
		<!-- footer -->
		<%@include file="../footer/footer-customer.jsp" %>


</body>

</html>