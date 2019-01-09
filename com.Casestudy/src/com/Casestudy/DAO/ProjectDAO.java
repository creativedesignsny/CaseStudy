/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Casestudy.DAOI.ProjectDAOI;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Project;

/**
 * @author amahome
 *
 */
public class ProjectDAO extends OracleConnection implements ProjectDAOI{
	
	Connection connection = null;
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets the list of all the projects from the database 
	 * 
	 *return type - List<Project>
	 */
	public List<Project> getAllProjects(){

		List<Project> projectList = new ArrayList<Project>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_PROJECTS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				Address address = new Address();
				project.setProjectId(rs.getBigDecimal(1));
				project.setProjectName(rs.getString(2));
				project.setStartDate(rs.getString(3));
				project.setEndDate(rs.getString(4));
				project.setStatus(rs.getString(5));
				project.setDescription(rs.getString(6));
				project.setClientFullName(rs.getString(12));
				project.setEmpFullName(rs.getString(13));
				project.setVenFullName(rs.getString(14));
				address.setHomeAptno(rs.getString(7));
				address.setStreetName(rs.getString(8));
				address.setCity(rs.getString(9));
				address.setState(rs.getString(10));
				address.setZipcode(rs.getInt(11));
				project.setProjectAddress(address);
				projectList.add(project);
			}
			return projectList;
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return null;
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets a projects from the database for the given project name
	 * @param String projectName
	 *return type - Project (object)
	 */
	
