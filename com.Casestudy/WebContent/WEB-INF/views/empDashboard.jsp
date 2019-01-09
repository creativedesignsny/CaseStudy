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
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome-font-awesome.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
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
								<h2 class="page-header-title">Welcome ${fullName}</h2>
							</div>
						</div>
						
					</div>
					<div id="empRole" class="row flex-row  justify-content-center">
						<div class="col-xl-4 col-md-6 col-sm-6">
							<div class="widget widget-12 has-shadow">
								<div class="widget-body text-center">
									<a href="project"><h2>Project</h2></a>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-md-6 col-sm-6">
							<div class="widget widget-12 has-shadow">
								<div class="widget-body text-center">
									<a href="Task"><h2>Task</h2></a>
								</div>
							</div>
						</div>
						<div class="col-xl-4 col-md-6 col-sm-6">
							<div class="widget widget-12 has-shadow">
								<div class="widget-body text-center">
									<a href="project-detail"><h2>Project Details</h2></a>
								</div>
							</div>
						</div>			
					</div>
					<div class="row">
						<div class="col-xl-12">
							<div class="widget has-shadow">
								<div class="widget-header bordered no-actions d-flex align-items-center">
									<h4>Projects</h4>
								</div>
								<div class="widget-body">
									<div class="table-responsive">
									<c:if test="${not empty projects}">
										<table id="dataTables" class="table mb-0">
											<thead>
												<tr>
													<th>Ser. No.</th>
													<th>Project Name</th>
													<th>Start Date</th>
													<th>End Date</th>
													<th>Status</th>
													<th>Description</th>
													<th>Employee Assigned</th>
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
				</div>
			</div>
		</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script type="text/javascript">
	 	$(document).ready( function () {
	 	    $('#dataTables').DataTable();
	 	} );
	 </script>
</body>
</html>