 <%@page import="database.CustomerDAO"%>
<%@page import="java.text.Normalizer.Form"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
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
	html{ 
		margin: 0;
		padding:0;
		box-sizing: border-box;
		}
		
		p{
			margin: 0;
		padding:0;
		}
	}
	
</style>
</head>
<body>
		<%
			Object obj = session.getAttribute("taiKhoan");
			Customer cs = null;
			if(obj!=null) {
				cs = (Customer)obj;
				
			}
			if(cs == null) {
				response.sendRedirect("customer_view/signin.jsp");
			}
			else if(cs.isTrangThaiXacThuc() == false) {
				response.sendRedirect("customer_view/VerifyInformation.jsp");
			}
			
			else if(cs.isTrangThaiXacThuc() == true) {
				
			
		%>
		


	<!-- Header Area -->
		 <jsp:include page="header/header.jsp"></jsp:include> 
		
	<!-- end Header -->

			

		<!-- content -->
		<div class="container">
			<div class="row mt-3">
				<!-- content slider -->
				<div class="col-8">
					<div id="carouselExampleAutoplaying" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<a href="#"> <img
									src="https://cdn0.fahasa.com/media/magentothem/banner7/NCCDinhTi_T323_BannerSlide_840x320.jpg"
									class="d-block rounded w-100" alt="...">
								</a>

							</div>
							<div class="carousel-item">
								<a> <img
									src="https://cdn0.fahasa.com/media/magentothem/banner7/Stem_mainbanner_T3_Slide_840x320.jpg"
									class="d-block rounded w-100" alt="...">

								</a>
							</div>
							<div class="carousel-item">
								<a> <img
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
						<a> <img class="rounded" id="image-session-hr-1" alt=""
							src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/392x156_shopee_t3.jpg" />
						</a>
					</div>
					<div class="mt-3">
						<a> <img class="rounded" id="image-session-hr-2" alt=""
							src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/392x156_zalopay_t3.jpg" />
						</a>
					</div>

				</div>
				<!-- end img content hr -->

			</div>

			<!--  -->
			<div class="d-flex flex-row justify-content-between mt-4">
				<div class="">
					<img alt=""
						src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/HSO_T1_T324_BannerX4UuDai_SmallBanner_310x210_web_2.png">
				</div>
				<div class="">
					<img alt=""
						src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/tranglego_resize_smallbanner_V2_310x210_1.png">
				</div>
				<div class="">
					<img alt=""
						src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/Trangforeignbooks_0324_smallbanner_310x210.png">
				</div>
				<div class="">
					<img alt=""
						src="https://cdn0.fahasa.com/media/wysiwyg/Thang-03-2024/NCCDinhTi_T323_BannerSmallBanner_310x210.png">
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

			<!-- End content -->
		</div>



		<!-- footer -->
		<%@include file="./footer/footer.jsp" %>
			 
			 
			 
			 <!-- đóng if java -->
			 <% } %>
</body>
</html>