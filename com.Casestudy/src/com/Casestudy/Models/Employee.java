/**
 * 
 */
package com.Casestudy.Models;

import java.sql.Blob;
import java.util.Date;

import com.Casestudy.CustomAnnotations.EmailConstraint;


/**
 * @author amahome
 *Model class for employee
 */
public class Employee {

//	private int empId;
	private String fullName;
	
	@EmailConstraint
	private String empEmail;
	private String empPassword;
	private int roleNumber;
	private String desnName;
	/**
	 * @param empId
	 * @param fullName
	 * @param empEmail
	 * @param empPassword
	 * @param roleNumber
	 * @param desnName
	 * 
	 * constructor with all the params
	 */
	public Employee(String fullName, String empEmail, String empPassword, int roleNumber, String desnName) {
		//super();
//		this.empId = empId;
		this.fullName = fullName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.roleNumber = roleNumber;
		this.desnName = desnName;
	}
	
	
	/**empty constructor**/
	public Employee() {
		
	}

//	/**
//	 * @return the empId
//	 */
//	public int getEmpId() {
//		return empId;
//	}
//
//	/**
//	 * @param empId the empId to set
//	 */
//	public void setEmpId(int empId) {
//		this.empId = empId;
//	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the empEmail
	 */
	public String getEmpEmail() {
		return empEmail;
	}

	/**
	 * @param empEmail the empEmail to set
	 */
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	/**
	 * @return the empPassword
	 */
	public String getEmpPassword() {
		return empPassword;
	}

	/**
	 * @param empPassword the empPassword to set
	 */
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	/**
	 * @return the roleNumber
	 */
	public int getRoleNumber() {
		return roleNumber;
	}

	/**
	 * @param roleNumber the roleNumber to set
	 */
	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}

	/**
	 * @return the desnName
	 */
	public String getDesnName() {
		return desnName;
	}

	/**
	 * @param desnName the desnName to set
	 */
	public void setDesnName(String desnName) {
		this.desnName = desnName;
	}

	public boolean equals(Object a) {
		Employee emp = (Employee)a;
		return this.getFullName().equals(emp.getFullName()) && this.getEmpEmail().equals(emp.getEmpEmail()) && this.getEmpPassword().equals(emp.getEmpPassword())
				&& this.getRoleNumber()==emp.getRoleNumber() && this.getDesnName().equals(emp.getDesnName());
		
	}
	
	
}
