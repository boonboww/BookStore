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
	
		
		<!-- Header -->
		<jsp:include page="header/header-index.jsp"></jsp:include>
		<!-- End header -->
		
		<!-- content -->
		<div class="container">
			<div class="row mt-3">
				<!-- content slider -->
				<div class="col-8">
					<div id="carouselExampleAutoplaying" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<a href="customer_view/signin.jsp"> <img
									src="https://cdn0.fahasa.com/media/magentothem/banner7/NCCDinhTi_T323_BannerSlide_840x320.jpg"
									class="d-block rounded w-100" alt="...">
								</a>

							</div>
							<div class="carousel-item">
								<a href="customer_view/signin.jsp"> <img
									src="https://cdn0.fahasa.com/media/magentothem/banner7/Stem_mainbanner_T3_Slide_840x320.jpg"
									class="d-block rounded w-100" alt="...">

								</a>
							</div>
							<div class="carousel-item">
								<a href="customer_view/signin.jsp"> <img
									src="https://cdn0.fahasa.com/media/magentothem/banner7/Banner_0803_SlideBanner_840x320.jpg"
									class="d-block rounded w-100" alt="..."></a>

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

				<!-- End content Slider -->

				<!-- img content hr-->
				<div class="col-4">
					<div>
						<a href="signin.jsp"> <img class="rounded" id="image-session-hr-1" alt=""
							src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/392x156_shopee_t3.jpg" />
						</a>
					</div>
					<div class="mt-3">
						<a href="signin.jsp"> <img class="rounded" id="image-session-hr-2" alt=""
							src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/392x156_zalopay_t3.jpg" />
						</a>
					</div>

				</div>
				
				<div
				class="mt-3 d-flex flex-row align-items-center justify-content-center p-2 bg-light border-2">

				 <a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
					
				
				<a class="d-flex flex-column align-items-center gap-2 ">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
				<a class="d-flex flex-column align-items-center gap-2 ">
				 <img class="!d-block" id="image-1" width="60%" alt="" src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Icon_HoiSach_120x120.png" />
					<p> ádss</p>
				</a>
			</div>
				
				
				<!-- end img session hr -->

			</div>

		</div>
		
		
		<!-- footer -->
		<%@include file="footer/footer.jsp" %>
</body>
</html>