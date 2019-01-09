<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<style>
		<%@include file="assets/css/style.css" %>
	</style>
</head>
<body class="bg-fixed">
	<div class="container-fluid h-100">
		<div class="row flex-row h-100">
			<div class="col-12 my-auto">
				<div class="reset-form mx-auto">
					<div class="logo">
						<img src="${pageContext.request.contextPath}/resources/images/design ms logo.png">
						<h3>Password Reset</h3>
					</div>
					<form action="enter-email" class="needs-validation" method="POST">
						<div class="group material-input">
							<input type="text" id="text" name="email" placeholder="Email" required>
<!-- 		      				<span class="highlight"></span>
  							<span class="bar"></span> 
  							<label for="email">Email</label>-->
						</div>						
						<div class="button text-center">
							<button class="btn btn-color" type="submit">Reset Password</button>
							<p class="invalid red-text text-center">${message}</p>
						</div>
					</form>
					<div class="back">
						<a href="home">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>