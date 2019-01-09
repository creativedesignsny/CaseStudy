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
  	<!--  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>-->
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<style><%@include file="assets/css/style.css" %></style>
</head>
<%int count=1; %>
<body>
	<div class="page">
	 <%@include file="navbar2.html" %>
		<div class="content-inner">
			<div class="container-fluid">
				<div class="row">
					<div class="page-header">
						<div class="d-flex align-items-center">
							<h2 class="page-header-title">Edit Projects</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-12">
						<div class="widget has-shadow">
							<div class="widget-header bordered no-actions d-flex align-items-center">
								<h4>Edit Project Details</h4>
							</div>
							<div class="widget-body">
								<form action="edit-project" class="needs-validation" method="POST">
									<div class="section-title mt-5 text-center">
	                                	<h6>Choose Project to Edit</h4>
	                                </div>
									<div class="form-group row d-flex justify-content-center mb-5">
                                        <div class="col-lg-4">
                                        <c:if test="${not empty projects}">
                                            <select name="projectName" id="selectProject" class="custom-select form-control">
                                            	<option value="">Select</option>
                                            	<c:forEach var="project" items="${projects}">
	                                            	<option value="${project.getProjectName()}">${project.getProjectName()}</option>
                                            	</c:forEach>
                                            </select>
                                        </c:if>
                                            <span class="invalid">${successMessage}</span>	
                                        </div>
	                                </div>								
									<!--<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Project Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" id="projectName" class="form-control" name="projectName" />
                                             <p ></p>
                                         </div>
                                     </div>  -->
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Start Date</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="datepicker" name="startDate" placeholder="MM/DD/YYYY" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">End Date</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="datepicker2" name="endDate" placeholder="MM/DD/YYYY" required>
                                         </div>
                                     </div>                                     
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Status</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="status" name="status" placeholder="Status" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Client Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="clientFullName" name="clientFullName" placeholder="Client Name" required>
                                         </div>
                                     </div>
                                     <div class="form-group row d-flex align-items-center mb-5">
                                       	<label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Assign To</label>
                                       	<div class="col-lg-5">
                                       	<c:if test="${not empty listEmp}">
	                                    	<select name="empFullName" id="empName" class="custom-select form-control" required>
	                                    		<option value="">Select Employee</option>
	                                    	<c:forEach var="allEmp" items="${listEmp}">
	                                    		<option value="${allEmp.getFullName()}">${allEmp.getFullName()}</option>
	                                    	</c:forEach>			                                             		
	                                    	</select>
	                                    </c:if>
                                    	</div>		                                                
                                 	</div> 
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Vendor Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="venFullName" name="venFullName" placeholder="Vendor Name" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Apt No./House No.</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="homeAptno" name="projectAddress.homeAptno" placeholder="Apt No./House No." required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Street Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="streetName" name="projectAddress.streetName" placeholder="Street Name" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">City</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="city" name="projectAddress.city" placeholder="City" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">State</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="state" name="projectAddress.state" placeholder="State" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Zipcode</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="zipcode" name="projectAddress.zipcode" placeholder="Zipcode" required>
                                         </div>
                                     </div>                                                                                                                                                                                                                            
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Description</label>
                                         <div class="col-lg-5">
                                             <textarea rows="4" id="description" class="form-control" cols="50" name="description"></textarea>
                                         </div>
                                     </div>
									<div class="text-center">
                                         <button class="btn btn-color" type="submit">Edit Project</button>
                                         <button class="btn btn-shadow" type="reset">Reset</button>
                                    </div>   
                                     <span class="invalid">${message}</span>	                                                                                                                                                                                                                                              
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-12">
						<div class="widget has-shadow">
							<div class="widget-header bordered no-actions d-flex align-items-center">
								<h4>Project List</h4>
							</div>
					<div class="widget-body">
						<div class="table-responsive">
						<c:if test="${not empty projects}">
							<table id="projectTables" class="table mb-0">
								<thead>
									<tr>
										<th>Ser. No.</th>
										<th>Project Name</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Status</th>
										<th>Description</th>
										<th>Employee Assigned</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="allProject" items="${projects}">
									<tr>
										<td><%out.print(count); %></td>
										<td>${allProject.getProjectName()}</td>
										<td>${allProject.getStartDate()}</td>
										<td>${allProject.getEndDate()}</td>
										<td>${allProject.getStatus()}</td>
										<td>${allProject.getDescription()}</td>
										<td>${allProject.getEmpFullName()}</td>
										<!--<td><a href="${allProject.getProjectId()}">Delete</a></td>-->
										<td><a href="#" class="btn btn-color" id="delete-btn" data-toggle="modal" data-target="#exampleModal">Delete</a></td>
									</tr>
									<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog" role="document">
									    <div class="modal-content">
									      <div class="modal-header">
									       <!--  <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>-->
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">
									       <P>Are you sure you want to delete the project?</P>
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
									        <a href="${allProject.getProjectId()}" class="btn btn-primary btn-color">Yes</a>
									      </div>
									    </div>
									  </div>
									</div>
									<% count++; %>
								</c:forEach>	
								</tbody>											
							</table>
							</c:if>
						</div>
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
  $( function() {
	  $('#selectProject').change(function(){
		  var selectProject = $(this).val();
		  console.log(selectProject);
		  $.ajax({
			  
			   url:"${pageContext.request.contextPath}/ajax-call",
			   type:"POST",
			   async:true,
			   //context: document.body,
			   dataType: "json",
			   data:{projectName: selectProject},
			   complete:function(data){
				   console.log(data);
				   writeData(data);
			  }
			});
	  });
  });
  
  function writeData(data)
  {
	if(data != undefined){
		if(data.responseJSON != undefined){
			 var project = data.responseJSON;
			 $('#projectName').val(project.projectName);
			 $('#datepicker').val(project.startDate);
			 $('#datepicker2').val(project.endDate);
			 $('#status').val(project.status);
			 $('#clientFullName').val(project.clientFullName);
			 $('#empName').val(project.empFullName);
			 $('#venFullName').val(project.venFullName);
			 $('#description').val(project.description);
			 $('#homeAptno').val(project.projectAddress.homeAptno);
			 $('#streetName').val(project.projectAddress.streetName);
			 $('#city').val(project.projectAddress.city);
			 $('#state').val(project.projectAddress.state);
			 $('#zipcode').val(project.projectAddress.zipcode);
			   
		}else{
			clearData();
		}
	} 
  }
  
  function clearData(){
	  $('#projectName').val('');
		 $('#datepicker').val('');
		 $('#datepicker2').val('');
		 $('#status').val('');
		 $('#clientFullName').val('');
		 $('#empName').val('');
		 $('#venFullName').val('');
		 $('#description').val('');
		 $('#homeAptno').val('');
		 $('#streetName').val('');
		 $('#city').val('');
		 $('#state').val('');
		 $('#zipcode').val('');
  }
  
  
  </script>	
</body>
</html>