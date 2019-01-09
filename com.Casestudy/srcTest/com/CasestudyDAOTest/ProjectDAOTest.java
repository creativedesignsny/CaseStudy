/**
 * 
 */
package com.CasestudyDAOTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Casestudy.DAO.ProjectDAO;
import com.Casestudy.DAOI.ProjectDAOI.SQL;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Project;

/**
 * @author amahome
 *
 */
public class ProjectDAOTest {
	 
	static ProjectDAO projectDAO;
	
	private final static String url = "jdbc:oracle:thin:@10.0.0.87:1521:student";
	private final static String user = "C##student";
	private final static String pass = "school";
	private final static Driver driver = new oracle.jdbc.driver.OracleDriver();
	
	protected static Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);
		projectDAO = new ProjectDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#getAllProjects()}.
	 */
	@Test
	public final void testGetAllProjects() {
		//fail("Not yet implemented");
		List<Project> ex_projectList = new ArrayList<Project>();
		List<Project> act_projectList = new ArrayList<Project>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_PROJECTS.getQuery());
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
				ex_projectList.add(project);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		act_projectList.addAll(projectDAO.getAllProjects());
		assertEquals(ex_projectList, act_projectList);
	}
	
	
	@Test
	public final void testGetAllProjectsFail() {
		//fail("Not yet implemented");
		List<Project> ex_projectList = new ArrayList<Project>();
		List<Project> act_projectList = new ArrayList<Project>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_PROJECTS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				Address address = new Address();
				project.setProjectId(new BigDecimal(87));
				project.setProjectName("Berlanga");
				project.setStartDate("05122018");
				project.setEndDate("");
				project.setStatus("Retainrd");
				project.setDescription("Home Improvement");
				project.setClientFullName("Vilma Berlanga");
				project.setEmpFullName("Brett Mccullan");
				project.setVenFullName("Thomas A Lazzaro");
				address.setHomeAptno("6649");
				address.setStreetName("E Morehead St");
				address.setCity("Webb");
				address.setState("Texas");
				address.setZipcode(78045);
				project.setProjectAddress(address);
				ex_projectList.add(project);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		act_projectList.addAll(projectDAO.getAllProjects());
		assertEquals(ex_projectList, act_projectList);
	}


	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#getProjectByName(java.lang.String)}.
	 */
	@Test
	public final void testGetProjectByName() {
		//fail("Not yet implemented");
		Project act_project = new Project();
		Project ex_project = null;
		try {
			ps = conn.prepareStatement(SQL.GET_PROJECT_BY_NAME.getQuery());
			ps.setString(1, "Hancock");
			rs = ps.executeQuery();
			if (rs.next()) {
				ex_project = new Project();
				Address address = new Address();
				ex_project.setProjectId(rs.getBigDecimal(1));
				ex_project.setProjectName(rs.getString(2));
				ex_project.setStartDate(rs.getString(3));
				ex_project.setEndDate(rs.getString(4));
				ex_project.setStatus(rs.getString(5));
				ex_project.setDescription(rs.getString(6));
				ex_project.setProjectAddress(address);
				ex_project.setClientFullName(rs.getString(12));
				ex_project.setEmpFullName(rs.getString(13));
				ex_project.setVenFullName(rs.getString(14));
				address.setHomeAptno(rs.getString(7));
				address.setStreetName(rs.getString(8));
				address.setCity(rs.getString(9));
				address.setState(rs.getString(10));
				address.setZipcode(rs.getInt(11));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		act_project = projectDAO.getProjectByName("Hancock");
		assertEquals(ex_project.getProjectName(), act_project.getProjectName());
	}
	
	
	@Test
	public final void testGetProjectByNameFail() {
		//fail("Not yet implemented");
		Project act_project = new Project();
		Project ex_project = null;
				ex_project = new Project();
				Address address = new Address();
				ex_project.setProjectId(new BigDecimal(87));
				ex_project.setProjectName("Berlanga");
				ex_project.setStartDate("05122018");
				ex_project.setEndDate("");
				ex_project.setStatus("Retained");
				ex_project.setDescription("Home Improvement");
				ex_project.setClientFullName("Vilma Berlanga");
				ex_project.setEmpFullName("Brett Mccullan");
				ex_project.setVenFullName("Thomas A Lazzaro");
				address.setHomeAptno("6649");
				address.setStreetName("E Morehead St");
				address.setCity("Webb");
				address.setState("Texas");
				address.setZipcode(78045);
				ex_project.setProjectAddress(address);
		
		act_project = projectDAO.getProjectByName("Hancock");
		assertEquals(ex_project.getProjectName(), act_project.getProjectName());
	}
	


	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#addProject(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddProject() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#addProjectAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testAddProjectAddress() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#updateProjectDate(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testUpdateProjectDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#updateProjectAll(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testUpdateProjectAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#updateProjectAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public final void testUpdateProjectAddress() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#getProjectById(java.math.BigDecimal)}.
	 */
	@Test
	public final void testGetProjectById() {
		//fail("Not yet implemented");
		Project ex_project = null;
		Project act_project = new Project();
		try {
			ps = conn.prepareStatement(SQL.GET_PROJECT_BY_ID.getQuery());
			ps.setBigDecimal(1, new BigDecimal(8));
			rs = ps.executeQuery();
			if (rs.next()) {
				ex_project = new Project();
				Address address = new Address();
				ex_project.setProjectId(rs.getBigDecimal(1));
				ex_project.setProjectName(rs.getString(2));
				ex_project.setStartDate(rs.getString(3));
				ex_project.setEndDate(rs.getString(4));
				ex_project.setStatus(rs.getString(5));
				ex_project.setDescription(rs.getString(6));
				ex_project.setProjectAddress(address);
				ex_project.setClientFullName(rs.getString(12));
				ex_project.setEmpFullName(rs.getString(13));
				ex_project.setVenFullName(rs.getString(14));
				address.setHomeAptno(rs.getString(7));
				address.setStreetName(rs.getString(8));
				address.setCity(rs.getString(9));
				address.setState(rs.getString(10));
				address.setZipcode(rs.getInt(11));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		act_project = projectDAO.getProjectById(new BigDecimal(8));
		assertEquals(ex_project.getProjectName(), act_project.getProjectName());
		
	}
	
	
	@Test
	public final void testGetProjectByIdFail() {
		//fail("Not yet implemented");
		Project ex_project = null;
		Project act_project = new Project();
				ex_project = new Project();
				Address address = new Address();
				ex_project.setProjectId(new BigDecimal(87));
				ex_project.setProjectName("Berlanga");
				ex_project.setStartDate("05122018");
				ex_project.setEndDate("");
				ex_project.setStatus("Retained");
				ex_project.setDescription("Home Improvement");
				ex_project.setClientFullName("Vilma Berlanga");
				ex_project.setEmpFullName("Brett Mccullan");
				ex_project.setVenFullName("Thomas A Lazzaro");
				address.setHomeAptno("6649");
				address.setStreetName("E Morehead St");
				address.setCity("Webb");
				address.setState("Texas");
				address.setZipcode(78045);
				ex_project.setProjectAddress(address);
		act_project = projectDAO.getProjectById(new BigDecimal(8));
		assertEquals(ex_project.getProjectName(), act_project.getProjectName());
		
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ProjectDAO#updateProjectStatus(java.lang.String, java.math.BigDecimal)}.
	 */
	@Test
	public final void testUpdateProjectStatus() {
		fail("Not yet implemented");
	}

}
