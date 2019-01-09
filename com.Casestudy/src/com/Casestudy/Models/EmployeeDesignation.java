/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 *
 */
public class EmployeeDesignation {
	
	private int desgnId;
	private String desgnName;
	private int empDesgnId;
	/**
	 * @param desgnId
	 * @param desgnName
	 * @param empDesgnId
	 */
	public EmployeeDesignation(int desgnId, String desgnName, int empDesgnId) {
		super();
		this.desgnId = desgnId;
		this.desgnName = desgnName;
		this.empDesgnId = empDesgnId;
	}
	
	
	public EmployeeDesignation() {
		
	}


	/**
	 * @return the desgnId
	 */
	public int getDesgnId() {
		return desgnId;
	}


	/**
	 * @param desgnId the desgnId to set
	 */
	public void setDesgnId(int desgnId) {
		this.desgnId = desgnId;
	}


	/**
	 * @return the desgnName
	 */
	public String getDesgnName() {
		return desgnName;
	}


	/**
	 * @param desgnName the desgnName to set
	 */
	public void setDesgnName(String desgnName) {
		this.desgnName = desgnName;
	}


	/**
	 * @return the empDesgnId
	 */
	public int getEmpDesgnId() {
		return empDesgnId;
	}


	/**
	 * @param empDesgnId the empDesgnId to set
	 */
	public void setEmpDesgnId(int empDesgnId) {
		this.empDesgnId = empDesgnId;
	}

}
