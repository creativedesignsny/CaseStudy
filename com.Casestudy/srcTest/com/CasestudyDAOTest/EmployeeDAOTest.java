/**
 * 
 */
package com.CasestudyDAOTest;

import static org.junit.Assert.*;

import java.io.IOException;
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

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.RandomString;
import com.Casestudy.DAOI.EmployeeDAOI.SQL;
import com.Casestudy.Models.Employee;


/**
 * @author amahome
 *
 */
public class EmployeeDAOTest {
	static EmployeeDAO empDAO;
	
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
		empDAO = new EmployeeDAO();
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
	 * test method for GetEmployeeByEmail(). Passed the test
	 */
	@Test
	public final void testGetEmployeeByEmail() {
//		fail("Not yet implemented");
		Employee expected_emp = new Employee();
		expected_emp.setFullName("James Butt");
		expected_emp.setEmpEmail("jbutt@gmail.com");
		expected_emp.setEmpPassword("Jamesb1979");
		expected_emp.setRoleNumber(0);
		expected_emp.setDesnName("Draftsman");	
		
		
		Employee actual_emp = new Employee();
		actual_emp = empDAO.getEmployeeByEmail("jbutt@gmail.com");
		assertEquals(expected_emp.getEmpPassword(), actual_emp.getEmpPassword());
	}
	
	/**
	 * test method for GetEmployeeByEmail(). Failed the test
	 */
	
	@Test
	public final void testGetEmployeeByEmailFail() {
//		fail("Not yet implemented");
		Employee expected_emp = new Employee();
		expected_emp.setFullName("James Butt");
		expected_emp.setEmpEmail("jbutt@gmail.com");
		expected_emp.setEmpPassword("Jamesb1978");
		expected_emp.setRoleNumber(0);
		expected_emp.setDesnName("Draftsman");	
		
		
		Employee actual_emp = new Employee();
		actual_emp = empDAO.getEmployeeByEmail("jbutt@gmail.com");
		assertEquals(expected_emp.getEmpPassword(), actual_emp.getEmpPassword());
	}
	
	/**
	 * test method for addEmployee(). Passed the test
	 */
	
	@Test
	public final void testaddEmployee() throws Exception {
		Employee emp = new Employee();
		boolean expected;
		boolean actual;
		String s = RandomString.getAlphaNumericString(7);
		stmt = conn.createStatement();
		ps = conn.prepareStatement(SQL.ADD_EMPLOYEE.getQuery());
		ps.setString(1, "Pete Dubaldi");
		ps.setString(2, "pdubaldi@hotmail.com");
		ps.setString(3, s);
		ps.setInt(4, 1);
		ps.setInt(5, 2);
		rs = ps.executeQuery();
		if (rs.next()) {
			expected = true;
		}else {
			expected = false;
		}
		actual = empDAO.addEmployee("Daniel	Perruzza", "dperruzza@perruzza.com", 1, "Designer");
		assertEquals(expected, actual);
	}
	
	
	/**
	 * test method for addEmployee(). Failed the test
	 */
	@Test
	public final void testaddEmployeeFail() throws Exception {
		boolean expected;
		boolean actual;
		String s = RandomString.getAlphaNumericString(7);
		stmt = conn.createStatement();
		ps = conn.prepareStatement(SQL.ADD_EMPLOYEE.getQuery());
		ps.setString(1, "Brett Mccullan");
		ps.setString(2, "brett.mccullan@mccullan.com");
		ps.setString(3, s);
		ps.setInt(4, 1);
		ps.setInt(5, 1);
		rs = ps.executeQuery();
		if (rs.next()) {
			expected = true;
		}else {
			expected = false;
		}
		actual = empDAO.addEmployee("Daniel	Perruzza", "dperruzza@perruzza.com", 1, "Designer");
		assertEquals(expected, actual);
	}
	
	
	/**
	 * test method for GetAllEmployee(). Passed the test
	 */
	
