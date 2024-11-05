<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%
 String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
 %>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg bg-body-tertiary"
			data-bs-theme="dark">


			<div class="container-fluid">

				<div class="block-logoBookStore">
					<a class="navbar-brand text-black p-1 fs-2" href="<%=url %>/home.jsp"> <img
						class="rounded" id="image-logoBookStore" alt=""
						src="<%=url%>/img/BookStore.png" />
					</a>
				</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="<%=url%>/home.jsp">Trang Chủ</a></li>
						<li class="nav-item"><a class="nav-link text-danger "
							href="home.jsp">Sale 4.4 <img id="image-sale" alt=""
								src="<%=url%>/img/sale-tag.png" /></a></li>
						<li class="nav-item"><a class="nav-link text-danger" href="#">Combo
								4.4</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Phân Loại </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Truyện Tranh</a></li>
								<li><a class="dropdown-item" href="#">Kinh dị</a></li>
								<li><a class="dropdown-item" href="#">Tình Yêu</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<form class="d-flex" role="search">
				<div class="input-group ">
					<input type="text" class="form-control" placeholder="Search"
						aria-label="Recipient's username" aria-describedby="button-addon2">
					<button class="btn btn-outline-success" type="button"
						id="button-addon2">
						<img id="image-logo-search" alt="" src="<%=url%>/img/search.png" />
					</button>
				</div>
				
				<a class="btn btn-success p-2"
					style="white-space: nowrap; margin: 0px 5px 0px 10px" href="#">
					<img id="img_giohang" alt="" src="<%=url%>/img/shopping-cart.png" />
				</a>
				
				<div class="btn-group dropstart ">
					<a type="button" class="btn btn-outline-success dropdown-toggle p-2"
						data-bs-toggle="dropdown" aria-expanded="false" 
						style="white-space: nowrap; margin: 0px 5px 0px 5px" href="#">
						<img id="img_user" alt="" src="<%=url%>/img/user.png" />
					</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="<%=url%>/customer_view/info-user.jsp">Tài khoản</a></li>
						<li><a class="dropdown-item" href="<%=url%>/customer_view/order.jsp">Đơn hàng</a></li>
						<li><a class="dropdown-item" href="<%=url%>/customer_view/introduce.jsp">Giới
								thiệu</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="<%=url %>/customer-controller?event=Logout">Đăng Xuất</a></li>
					</ul>

				</div>
				
			</form>


		</nav>
		<!-- End navbar -->
			
</body>
</html>