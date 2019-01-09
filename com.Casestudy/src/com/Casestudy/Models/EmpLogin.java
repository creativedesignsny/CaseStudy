/**
 * 
 */
package com.Casestudy.Models;

import com.Casestudy.CustomAnnotations.EmailConstraint;

/**
 * @author amahome
 * Model class for employee login
 */
public class EmpLogin {
	
	@EmailConstraint
	private String empEmail;
	private String empPassword;
	/**
	 * @param empEmail
	 * @param empPassword
	 * Constructor with all params
	 */
	public EmpLogin(String empEmail, String empPassword) {
		super();
		this.empEmail = empEmail;
		this.empPassword = empPassword;
	}

	
	/**Empty constructor**/
	public EmpLogin() {
		
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
	
	
}
