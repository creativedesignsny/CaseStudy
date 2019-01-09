<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>theDesignMS</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat:400,500,600,700%7CNoto+Sans:400,700" media="all">
	<!--  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i" rel="stylesheet">-->
	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome-font-awesome.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<style><%@include file="assets/css/style.css" %></style>
</head>
<body>
	<div class="page">
	 <%@include file="navbar2.html" %>
		<div class="content-inner">
			<div class="container-fluid">
				<div class="row">
					<div class="page-header">
						<div class="d-flex align-items-center">
							<h2 class="page-header-title">Profile</h2>
						</div>
					</div>
				</div>
				<div class="row flex-row">
					<div class="col-xl-3">
						<div class="widget has-shadow">
							<div class="widget-body">
								<div clas="mt-5">
									<img src="${pageContext.request.contextPath}/resources/images/placeholder1.png" alt="..." style="width: 120px;" class="avatar rounded-circle d-block mx-auto">
								</div>
								<h3 class="text-center mt-3 mb-1">${employee.getFullName()}</h3>
								<p class="text-center text-style">${employee.getEmpEmail()}</p>
								<div class="em-separator separator-dashed"></div>
								<ul class="nav flex-column">
									<li class="nav-item">
										<a class="nav-link" href="javascript:void(0)">
											<i class="fa fa-bell fa-2x align-middle pr-2"></i>
										Notifications
										</a>
									</li>
									<li class="nav-item">
                                         <a class="nav-link" href="javascript:void(0)">
                                         	<i class="fa fa-comments fa-2x align-middle pr-2"></i>
                                         Messages</a>
                                    </li>
                                    <li class="nav-item">
                                    	<a class="nav-link" href="javascript:void(0)">
                                    		<i class="fa fa-clipboard fa-2x align-middle pr-2"></i>
                                    	Tasks
                                    	</a>
                                    </li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-9">
						<div class="widget has-shadow">
							<div class="widget-header bordered no-actions d-flex align-items-center">
                                 <h4>Update Profile</h4>
                            </div>
                            <div class="widget-body">
	                            <div class="col-10 ml-auto">
	                         		<div class="section-title mt-3 mb-3">
	                             		<h4>01. Personnal Informations</h4>
	                         		</div>
	                     		</div>
	                     		<form action="update-profile" class="form-horizontal">
	                     			<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Full Name</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="fullName" value="${empprofile.getFullName()}" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Email</label>
                                         <div class="col-lg-6">
                                        	<div class="input-group">
	                                            <input type="email" size="30" name="email" value="${empprofile.getEmpEmail()}" class="form-control">
	                                            <span class="input-group-addon addon-orange">.com</span>
                                            </div>
                                  		</div>
                                  	</div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Home Phone</label>
                                         <div class="col-lg-6">
                                             <input type="tel" class="form-control" name="homephone" value="${empprofile.getEmpHomePhone()}" placeholder="000-000-0000">
                                         </div>
                                     </div>                                     
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Mobile Phone</label>
                                         <div class="col-lg-6">
                                             <input type="tel" class="form-control" name="mobilephone" value="${empprofile.getEmpMobilePhone()}" placeholder="000-000-0000">
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">DOB</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" id="datepicker" name="dob" value="${empprofile.getDob()}" placeholder="MM/DD/YYYY" required>
                                         </div>
                                    </div> 
									<div class="col-10 ml-auto">
                                         <div class="section-title mt-3 mb-3">
                                             <h4>02. Address Informations</h4>
                                         </div>
                                    </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Apt/House No.</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="projectAddress.homeAptno" value="${empprofile.empAddress.getHomeAptno()}" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Street Name</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="projectAddress.streetName" value="${empprofile.empAddress.getStreetName()}" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">City</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="projectAddress.city" value="${empprofile.empAddress.getCity()}" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">State</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="projectAddress.state" value="${empprofile.empAddress.getState()}" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-2 form-control-label d-flex justify-content-lg-end">Zipcode</label>
                                         <div class="col-lg-6">
                                             <input type="text" class="form-control" name="projectAddress.zipcode" value="${empprofile.empAddress.getZipcode()}" required>
                                         </div>
                                     </div> 
                                     <div class="em-separator separator-dashed"></div>
									<div class="text-right">
                                         <button class="btn btn-color" type="submit">Save Changes</button>
                                         <button class="btn btn-shadow" type="reset">Reset</button>
                                    </div>   
                                     <span class="invalid">${message}</span>	                                                                                                                                                                             		                                   
	                     		</form>
                            </div>
						</div>
					</div>

				</div>				
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script>
  $( function() {
    $( "#datepicker, #datepicker2" ).datepicker();
  } );
  </script>	
</body>
</html>