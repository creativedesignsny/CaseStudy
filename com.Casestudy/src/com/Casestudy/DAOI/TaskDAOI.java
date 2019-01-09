/**
 * 
 */
package com.Casestudy.DAOI;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.Models.Task;

/**
 * @author amahome
 *
 */
public interface TaskDAOI {
	
	
	enum SQL {
		
		ADD_TASK("INSERT INTO task (taskName, ASSIGNEDTOEMPID, ASSIGNEDBYEMPID, ASSIGNDATE, DUEDATE, COMMENTS,\r\n"
				+ "NOTE, PROJECTID) values (?, ?, ?, TO_DATE(?, 'MM/DD/YYYY'), TO_DATE(?, 'MM/DD/YYYY'), ?, ?, ?)"),
		GET_EMP_ID("SELECT EMPID from employee WHERE fullName = ?"),
		
		GET_ALL_TASKS(" SELECT task.TASKID, task.taskName, a.FULLNAME, b.FULLNAME, TO_CHAR(task.ASSIGNDATE,'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(task.DUEDATE,'MM/DD/YYYY'), TO_CHAR(task.FINISHDATE,'MM/DD/YYYY'), task.COMMENTS, task.NOTE,\r\n" + 
				"				project.PROJECTNAME from task\r\n" + 
				"				JOIN employee a on a.EMPID = task.ASSIGNEDTOEMPID\r\n" + 
				"				JOIN employee b on b.EMPID = task.ASSIGNEDBYEMPID\r\n" + 
				"				JOIN project on project.PROJECTID = task.PROJECTID"),
		
		UPDATE_TASK("UPDATE TASK SET ASSIGNEDTOEMPID = (SELECT EMPID from employee WHERE fullName = ?),	ASSIGNEDBYEMPID = (SELECT EMPID from employee WHERE fullName = ?), ASSIGNDATE = TO_DATE(?, 'MM/DD/YYYY'),\r\n" +
				"DUEDATE = TO_DATE(?, 'MM/DD/YYYY'), FINISHDATE = TO_DATE(?, 'MM/DD/YYYY'), COMMENTS = ?,\r\n" + 
				"NOTE = ?, PROJECTID = (SELECT PROJECTID FROM PROJECT WHERE PROJECTNAME = ?) WHERE TASKNAME = ?"),
		
		GET_PROJECT_ID("SELECT PROJECTID FROM PROJECT WHERE PROJECTNAME = ?"),
		
		DELETE_TASK("DELETE FROM TASK WHERE TASKNAME = ?"),
		
		GET_TASK_BY_DUE_DATE(" SELECT task.TASKID, task.taskName, a.FULLNAME, b.FULLNAME, TO_CHAR(task.ASSIGNDATE,'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(task.DUEDATE,'MM/DD/YYYY'), TO_CHAR(task.FINISHDATE,'MM/DD/YYYY'), task.COMMENTS, task.NOTE,\r\n" + 
				"				project.PROJECTNAME from task\r\n" + 
				"				JOIN employee a on a.EMPID = task.ASSIGNEDTOEMPID\r\n" + 
				"				JOIN employee b on b.EMPID = task.ASSIGNEDBYEMPID\r\n" + 
				"				JOIN project on project.PROJECTID = task.PROJECTID WHERE DUEDATE = trunc(sysdate) AND ASSIGNEDTOEMPID = ?"),
		
		GET_TASK_BY_NAME(" SELECT task.TASKID, task.taskName, a.FULLNAME, b.FULLNAME, TO_CHAR(task.ASSIGNDATE,'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(task.DUEDATE,'MM/DD/YYYY'), TO_CHAR(task.FINISHDATE,'MM/DD/YYYY'), task.COMMENTS, task.NOTE,\r\n" + 
				"				project.PROJECTNAME from task\r\n" + 
				"				JOIN employee a on a.EMPID = task.ASSIGNEDTOEMPID\r\n" + 
				"				JOIN employee b on b.EMPID = task.ASSIGNEDBYEMPID\r\n" + 
				"				JOIN project on project.PROJECTID = task.PROJECTID WHERE TASKNAME = ?"),
		
		GET_TASK_BY_ID(" SELECT task.TASKID, task.taskName, a.FULLNAME, b.FULLNAME, TO_CHAR(task.ASSIGNDATE,'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(task.DUEDATE,'MM/DD/YYYY'), TO_CHAR(task.FINISHDATE,'MM/DD/YYYY'), task.COMMENTS, task.NOTE,\r\n" + 
				"				project.PROJECTNAME from task\r\n" + 
				"				JOIN employee a on a.EMPID = task.ASSIGNEDTOEMPID\r\n" + 
				"				JOIN employee b on b.EMPID = task.ASSIGNEDBYEMPID\r\n" + 
				"				JOIN project on project.PROJECTID = task.PROJECTID WHERE TASKID = ?"),
		
		GET_TASK_BY_EMPLOYEE("SELECT task.TASKID, task.taskName, employee.EMPID, employee.EMPID, task.ASSIGNDATE,\r\n"
				+ "task.DUEDATE, task.FINISHDATE, task.COMMENTS, task.NOTE, project.PROJECTID from task\r\n"
				+ "JOIN employee on employee.EMPID = task.ASSIGNEDTOEMPID JOIN project on project.PROJECTID = task.PROJECTID\r\n"
				+ "WHERE ASSIGNEDTOEMPID = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}

	public boolean addTask(String taskName, String assignToEmp, String assignByEmp, String assignDate, String dueDate, String comments, String note, String prName);
	
	public List<Task> getAllTasks();
	
	public List<Task> getTaskByEmployee(int empId);
	
	public Task getTaskByName(String taskName);
	
	public Task getTaskById(BigDecimal taskId);
	public List<Task> getTaskByDueDate(String assignToEmp);
	
	public boolean updateTask(String assignToEmp, String assignByEmp, String assignDate, String dueDate, String finishDate, String comments, String note, String prName, String taskName);
	
	public boolean deleteTask(String taskName);
}
