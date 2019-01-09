/**
 * 
 */
package com.Casestudy.DAOI;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.Casestudy.Models.Client;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.Models.Vendor;

/**
 * @author amahome
 *
 */
public interface ProjectDAOI {
	
	enum SQL {
		
		/**gets all the projects for project table with address from address table,
		 *  employee name from employee table, client name from client table, vendor name from vendor table **/
		GET_ALL_PROJECTS("SELECT project.projectId, project.projectName, TO_CHAR(project.startDate, 'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(project.endDate, 'MM/DD/YYYY'), project.status, project.description, address.homeAptno,\r\n" + 
				"				address.streetName, address.city, address.state, address.ZIPCODE, client.clientFullName,\r\n" + 
				"				employee.fullName, vendor.VENDORFULLNAME FROM project\r\n" + 
				"				LEFT JOIN address ON project.PROJECTADDRESSID = address.ADDRESSID\r\n" + 
				"				LEFT JOIN client on project.CLIENTID = client.clientId\r\n" + 
				"				LEFT JOIN employee on project.EMPID = employee.empId\r\n" + 
				"				LEFT JOIN vendor on project.VENDORID = vendor.VENDORID"),
		
		
		GET_PROJECT_BY_ID("SELECT project.projectId, project.projectName, TO_CHAR(project.startDate, 'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(project.endDate, 'MM/DD/YYYY'), project.status, project.description, address.homeAptno,\r\n" + 
				"				address.streetName, address.city, address.state, address.ZIPCODE, client.clientFullName,\r\n" + 
				"				employee.fullName, vendor.VENDORFULLNAME FROM project\r\n" + 
				"				LEFT JOIN address ON project.PROJECTADDRESSID = address.ADDRESSID\r\n" + 
				"				LEFT JOIN client on project.CLIENTID = client.clientId\r\n" + 
				"				LEFT JOIN employee on project.EMPID = employee.empId\r\n" + 
				"				LEFT JOIN vendor on project.VENDORID = vendor.VENDORID WHERE projectId = ?"),
		
		/** gets the project detail from project table, address table, employee table, client table and
		 *  vendor table for the given project name **/
		GET_PROJECT_BY_NAME("SELECT project.projectId, project.PROJECTNAME, TO_CHAR(project.startDate, 'MM/DD/YYYY'),\r\n" + 
				"				TO_CHAR(project.endDate, 'MM/DD/YYYY'), project.status, project.description, address.homeAptno,\r\n" + 
				"				address.streetName, address.city, address.state, address.zipcode, client.clientFullName,\r\n" + 
				"				employee.fullName, vendor.VENDORFULLNAME\r\n" +
				" 				FROM project\r\n" + 
				"				JOIN address ON project.PROJECTADDRESSID = address.ADDRESSID\r\n" + 
				"				JOIN client on project.CLIENTID = client.clientId\r\n" + 
				"				JOIN employee on project.EMPID = employee.empId\r\n" +
				"				JOIN vendor on project.VENDORID = vendor.VENDORID WHERE PROJECTNAME = ?"),
		
		
		/**updates the project details **/
		UPDATE_PROJECT_ALL("UPDATE project SET startDate = TO_DATE(?, 'MM/DD/YYYY'),\r\n" + 
				"				status = ?, description = ?, CLIENTID = ?,\r\n" +
				" 				EMPID = ?, VENDORID = ? WHERE PROJECTNAME = ?"),
		
		/**updates the project date **/
		UPDATE_PROJECT_DATE("UPDATE project SET startDate = TO_DATE(?, 'MM/DD/YYYY'),\r\n" + 
				"				endDate = TO_DATE(?, 'MM/DD/YYYY'), status = ?, description = ?, CLIENTID =?,\r\n" +
				" 				EMPID = ?, VENDORID = ? WHERE PROJECTNAME = ?"),
		
		/**updates the project address **/
		UPDATE_PROJECT_ADDRESS("UPDATE ADDRESS SET homeAptno = ?, streetName = ?, city = ?, state = ?, zipcode = ? WHERE\r\n"+
				" 				ADDRESSID = (SELECT PROJECTADDRESSID FROM PROJECT WHERE PROJECTNAME = ?)"),
		
		
		/**updates the status of the project **/
		UPDATE_PROJECT_STATUS("UPDATE PROJECT SET status = ? WHERE projectId = ?"),
		
