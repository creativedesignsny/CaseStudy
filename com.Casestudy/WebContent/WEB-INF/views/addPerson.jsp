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
							<h2 class="page-header-title">Add Person</h2>
						</div>
					</div>
				</div>
				<div class="row flex-row">
					<div class="col-xl-12">
						<div class="widget has-shadow">
							<div class="widget-header bordered no-actions d-flex align-items-center">
								<h4>Enter Person Details</h4>
							</div>
							<div class="widget-body">
								<form action="add-person" class="needs-validation" method="POST" novalidate>
									<div class="row flex-row justify-content-center">
										<div class=col-xl-10>
											<div class="section-title mt-5 text-center">
                                            	<h6>Choose Person to Add</h4>
                                            </div>
												<div class="form-group row d-flex justify-content-center mb-5">
			                                         <div class="col-lg-4">
			                                             <select name="person" id="selectPerson" class="custom-select form-control">
			                                             	<option value="">Select</option>
			                                             	<option value="employee">Employee</option>
			                                             	<option value="client">Client</option>
			                                             	<option value="vendor">Vendor</option>
			                                             </select>
			                                             <span class="invalid">${successMessage}</span>	
			                                         </div>
			                                    </div>
			                                    <div id="empAdd">
				                                   	<div class="form-group row mb-3">
	                                                    <div class="col-xl-6 mb-3">
	                                                        <label class="form-control-label">Name<span class="text-danger ml-2">*</span></label>
	                                                        <input type="text" value="" name="fullName" class="form-control" required>
	                                                    </div>
	                                                    <div class="col-xl-6">
	                                                    <label class="form-control-label">Email<span class="text-danger ml-2">*</span></label>
	                                                    	<div class="input-group">
		                                                        <input type="email" value="" name="email" class="form-control" required>
		                                                        <span class="input-group-addon addon-orange">.com</span>
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                                <div class="form-group row mb-5">
		                                                <div class="col-xl-6">
		                                                    <label class="form-control-label">Designation</label>
			                                             	<select name="desgn" id="empRole" class="custom-select form-control" required>
			                                             		<option value="">Select</option>
			                                             		<option value="Designer">Designer</option>
			                                             		<option value="Architect">Architect</option>
			                                             		<option value="Accountant">Accountant</option>
			                                             		<option value="Draftsman">Draftsman</option>
			                                             		<option value="Project Manager">Project Manager</option>			                                             		
			                                             	</select>
		                                                </div>
		                                                <div class="col-xl-6">
		                                                	<label class="form-control-label">Employee Role</label>
			                                             	<select name="role" id="empRole" class="custom-select form-control" required>
			                                             		<option value="">Select</option>
			                                             		<option value="0">0</option>
			                                             		<option value="1">1</option>
			                                             	</select>
		                                                </div>		                                                
	                                            	</div>	                                                
													<div class="text-center">
				                                         <button class="btn btn-color" type="submit">ADD</button>
				                                         <button class="btn btn-shadow" type="reset">Reset</button>
				                                    </div> 
				                                    <span class="invalid">${successMessage}</span>	                                                		                                    	
			                                    </div>
			                                    <div id="personAdd">
				                                   	<div class="form-group row mb-3">
	                                                    <div class="col-xl-6 mb-3">
	                                                        <label class="form-control-label">Name<span class="text-danger ml-2">*</span></label>
	                                                        <input type="text" name="fullName" class="form-control">
	                                                    </div>
	                                                    <div class="col-xl-6">
	                                                    <label class="form-control-label">Email<span class="text-danger ml-2">*</span></label>
	                                                    	<div class="input-group">
		                                                        <input type="email" size="30" name="email" class="form-control">
		                                                        <span class="input-group-addon addon-orange">.com</span>
	                                                        </div>
	                                                    </div>
	                                                </div> 
	                                                <div class="form-group row mb-3">
	                                                	<div class="col-xl-6 mb-3">
		                                                    <label class="form-control-label">Home Phone</label>
		                                                    <div class="input-group">
		                                                        <span class="input-group-addon addon-primary">
		                                                            <i class="fa fa-phone"></i>
		                                                        </span>
		                                                        <input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control" name="homephone" value="" placeholder="000-000-0000">
		                                                    </div>
		                                                </div>
	                                                	<div class="col-xl-6 mb-3">
		                                                    <label class="form-control-label">Mobile Phone</label>
		                                                    <div class="input-group">
		                                                        <span class="input-group-addon addon-primary">
		                                                            <i class="fa fa-phone"></i>
		                                                        </span>
		                                                        <input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control" name="mobilephone" value="" placeholder="000-000-0000">
		                                                    </div>
		                                                </div>
	                                            	</div>
	                                            	<div class="section-title mt-5 mb-5">
	                                                	<h4>Address</h4>
	                                                </div>
	                                                <div class="form-group row mb-3">
		                                                <div class="col-xl-6">
		                                                    <label class="form-control-label">Home/Apt No.</label>
		                                                    <input type="text" class="form-control" name="homeAptno" required>
		                                                </div>
		                                                <div class="col-xl-6">
		                                                    <label class="form-control-label">Street Name</label>
		                                                    <input type="text" class="form-control" name="street" placeholder=" " required>
		                                                </div>
	                                            	</div>
	                                            	<div class="form-group row mb-3">
	                                                    <div class="col-xl-4 mb-3">
	                                                        <label class="form-control-label">City<span class="text-danger ml-2">*</span></label>
	                                                        <input type="text" value=" " name="city" class="form-control">
	                                                    </div>
	                                                    <div class="col-xl-4 mb-5">
	                                                        <label class="form-control-label">State<span class="text-danger ml-2">*</span></label>
	                                                        <input type="text" value=" " name="state" class="form-control">
	                                                    </div>
	                                                    <div class="col-xl-4">
	                                                        <label class="form-control-label">Zip<span class="text-danger ml-2">*</span></label>
	                                                        <input type="text" value=" " name="zipcode" class="form-control" maxlength="8">
	                                                    </div>
	                                                 </div>
													<div class="text-center">
				                                         <button class="btn btn-color" type="submit">ADD</button>
				                                         <button class="btn btn-shadow" type="reset">Reset</button>
				                                    </div>
				                                    <span class="invalid">${successMessage}</span>	
			                                    </div>                                                                                                                                  	                                           
                                            </div>			
									</div>
								</form>
							</div>					
						</div>
					</div>
				
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#empAdd").hide();
		$( "#selectPerson" ).change(function () {
		    if($( "option:selected", this ).text()=="Employee"){
		   		$("#empAdd").show();
		   		$("#personAdd").hide(); 
		    }else{
		    	$("#empAdd").hide();
		    	$("#personAdd").show();      
		    }
		})
	});
</script>
</body>
</html>