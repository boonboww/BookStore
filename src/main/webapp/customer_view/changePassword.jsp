<%@page import="org.apache.catalina.util.CustomObjectInputStream"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

html, body {
	height: 100%;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>

	<% 
	 String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	
		String msg_error_chagePass = ((request.getAttribute("msg_error_chagePass")+"").equals("null"))?"":(request.getAttribute("msg_error_chagePass")+"");
	
	Object obj = session.getAttribute("taiKhoan");
		
	Customer cs = null;
	if(obj != null) {
			cs = (Customer)obj;
	}
	if(cs == null) {
			response.sendRedirect("signin.jsp");
		} else {
			
			
		
			
		
			
			%>





	<!-- Header -->
	<jsp:include page="../header/header-customer.jsp"></jsp:include> 
	<!-- End Header -->
	
	
	
	<div class="text-center">
		<main class="form-signin">
			<form action="<%= url %>/customer-controller?event=ChangePassword" method="post">
				<img class="mb-4 rounded"
					src="https://scontent.fdad3-6.fna.fbcdn.net/v/t39.30808-6/428606868_1576096856263316_1319923844701228492_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHSAMFYZhv07SCMjj-FSH0B-mG181sJQzz6YbXzWwlDPL3H0gg_h8cLzvxtkMwZ0n1JNhwjkrrA2O9PDADZ3HF2&_nc_ohc=nqtHojF2IhgAX8Mk2YY&_nc_ht=scontent.fdad3-6.fna&oh=00_AfDhy-Q7FpwX8i0p5Ps7DItCuECZUlespm9QHtPwaKMpKw&oe=65FD0D41"
					alt="" width="72" height="57">
				<div> <h1 class="h3 mb-3 fw-normal">
					Đổi mật Khẩu 
				</h1></div>
				<div>
					<p class="text-danger"> <%=msg_error_chagePass %> </p>
					<label> <span class="text-danger" id="msgCheckNewPass"></span> </label>
				</div>
				
				
				<div class="form-floating">
					<input type="text" class="form-control" id="OldPassword"
						placeholder="Password" name="OldPassword"> <label
						for="OldPassword" required="required" >Mật khẩu cũ</label>
				</div>

				<div class="form-floating">
					<input type="password" class="form-control" id="NewPassword"
						placeholder="mật khẩu mới" name="NewPassword"> <label
						for="NewPassword" required="required">Mật khẩu Mới</label>
				</div>
				
				 	
	
				<div class="form-floating">
				 
					<input type="password" class="form-control" id="checkNewPassword"
						placeholder="Password" name="checkNewPassword"> <label 
						for="checkNewPassword" onkeyup="checkNewPass()" required="required" >Nhập lại mật khẩu mới <span class="text-danger" id="msgCheckNewPass"></span> </label>
				</div>


				<button class="w-100 btn btn-lg btn-primary" type="submit">Thay
					đổi</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
			</form>
		</main>
		<a style="text-decoration: none;" href="">  </a>
	</div>
	<% } %>
	
	<%@include file="../footer/footer-customer.jsp" %>
	
	
<script type="text/javascript">
	function checkNewPass() {
		
			  var newPass = document.getElementById("NewPassword").value;
			  var checkNewPass = document.getElementById("checkNewPassword").value;

			  if(newPass != checkNewPass) {
			    document.getElementById("msgCheckNewPass").innerHTML = "Không khớp mật khẩu mới";
			   
			    return false;
			  } else {
			    document.getElementById("msgCheckNewPass").innerHTML = "***";
			    return true;
			  }
	}


</script>

</body>
</html>