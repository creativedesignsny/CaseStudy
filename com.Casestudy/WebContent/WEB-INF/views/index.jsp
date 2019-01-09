<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome DMS</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat:400,500,600,700%7CNoto+Sans:400,700" media="all">
	<style>
		<%@include file="assets/css/style.css" %>
	</style>
</head>
<body>
	<div class="container-fluid h-100 no-padding">
		<div class="row flex-row">
			<div class="col-xl-3 col-lg-5 col-md-5 col-sm-12 col-12 no-padding">
				<div class="main-content">
					<div class="content mx-auto text-center">
						<img src="${pageContext.request.contextPath}/resources/images/design ms logo.png">
						<h2>Design Management Made Easy</h2>
						<p>
                                Plan Projects, Track Progress, Task management and Collaborate with Your Team.
                            </p>
					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-7 col-md-12 col-sm-12 col-12 my-auto no-padding">
				<div class="form-container mx-auto">
					<div class="form-content">
						<h3>Login</h3>
						<form:form action="login" method="post" modelAttribute="empkey" id="formid">
							<div class="group material-input">
								<form:input type="text" id="empEmail" path="empEmail" placeholder="Email"></form:input>
								<span class="invalid"><form:errors path="empEmail"></form:errors></span>
								<div class="invalid">
	     							<span >${message}</span>
	     						</div>
	  							<!-- <span class="bar"></span> 
	  							<label class="email-label" for="email">Email</label>-->
							</div>
							<div class="group material-input">
								<input type="password" id="pswd" name="empPassword" placeholder="Password">
	<!-- 		      							<span class="highlight"></span>
	  							<span class="bar"></span>
	  							<label for="pswd">Password</label> -->
							</div>
							<div class="row">
								<div class="col text-left">
									<!--<div class="checkbox-style">
										<input type="checkbox" id="remember" name="checkbox">
										<label for="remember">Remember me</label>
									</div> -->
								</div>
								<div class="col text-right reset-style">
									<a href="forgot-password">Change/Forgot Password?</a>
								</div>
							</div>
							<div class="btn-login text-center">
								<!--  <a href="dashboard.html" class="btn btn-style btn-color">Sign In</a>-->
								<button type="submit" class="btn btn-style btn-color">Sign In</button>
							</div>						
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>