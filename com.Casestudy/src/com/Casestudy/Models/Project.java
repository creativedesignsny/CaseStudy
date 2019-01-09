/**
 * 
 */
package com.Casestudy.Models;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author amahome
 *Model class for project
 */
public class Project {
	
	private BigDecimal projectId;
	private String projectName;
	private String startDate;
	private String endDate;
	private String status;
	private String description;
	private Address projectAddress;
	private String clientFullName;
	private String empFullName;
	private String venFullName;
	/**
	 * @param projectId
	 * @param projectName
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param description
	 * @param projectAddress
	 * @param clientFullName
	 * @param empFullName
	 * @param venFullName
	 * Constructor with params
	 */
	public Project(BigDecimal projectId, String projectName, String startDate, String endDate, String status, String description,
			Address projectAddress, String clientFullName, String empFullName, String venFullName) {
		//super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.description = description;
		this.projectAddress = projectAddress;
		this.clientFullName = clientFullName;
		this.empFullName = empFullName;
		this.venFullName = venFullName;
	}
	
	/**empty constructor**/
	public Project() {
		
	}

	/**
	 * @return the projectId
	 */
	public BigDecimal getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(BigDecimal projectId) {
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
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the projectAddress
	 */
	public Address getProjectAddress() {
		return projectAddress;
	}

	/**
	 * @param projectAddress the projectAddress to set
	 */
	public void setProjectAddress(Address projectAddress) {
		this.projectAddress = projectAddress;
	}

	/**
	 * @return the clientFullName
	 */
	public String getClientFullName() {
		return clientFullName;
	}

	/**
	 * @param clientFullName the clientFullName to set
	 */
	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	/**
	 * @return the empFullName
	 */
	public String getEmpFullName() {
		return empFullName;
	}

	/**
	 * @param empFullName the empFullName to set
	 */
	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}

	/**
	 * @return the venFullName
	 */
	public String getVenFullName() {
		return venFullName;
	}

	/**
	 * @param venFullName the venFullName to set
	 */
	public void setVenFullName(String venFullName) {
		this.venFullName = venFullName;
	}
	
	@Override
	public boolean equals(Object a) {
		Project p = (Project)a;
		return this.getProjectId() == p.getProjectId() && this.getProjectName().equals(p.getProjectName()) && this.getStartDate().equals(p.getStartDate()) &&
				this.getEndDate() == p.getEndDate() && this.getStatus().equals(p.getStatus()) && this.getDescription().equals(p.getDescription()) &&
				this.getProjectAddress().getHomeAptno().equals(p.getProjectAddress().getHomeAptno()) && this.getProjectAddress().getStreetName().equals(p.getProjectAddress().getStreetName()) &&
				this.getProjectAddress().getCity().equals(p.getProjectAddress().getCity()) && this.getProjectAddress().getState().equals(p.getProjectAddress().getState()) &&
				this.getProjectAddress().getZipcode() == p.getProjectAddress().getZipcode() && this.getClientFullName().equals(p.getClientFullName()) &&
				this.getEmpFullName().equals(p.getEmpFullName()) && this.getVenFullName().equals(p.getVenFullName());
		
	}

}
