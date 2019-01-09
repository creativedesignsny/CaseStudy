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
							<h2 class="page-header-title">Project Details</h2>
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
												<th>Employee Assigned</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="allProject" items="${projects}">
											<tr>
												<td><%out.print(count); %></td>
												<td><a href="${allProject.getProjectId()}">${allProject.getProjectName()}</a></td>
												<td>${allProject.getStartDate()}</td>
												<td>${allProject.getEmpFullName()}</td>
											</tr>
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
					<div class="row">
						<div class="col-xl-12">
							<div class="widget has-shadow">
								<div class="widget-header bordered no-actions d-flex align-items-center">
									<h4>Edit Project Details</h4>
								</div>
								<div class="widget-body detail-style">
								<span class="invalid">${updateMessage}</span>
									<div class="col-lg-12 d-inline-flex">
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Project Name:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getProjectName()}</p>
		                                    </div>                                    
		                                </div>
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>START DATE:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getStartDate()}</p>
		                                    </div>                                    
		                                </div>
		                              </div>
									<div class="col-lg-12 d-inline-flex">
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>End Date:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getEndDate()}</p>
		                                    </div>                                    
		                                </div>
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Address</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getProjectAddress().getHomeAptno()},  ${projectById.getProjectAddress().getStreetName()},
		                                    	${projectById.getProjectAddress().getCity()},<br> ${projectById.getProjectAddress().getState()}-
		                                    	${projectById.getProjectAddress().getZipcode()}</p>
		                                    </div>                                    
		                                </div>
		                              </div>
									<div class="col-lg-12 d-inline-flex">
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Client Name:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getClientFullName()}</p>
		                                    </div>                                    
		                                </div>
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Designer Name:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getEmpFullName()}</p>
		                                    </div>                                    
		                                </div>
		                              </div>
									<div class="col-lg-12 d-inline-flex mb-5">
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Vendor Name:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getVenFullName()}</p>
		                                    </div>                                    
		                                </div>
		                                <div class="col-lg-6 d-inline-flex">
		                                	<div class="col-sm-4">
		                                    	<p>Description:</p>
		                                    </div>
		                                    <div class="col-sm-8">
		                                    	<p>${projectById.getDescription()}</p>
		                                    </div>                                    
		                                </div>		                                
		                            </div> 
		                            <form action="edit-status" method="POST">
										<div class="form-group row col-lg-7 d-inline-flex align-items-center mb-5">
		                                   <label class="col-lg-3 form-control-label d-flex justify-content-lg-end">Status:</label>
		                                   <div class="col-lg-7">
		                                       <input type="text" class="form-control" id="zipcode" name="status" value="${projectById.getStatus()}" required>
		                                   </div>
		                               </div>
		                               <div class="form-group col-lg-4 d-inline-flex align-items-center mb-5">
		                               		<button class="btn btn-color" type="submit">Edit Status</button>
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
$( function() {
    $( "#datepicker, #datepicker2" ).datepicker();
  } );
/*$( function() {
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
}*/
</script>
</body>
</html>
