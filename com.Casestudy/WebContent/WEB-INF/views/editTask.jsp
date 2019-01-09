<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import="com.Casestudy.Models.Task" %>
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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<style><%@include file="assets/css/style.css" %></style>
</head>
<body>
<%Task task = (Task)session.getAttribute("tasks"); %>
	<div class="page">
	 <%@include file="navbar2.html" %>
		<div class="content-inner">
			<div class="container-fluid">
				<div class="row">
					<div class="page-header">
						<div class="d-flex align-items-center">
							<h2 class="page-header-title">Edit Task</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-12">
						<div class="widget has-shadow">
							<div class="widget-header bordered no-actions d-flex align-items-center">
								<h4>Edit Task Details</h4>
							</div>
							<div class="widget-body">
								<form action="edit-task" class="needs-validation" method="POST">
									<div class="section-title mt-5 text-center">
	                                         	<h6>Choose Task to Edit</h4>
	                                         </div>
										<div class="form-group row d-flex justify-content-center mb-5">
	                                         <div class="col-lg-4">
	                                         <d:if test="${not empty listTask}">
	                                             <select name="taskName" id="selectTask" class="custom-select form-control">
	                                             	<option value="">Select</option>
	                                             <d:forEach var="allTasks" items="${listTask}">
													<option value="${allTasks.getTaskName()}">${allTasks.getTaskName()}</option>
	                                             </d:forEach>
	                                             </select>
	                                          </d:if>
	                                             <span class="invalid">${successMessage}</span>	
	                                         </div>
	                                    </div>								
									<!--<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Task Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" name="taskName" placeholder="" required>
                                         </div>
                                     </div>-->
                                     <div class="form-group row d-flex align-items-center mb-5">
                                       	<label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Assign To</label>
                                       	<div class="col-lg-5">
                                       	<c:if test="${not empty listEmp}">
	                                    	<select name="assignedToEmp" id="empAssignedTo" class="custom-select form-control" required>
	                                    		<option value="">Select Employee</option>
	                                    	<c:forEach var="allEmp" items="${listEmp}">
	                                    		<option value="${allEmp.getFullName()}">${allEmp.getFullName()}</option>
	                                    	</c:forEach>			                                             		
	                                    	</select>
	                                    </c:if>
                                    	</div>	                                                
                                 	</div>
                                     <div class="form-group row d-flex align-items-center mb-5">
                                       	<label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Assign By</label>
                                       	<div class="col-lg-5">
                                       	<c:if test="${not empty listEmp}">
	                                    	<select name="assignedByEmp" id="empAssignedBy" class="custom-select form-control" required>
	                                    		<option value="">Select Employee</option>
	                                    	<c:forEach var="allEmp" items="${listEmp}">
	                                    		<option value="${allEmp.getFullName()}">${allEmp.getFullName()}</option>
	                                    	</c:forEach>			                                             		
	                                    	</select>
	                                    </c:if>
                                    	</div>		                                                
                                 	</div>                                 		                                     
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Start Date</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="datepicker" name="assignDate" placeholder="MM/DD/YYYY" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Due Date</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="datepicker2" name="dueDate" placeholder="MM/DD/YYYY" required>
                                         </div>
                                     </div>
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">End Date</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="datepicker3" name="finishDate" placeholder="MM/DD/YYYY" required>
                                         </div>
                                     </div>                                                                        
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Note</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="note" name="note" placeholder="Note" required>
                                         </div>
                                     </div>                                     
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Project Name</label>
                                         <div class="col-lg-5">
                                             <input type="text" class="form-control" id="nameofProject" name="projectName" placeholder="Project Name" required>
                                         </div>
                                     </div>                                                                                                                                                                                                                  
									<div class="form-group row d-flex align-items-center mb-5">
                                         <label class="col-lg-4 form-control-label d-flex justify-content-lg-end">Comments</label>
                                         <div class="col-lg-5">
                                             <textarea rows="4" class="form-control" cols="50" id="comments" name="comments"></textarea>
                                         </div>
                                     </div>
									<div class="text-center">
                                         <button class="btn btn-color" type="submit">Edit Task</button>
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
								<h4>Task</h4>
							</div>
							<div class="widget-body">
								<div class="table-responsive">
								<c:if test="${not empty listTask}">
									<table id="taskTable" class="table mb-0">
										<thead>
											<tr>
												<th>Task ID</th>
												<th>Task Name</th>
												<th>Assigned To</th>
												<th>Assigned By</th>
												<th>Assign Date</th>
												<th>Due Date</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="allTask" items="${listTask}">
											<tr>
												<td>${allTask.getTaskId()}</td>
												<td>${allTask.getTaskName()}</td>
												<td>${allTask.getAssignedToEmp()}</td>
												<td>${allTask.getAssignedByEmp()}</td>
												<td>${allTask.getAssignDate()}</td>
												<td>${allTask.getDueDate()}</td>
												<!-- <td><a href="${allTask.getTaskName()}" class="btn btn-primary btn-color">Yes</a></td>-->
												<td><a href="#" class="btn btn-color" id="delete-btn" data-toggle="modal" data-target="#exampleModal">Delete</a></td>
											</tr>
											<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
											  <div class="modal-dialog" role="document">
											    <div class="modal-content">
											      <div class="modal-header">
											       <!--  <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>	--> 
											        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
											          <span aria-hidden="true">&times;</span>
											        </button>
											      </div>
											      <div class="modal-body">
											       <P>Are you sure you want to delete the project?</P>
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
											        <a href="${allTask.getTaskName()}" class="btn btn-primary btn-color">Yes</a>
											      </div>
											    </div>
											  </div>
											</div>										
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
		$(document).ready( function () {
	 	    $('#taskTable').DataTable();
	 	} );
	  $( function() {
	    $( "#datepicker, #datepicker2, #datepicker3" ).datepicker();
	  } );
	  $( function() {
		  $('#selectTask').change(function(){
			  var selectTask = $(this).val();
			  console.log(selectTask);
			  $.ajax({
				  
				   url:"${pageContext.request.contextPath}/ajax-task",
				   type:"POST",
				   async:true,
				   //context: document.body,
				   dataType: "json",
				   data:{taskName: selectTask},
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
				 var task = data.responseJSON;
				 $('#empAssignedTo').val(task.assignedToEmp);
				 $('#empAssignedBy').val(task.assignedByEmp);
				 $('#datepicker').val(task.assignDate);
				 $('#datepicker2').val(task.dueDate);
				 $('#datepicker3').val(task.finishDate);
				 $('#note').val(task.comments);
				 $('#nameofProject').val(task.projectName);
				 $('#comments').val(task.note);
			}else{
				clearData();
			}
		} 
	  }
	  
	  function clearData(){
		 	 $('#empAssignedTo').val('');
			 $('#empAssignedBy').val('');
			 $('#datepicker').val('');
			 $('#datepicker2').val('');
			 $('#datepicker3').val('');
			 $('#note').val('');
			 $('#nameofProject').val('');
			 $('#comments').val('');
	  }
  	</script>	
</body>
</html>