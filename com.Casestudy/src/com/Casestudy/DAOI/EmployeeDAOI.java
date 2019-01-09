/**
 * 
 */
package com.Casestudy.DAOI;

import java.util.List;

import com.Casestudy.Models.Employee;

/**
 * @author amahome
 *
 */
public interface EmployeeDAOI {
	
	//Query to select all employee table by email
	enum SQL {
		/** select an employee with address from address table, with role from employeerole table, designation
		 *  from employee designation table for the given email**/
		GET_EMPLOYEE_BY_EMAIL("SELECT employee.fullName, employee.empEmail, employee.empPassword,\r\n"
				+ "EMPLOYEEROLE.ROLENUMBER, EMPLOYEEDESIGNATION.DESGNNAME FROM EMPLOYEE\r\n"
				+ "LEFT JOIN EMPLOYEEROLE on employee.EMPROLEID = EMPLOYEEROLE.ROLEID\r\n"
				+ "LEFT JOIN EMPLOYEEDESIGNATION on employee.EMPDESGNID = EMPLOYEEDESIGNATION.DESGNID WHERE empEmail = ?"),
		
		/**gets the employee roleid from EMPLOYEEROLE table **/
		GET_EMPROLE_ID("SELECT ROLEID FROM EMPLOYEEROLE WHERE ROLENUMBER = ?"),
		
		//not required
		GET_EMPDESGN_ID("SELECT DESGNID FROM EMPLOYEEDESIGNATION WHERE DESGNNAME = ?"),
		
		/** get the employee id from the employee table for the given employee name**/
		GET_EMP_ID("SELECT EMPID from employee WHERE fullName = ?"),
		
		//not required
		CHECK_EMP_EXISTS("SELECT * FROM EMPLOYEE WHERE fullName = ?"),
		
		/** Adds a new employee in to employee table**/
		ADD_EMPLOYEE("INSERT INTO EMPLOYEE (fullName, empEmail, empPassword, EMPROLEID, EMPDESGNID) VALUES (?, ?, ?, ?, ?)"),
		
		/** Gets all the employee from employee table**/
		GET_ALL_EMPLOYEE("SELECT employee.fullName, employee.empEmail, employee.empPassword,\r\n"
				+ "EMPLOYEEROLE.ROLENUMBER, EMPLOYEEDESIGNATION.DESGNNAME FROM EMPLOYEE\r\n"
				+ "LEFT JOIN EMPLOYEEROLE on employee.EMPROLEID = EMPLOYEEROLE.ROLEID\r\n"
				+ "LEFT JOIN EMPLOYEEDESIGNATION on employee.EMPDESGNID = EMPLOYEEDESIGNATION.DESGNID"),
		
		/** updates the password of the employee**/
		CHANGE_PASSWORD("UPDATE EMPLOYEE SET empPassword = ? WHERE empEmail = ?"),
		
		//not required
		GET_EMPLOYEEID_BY_NAME("SELECT employee.empId FROM employee WHERE fullName = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	/** gets employee for the given email
	 * returns an employee object
	 * **/
	public Employee getEmployeeByEmail(String empEmail);
	
	
	//not required
	public int getEmpId(String fullName);
	
	/** Adds employee to the database
	 * @params fullName
	 * @param empEmail
	 * @param role
	 * @param desgn
	 * 
	 * returns a boolean value
	 * **/
	public boolean addEmployee(String fullName, String empEmail, int role, String desgn);
	
	
	/** gets the list of all employee
	 *return type - list<employee> 
	 * **/
	public List<Employee> getAllEmployee();
	
	
	/** update the password of an employee
	 * @param empEmail
	 * @param emppassword
	 * **/
	public boolean changePassword(String empEmail, String empPassword);
	
	
	/** not required**/
	public int getEmployeeIdByName(String fullName);
	

}
