<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


</head>
<body>
	<% 
	String msg_e_email = ((request.getAttribute("msg_error_email")+"").equals("null"))?"":(request.getAttribute("msg_error_email")+""); 
	
	
	
	%>

<div class="bg-body-tertiary mt-5" data-bs-theme="dark" >
<div class="container">
  <footer class="py-5"></footer>
    <div class="row ">
      <div class="col-6 col-md-2 mb-3 ">
        <h5 class="text-success">Section</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
        </ul>
      </div>

      <div class="col-6 col-md-2 mb-3">
        <h5 class="text-success ">Section</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
        </ul>
      </div>

      <div class="col-6 col-md-2 mb-3">
        <h5 class="text-success">Section</h5>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Home</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Features</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Pricing</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">FAQs</a></li>
          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">About</a></li>
        </ul>
      </div>

      <div class="col-md-5 offset-md-1 mb-3">
        <form action="./customer-controller?event=SendMailCustomer" method="post">
          <h5 class="text-success">Tâm trung hỗ trợ khách hàng</h5>
          <p class="text-light">Bạn có vẫn đề gì hay để lại địa chỉ email tại đây</p>
          <div class="d-flex flex-column flex-sm-row w-100 gap-2">
            <label for="mailCustomer" class="visually-hidden">Email address</label>
            <input id="mailCustomer" name="mailCustomer" type="text" class="form-control" placeholder="Email address">
            <button class="btn btn-success" type="submit">Send</button>
            
          </div>
          <div class="text-danger">
          		<p><%= msg_e_email %>  </p>
          </div>
        </form>
      </div>
    </div>

    <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top bg-body-tertiary " >
      <p class="text-light" style="margin-left: 5px">&copy; 2024 Company, Inc. All rights reserved. </p>
      <ul class="list-unstyled d-flex">
        <li class="ms-3"><a class="link-body-emphasis" href="#"><img id="fb-icon" alt="" src="./img/facebook.png"/></a></li>
        <li class="ms-3"><a class="link-body-emphasis" href="#"><img id="fb-icon" alt="" src="./img/instagram.png"/></a></li>
        <li class="ms-3"><a class="link-body-emphasis" href="#"><img id="fb-icon" alt="" src="./img/youtube.png"/></a></li>
      </ul>
    </div>
    </div>
    </div>
    
</body>
</html>