	@Test
	public final void testGetAllEmployee(){
		List<Employee> ex_empList = new ArrayList<Employee>();
		List<Employee> act_empList = new ArrayList<Employee>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_EMPLOYEE.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				ex_empList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		act_empList.addAll(empDAO.getAllEmployee());
		assertEquals(ex_empList, act_empList);
	}
	
	
	/**
	 * test method for GetAllEmployee(). Failed the test
	 */
	
	@Test
	public final void testGetAllEmployeeFail() {
		List<Employee> listActual = new ArrayList<Employee>();
		List<Employee> listExpected = new ArrayList<Employee>();
		
		listExpected.add(new Employee("Tasia Andreason", "tasia_andreason@yahoo.com", "ty787", 0, "Architect"));
		listActual.addAll(empDAO.getAllEmployee());
		assertEquals(listExpected, listActual);
		
	}
	
	
	/**
	 * test method for changePassword(). Passed the test
	 */
	@Test
	public final void changePasswordTest() throws Exception {
		boolean expectedResult = false;
		boolean actualResult;
		try {
			ps = conn.prepareStatement(SQL.CHANGE_PASSWORD.getQuery());
			ps.setString(1, "PeteD1978");
			ps.setString(2, "pdubaldi@hotmail.com");
			rs = ps.executeQuery();
			if (rs.next()) {
				expectedResult = true;
			}else {
				expectedResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		actualResult=empDAO.changePassword("BMccullan90", "brett.mccullan@mccullan.com");
		assertEquals(expectedResult, actualResult);
	}
	
	/**
	 * test method for changePassword(). Failed the test
	 */
	
	@Test
	public final void changePasswordTestFail() throws Exception {
		boolean expectedResult = false;
		boolean actualResult;
		try {
			ps = conn.prepareStatement(SQL.CHANGE_PASSWORD.getQuery());
			ps.setString(1, "PeteD1978");
			ps.setString(2, "pdubaldi@hotmail.com");
			rs = ps.executeQuery();
			if (rs.next()) {
				expectedResult = true;
			}else {
				expectedResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		actualResult=empDAO.changePassword("BMccullan90", "eden_jayson@yahoo.com");
		assertEquals(expectedResult, actualResult);
	}
	
	/**
	 * test method for validateEmployee(). Passed the test
	 */
	
	@Test
	public final void validateEmployeeTest() {
		String expected = " ";
		String actual = " ";
		Employee expected_emp = new Employee();
		expected_emp.setFullName("James Butt");
		expected_emp.setEmpEmail("jbutt@gmail.com");
		expected_emp.setEmpPassword("Jamesb1978");
		expected_emp.setRoleNumber(0);
		expected_emp.setDesnName("Draftsman");	
		
		if(expected_emp.getEmpPassword().equals("Jamesb1978") && expected_emp.getRoleNumber() == 1) {
			expected = "Admin";
		}else if (expected_emp.getEmpPassword().equals("Jamesb1978")){
			expected = "Employee";
		}else {
			expected = "Not a registered Employee";
		}
		
		actual = empDAO.validateEmployee(expected_emp, "Jamesb1978");
		assertEquals(expected, actual);
	}
	
	
	/**
	 * test method for validateEmployee(). Failed the test
	 */
	
	@Test
	public final void validateEmployeeTestFail() {
		String expected = " ";
		String actual = " ";
		Employee expected_emp = new Employee();
		expected_emp.setFullName("James Butt");
		expected_emp.setEmpEmail("jbutt@gmail.com");
		expected_emp.setEmpPassword("Jamesb1978");
		expected_emp.setRoleNumber(0);
		expected_emp.setDesnName("Draftsman");	
		
		if(expected_emp.getEmpPassword().equals("Jamesb1978") && expected_emp.getRoleNumber() == 1) {
			expected = "Admin";
		}else if (expected_emp.getEmpPassword().equals("Jamesb1978")){
			expected = "Employee";
		}else {
			expected = "Not a registered Employee";
		}
		
		actual = empDAO.validateEmployee(expected_emp, "Jamesb1980");
		assertEquals(expected, actual);
	}

}
