/**
 * 
 */
package com.Casestudy.Models;

import java.sql.Date;

/**
 * @author amahome
 *
 */
public class GetProject {
	
	private int projectId;
	private String projectName;
	private Date startDate;
	private int empId;
	/**
	 * @param projectId
	 * @param projectName
	 * @param startDate
	 * @param empId
	 */
	public GetProject(int projectId, String projectName, Date startDate, int empId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.empId = empId;
	}
	
	public GetProject() {
		
	}

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
	

}