		/**not required **/
		GET_PROJECT_BY_EMPLOYEE("SELECT project.projectId, project.projectName, project.startDate,\r\n"
				+ "project.endDate, project.status, project.description, address.homeAptno,\r\n"
				+ "address.streetName, address.city, address.state, address.zipcode, client.clientFullName,\r\n"
				+ "employee.fullName FROM project\r\n"
				+ "LEFT JOIN address ON project.PROJECTADDRESSID = address.ADDRESSID\r\n"
				+ "LEFT JOIN client on project.CLIENTID = client.clientId\r\n"
				+ "LEFT JOIN employee on project.EMPID = employee.empId\r\n"
				+ "LEFT JOIN vendor on project.VENDORID = vendor.VENDORID WHERE EMPID = ?"),
		
		
		/** not required**/
		GET_PROJECT_BY_CLIENT("SELECT project.projectId, project.projectName, project.startDate,\r\n"
				+ "project.endDate, project.status, project.description, address.homeAptno,\r\n"
				+ "address.streetName, address.city, address.state, address.zipcode, client.clientFullName\r\n"
				+ "employee.fullName, vendor.VENDORFULLNAME FROM project\r\n"
				+ "LEFT JOIN address ON project.PROJECTID = address.relationId\r\n"
				+ "LEFT JOIN client on project.CLIENTID = client.clientId\r\n"
				+ "LEFT JOIN employee on project.EMPID = employee.empId\r\n"
				+ "LEFT JOIN vendor on project.VENDORID = vendor.VENDORID WHERE CLIENTID = ?"),
		
		/** gets the id of the employee for the given name**/
		GET_EMPLOYEE_ID("SELECT EMPID FROM EMPLOYEE WHERE FULLNAME = ?"),
		
		/** gets the id of the client for the given name**/
		/** **/
		GET_CLIENT_ID("SELECT CLIENTID FROM CLIENT WHERE CLIENTFULLNAME = ?"),
		
		
		/** gets the id of the vendor for the given name**/
		GET_VENDOR_ID("SELECT VENDORID FROM VENDOR WHERE VENDORFULLNAME = ?"),
		
		
		/**not required **/
		GET_ADDRESS_RELATION_ID("SELECT RELATIONID FROM ADDRESSRELATION WHERE RELATIONLINK = ?"),
		
		/**not required **/
		GET_MAX_PROJECT_ID("SELECT max(projectId) FROM PROJECT"),
		
		
		/** Adds a new project to the database**/
		ADD_PROJECT("INSERT INTO PROJECT (projectName, startDate, status, description,\r\n"
				+ "CLIENTID, EMPID, VENDORID) VALUES (?, TO_DATE(?, 'MM/DD/YYYY'), ?, ?, ?, ?, ?)"),
		
		
		/** Adds the address of the new project added**/
		ADD_PROJECT_ADDRESS("INSERT INTO ADDRESS (homeAptno, streetName, city, state, zipcode, relatedTo, relationId)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)"),
		
		/**updates the project details **/
		UPDATE_PROJECT("UPDATE PROJECT SET PROJECTADDRESSID = (SELECT max(ADDRESSID) FROM ADDRESS) WHERE PROJECTID = ?"),
		
		DELETE_PROJECT("DELETE FROM PROJECT WHERE projectId = ?"),
		
		/**not required **/
		GET_PROJECT_BY_ADDRESS("SELECT project.projectId, project.projectName, project.STARTDATE, project.ENDDATE, project.STATUS, project.DESCRIPTION, client.clientFullName, employee.fullName,\r\n"
				+ "vendor.VENDORFULLNAME FROM project\r\n"
				+ "LEFT JOIN client on project.CLIENTID = client.CLIENTID\r\n"
				+ "LEFT JOIN employee on project.EMPID = employee.EMPID\r\n"
				+ "LEFT JOIN vendor on project.VENDORID = vendor.VENDORID WHERE PROJECTADDRESSID = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	/** gets all the projects from the database
	 * return type - list of project
	 * **/
	public List<Project> getAllProjects();
	
	
	/**gets the project for the given project name
	 * return type - Project
	 *  **/
	public Project getProjectByName(String projectName);
	
	
	/** Updates the project info
	 * return type - boolean
	 *  **/
	public boolean updateProjectStatus(String status, BigDecimal projectId);
	
	
	/** Adds the project to the database 
	 * return type boolean
	 * **/
	public boolean addProject(String projectName, String startDate, String status, String description, String clientName, String empName, String vendorName);
	
	
	/** Adds the project to the database 
	 * return type boolean
	 * **/
	public boolean addProjectAddress(String homeAptno, String streetName, String city, String state, int zipcode);
	
	
	/** Updates the project 
	 * return type boolean
	 * **/
	public boolean updateProjectAll(String startDate, String status, String description, String clientName, String empName, String vendorName, String projectName);
		
	/**
	 * not required
	 * **/
	public boolean updateProjectDate(String startDate, String endDate, String status, String description, String clientName, String empName, String vendorName, String projectName);
	
	
	/** Updates the project address
	 * return type boolean
	 * **/
	public boolean updateProjectAddress(String homeAptno, String streetName, String city, String state, int zipcode, String projectName);
		
	/** returns the project by id from the database 
	 * return type Project
	 * **/
	public Project getProjectById(BigDecimal projectId);
	
	
	/** deletes project by id from the database 
	 * return type boolean
	 * **/
	public boolean deleteProject(BigDecimal projectId);

}
