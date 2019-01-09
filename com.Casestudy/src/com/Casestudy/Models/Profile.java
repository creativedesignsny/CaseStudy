/**
 * 
 */
package com.Casestudy.Models;

import java.math.BigDecimal;

/**
 * @author amahome
 *Model class for employee profile
 */
public class Profile {
	private BigDecimal empId;
	private String fullName;
	private String dob;
	private String empHomePhone;
	private String empMobilePhone;
	private String empEmail;
	private Address empAddress;
	/**
	 * @param empId
	 * @param fullName
	 * @param dob
	 * @param empHomePhone
	 * @param empMobilePhone
	 * @param empEmail
	 * @param empImg
	 * @param empAddress
	 * Constructor with params
	 */
	public Profile(BigDecimal empId, String fullName, String dob, String empHomePhone, String empMobilePhone, String empEmail,
			Address empAddress) {
		//super();
		this.empId = empId;
		this.fullName = fullName;
		this.dob = dob;
		this.empHomePhone = empHomePhone;
		this.empMobilePhone = empMobilePhone;
		this.empEmail = empEmail;
		//this.empImg = empImg;
		this.empAddress = empAddress;
	}
	
	/**Empty Constructor**/
	public Profile() {
		
	}

	/**
	 * @return the empId
	 */
	public BigDecimal getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}

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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the empHomePhone
	 */
	public String getEmpHomePhone() {
		return empHomePhone;
	}

	/**
	 * @param empHomePhone the empHomePhone to set
	 */
	public void setEmpHomePhone(String empHomePhone) {
		this.empHomePhone = empHomePhone;
	}

	/**
	 * @return the empMobilePhone
	 */
	public String getEmpMobilePhone() {
		return empMobilePhone;
	}

	/**
	 * @param empMobilePhone the empMobilePhone to set
	 */
	public void setEmpMobilePhone(String empMobilePhone) {
		this.empMobilePhone = empMobilePhone;
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

//	/**
//	 * @return the empImg
//	 */
//	public Blob getEmpImg() {
//		return empImg;
//	}
//
//	/**
//	 * @param empImg the empImg to set
//	 */
//	public void setEmpImg(Blob empImg) {
//		this.empImg = empImg;
//	}

	/**
	 * @return the empAddress
	 */
	public Address getEmpAddress() {
		return empAddress;
	}

	/**
	 * @param empAddress the empAddress to set
	 */
	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