	public Project getProjectByName(String projectName) {
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_PROJECT_BY_NAME.getQuery());
			ps.setString(1, projectName);
			rs = ps.executeQuery();
			if (rs.next()) {
				Project project = new Project();
				Address address = new Address();
				project.setProjectId(rs.getBigDecimal(1));
				project.setProjectName(rs.getString(2));
				project.setStartDate(rs.getString(3));
				project.setEndDate(rs.getString(4));
				project.setStatus(rs.getString(5));
				project.setDescription(rs.getString(6));
				project.setProjectAddress(address);
				project.setClientFullName(rs.getString(12));
				project.setEmpFullName(rs.getString(13));
				project.setVenFullName(rs.getString(14));
				address.setHomeAptno(rs.getString(7));
				address.setStreetName(rs.getString(8));
				address.setCity(rs.getString(9));
				address.setState(rs.getString(10));
				address.setZipcode(rs.getInt(11));
	            return project;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return null;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method adds a projects to the database
	 * @param String projectName, String startDate, String status, String description, String clientName, String empName, String vendorName
	 *return type - boolean
	 */
	
	public boolean addProject(String projectName, String startDate, String status, String description, String clientName, String empName, String vendorName) {
		int clientId=0;
		int empId=0;
		int vendorId=0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_CLIENT_ID.getQuery());
			ps.setString(1, clientName);
			rs = ps.executeQuery();
			if (rs.next()) {
				clientId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_EMPLOYEE_ID.getQuery());
			ps.setString(1, empName);
			rs = ps.executeQuery();
			if (rs.next()) {
				empId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_VENDOR_ID.getQuery());
			ps.setString(1, vendorName);
			rs = ps.executeQuery();
			if (rs.next()) {
				vendorId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.ADD_PROJECT.getQuery());
			ps.setString(1, projectName);
			ps.setString(2, startDate);
			ps.setString(3, status);
			ps.setString(4, description);
			ps.setInt(5, clientId);
			ps.setInt(6, empId);
			ps.setInt(7, vendorId);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return false;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method adds the address of the projects to the database
	 * @param String homeAptno, String streetName, String city, String state, int zipcode
	 *return type - boolean
	 */
	
	public boolean addProjectAddress(String homeAptno, String streetName, String city, String state, int zipcode) {
		boolean success=false;
		int maxId = 0;
		int relId = 0;
		String relation = "project";
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ADDRESS_RELATION_ID.getQuery());
			ps.setString(1, relation);
			rs = ps.executeQuery();
			if (rs.next()) {
				relId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_MAX_PROJECT_ID.getQuery());
			rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.ADD_PROJECT_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setInt(5, zipcode);
			ps.setInt(6, maxId);
			ps.setInt(7, relId);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = connection.prepareStatement(SQL.UPDATE_PROJECT.getQuery());
				ps.setInt(1, maxId);
				rs = ps.executeQuery();
				if (rs.next()) {
					success = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method updates the end date of the projects
	 * @param String startDate, String endDate, String status, String description, String clientName, String empName, String vendorName, String projectName
	 *return type - boolean
	 */
	
	public boolean updateProjectDate(String startDate, String endDate, String status, String description, String clientName, String empName, String vendorName, String projectName) {
		boolean success=false;
		int clientId=0;
		int empId=0;
		int vendorId=0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_CLIENT_ID.getQuery());
			ps.setString(1, clientName);
			rs = ps.executeQuery();
			if (rs.next()) {
				clientId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_EMPLOYEE_ID.getQuery());
			ps.setString(1, empName);
			rs = ps.executeQuery();
			if (rs.next()) {
				empId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_VENDOR_ID.getQuery());
			ps.setString(1, vendorName);
			rs = ps.executeQuery();
			if (rs.next()) {
				vendorId = rs.getInt(1);
				System.out.println(vendorId);
			}
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROJECT_DATE.getQuery());
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ps.setString(3, status);
			ps.setString(4, description);
			ps.setInt(5, clientId);
			ps.setInt(6, empId);
			ps.setInt(7, vendorId);
			ps.setString(8, projectName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method updates all the details of the project
	 * @param String startDate, String status, String description, String clientName, String empName, String vendorName, String projectName
	 *return type - boolean
	 */
	
	public boolean updateProjectAll(String startDate, String status, String description, String clientName, String empName, String vendorName, String projectName) {
		boolean success=false;
		int clientId=0;
		int empId=0;
		int vendorId=0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_CLIENT_ID.getQuery());
			ps.setString(1, clientName);
			rs = ps.executeQuery();
			if (rs.next()) {
				clientId = rs.getInt(1);
				System.out.println("hello");
				System.out.println(clientId);
			}
			ps = connection.prepareStatement(SQL.GET_EMPLOYEE_ID.getQuery());
			ps.setString(1, empName);
			rs = ps.executeQuery();
			if (rs.next()) {
				empId = rs.getInt(1);
				System.out.println(empId);
			}
			ps = connection.prepareStatement(SQL.GET_VENDOR_ID.getQuery());
			ps.setString(1, vendorName);
			rs = ps.executeQuery();
			if (rs.next()) {
				vendorId = rs.getInt(1);
				System.out.println(vendorId);
			}
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROJECT_ALL.getQuery());
			System.out.println(startDate);
			System.out.println(status);
			System.out.println(projectName);
			ps.setString(1, startDate);
			ps.setString(2, status);
			ps.setString(3, description);
			ps.setInt(4, clientId);
			ps.setInt(5, empId);
			ps.setInt(6, vendorId);
			ps.setString(7, projectName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
				return success;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method updates all the address of the project
	 * @param String homeAptno, String streetName, String city, String state, int zipcode, String projectName
	 *return type - boolean
	 */
	
	public boolean updateProjectAddress(String homeAptno, String streetName, String city, String state, int zipcode, String projectName) {
		boolean success=false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROJECT_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setInt(5, zipcode);
			ps.setString(6, projectName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets a project for the given project id
	 * @param BigDecimal projectId
	 *return type - Project (object)
	 */
	
	public Project getProjectById(BigDecimal projectId) {
		Project project = new Project();
		Address address = new Address();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_PROJECT_BY_ID.getQuery());
			ps.setBigDecimal(1, projectId);
			rs = ps.executeQuery();
			if (rs.next()) {
				project.setProjectId(rs.getBigDecimal(1));
				project.setProjectName(rs.getString(2));
				project.setStartDate(rs.getString(3));
				project.setEndDate(rs.getString(4));
				project.setStatus(rs.getString(5));
				project.setDescription(rs.getString(6));
				project.setProjectAddress(address);
				project.setClientFullName(rs.getString(12));
				project.setEmpFullName(rs.getString(13));
				project.setVenFullName(rs.getString(14));
				address.setHomeAptno(rs.getString(7));
				address.setStreetName(rs.getString(8));
				address.setCity(rs.getString(9));
				address.setState(rs.getString(10));
				address.setZipcode(rs.getInt(11));
	            return project;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return null;
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method updates the status of a project for the given project id
	 * @param String status, BigDecimal projectId
	 *return type - boolean
	 */
	
	public boolean updateProjectStatus(String status, BigDecimal projectId) {
		boolean success=false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROJECT_STATUS.getQuery());
			ps.setString(1, status);
			ps.setBigDecimal(2, projectId);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
	
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method deletes a project from the database for the given project id
	 * @param String status, BigDecimal projectId
	 *return type - boolean
	 */
	public boolean deleteProject(BigDecimal projectId) {
		boolean success=false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.DELETE_PROJECT.getQuery());
			ps.setBigDecimal(1, projectId);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return success;
	}
}
