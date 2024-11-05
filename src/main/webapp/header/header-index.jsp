<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Navbar -->
		<nav class="navbar navbar-expand-lg bg-body-tertiary"
			data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand text-black p-1 fs-2" href="#">
					<img class="rounded" id="image-logoBookStore" alt="" src="./img/BookStore.png"/>
				
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.jsp">Trang Chủ</a></li>
						<li class="nav-item"><a class="nav-link text-danger "
							href="#">Sale 4.4</a></li>
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
				<input class="form-control me-2" type="search"
					placeholder="Nội dung tìm kiếm" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Tìm</button>
				<div class="btn-group dropstart ">

					<a id="border-icon" class="nav-link btn btn-outline-success p-2 border-5"
						data-bs-toggle="dropdown" aria-expanded="false" role="button"
						style="white-space: nowrap; margin: 0px 5px 0px 5px" href="#">
						<img id="image-login" alt="" src="./img/login.png" />
					</a>

					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="customer_view/signin.jsp">Đăng Nhập
						</a></li>
						<li><a class="dropdown-item" href="customer_view/register.jsp">Đăng Ký
						</a></li>
					</ul>
				</div>
			</form>

		</nav>
</body>
</html>