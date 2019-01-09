/**
 * 
 */
package com.Casestudy.Models;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author amahome
 *Model class for Task
 */
public class Task {
	private BigDecimal taskId;
	private String taskName;
	private String assignedToEmp;
	private String assignedByEmp;
	private String assignDate;
	private String dueDate;
	private String finishDate;
	private String comments;
	private String note;
	private String projectName;
	/**
	 * @param taskId
	 * @param taskName
	 * @param assignedToEmp
	 * @param assignedByEmp
	 * @param assignDate
	 * @param dueDate
	 * @param finishDate
	 * @param comments
	 * @param note
	 * @param projectName
	 * 
	 * Constructor with all params
	 */
	public Task(BigDecimal taskId, String taskName, String assignedToEmp, String assignedByEmp, String assignDate, String dueDate,
			String finishDate, String comments, String note, String projectName) {
		//super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.assignedToEmp = assignedToEmp;
		this.assignedByEmp = assignedByEmp;
		this.assignDate = assignDate;
		this.dueDate = dueDate;
		this.finishDate = finishDate;
		this.comments = comments;
		this.note = note;
		this.projectName = projectName;
	}
	
	/**empty constructor**/
	public Task() {
		
	}

	/**
	 * @return the taskId
	 */
	public BigDecimal getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(BigDecimal taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the assignedToEmp
	 */
	public String getAssignedToEmp() {
		return assignedToEmp;
	}

	/**
	 * @param assignedToEmp the assignedToEmp to set
	 */
	public void setAssignedToEmp(String assignedToEmp) {
		this.assignedToEmp = assignedToEmp;
	}

	/**
	 * @return the assignedByEmp
	 */
	public String getAssignedByEmp() {
		return assignedByEmp;
	}

	/**
	 * @param assignedByEmp the assignedByEmp to set
	 */
	public void setAssignedByEmp(String assignedByEmp) {
		this.assignedByEmp = assignedByEmp;
	}

	/**
	 * @return the assignDate
	 */
	public String getAssignDate() {
		return assignDate;
	}

	/**
	 * @param assignDate the assignDate to set
	 */
	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the finishDate
	 */
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * @param finishDate the finishDate to set
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Override
	public boolean equals(Object a) {
		Task t = (Task)a;
		return this.getTaskId() == t.getTaskId() && this.getTaskName().equals(t.getTaskName()) && this.getAssignedToEmp().equals(t.getAssignedToEmp()) &&
				this.getAssignedByEmp().equals(t.getAssignedByEmp()) && this.getAssignDate().equals(t.getAssignDate()) && this.getDueDate().equals(t.getDueDate()) &&
				this.getFinishDate() == t.getFinishDate() && this.getComments().equals(t.getComments()) &&
				this.getNote().equals(t.getNote()) && this.getProjectName().equals(t.getProjectName());
		
	}
	
}
