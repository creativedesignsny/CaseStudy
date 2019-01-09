/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 *
 */
public class EmployeeRole {
	
	private int roleId;
	private String roleName;
	private int empRoleId;
	
	
	/**
	 * @param roleId
	 * @param roleName
	 * @param empRoleId
	 */
	public EmployeeRole(int roleId, String roleName, int empRoleId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.empRoleId = empRoleId;
	}
	
	public EmployeeRole() {
		
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the empRoleId
	 */
	public int getEmpRoleId() {
		return empRoleId;
	}

	/**
	 * @param empRoleId the empRoleId to set
	 */
	public void setEmpRoleId(int empRoleId) {
		this.empRoleId = empRoleId;
	}
	

}
